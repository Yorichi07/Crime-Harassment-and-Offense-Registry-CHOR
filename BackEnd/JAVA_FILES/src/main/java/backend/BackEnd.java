package backend;

//Imports necessary Packages
import static spark.Spark.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.Part;
import com.opencsv.CSVReader;

import org.bson.Document;
import com.google.gson.Gson;
import com.opencsv.exceptions.CsvValidationException;

import org.json.simple.*;
import org.json.simple.parser.*;


public class BackEnd {
	
	public Document Signup(String Username,String Password,String Name,String PhoneNo) {
		Document res = new Document();
		SignUpBackend sgnObj = new SignUpBackend();
		try {
			res = sgnObj.addUser(Name, Username, PhoneNo, Password);
		} catch (CsvValidationException | NoSuchAlgorithmException | IOException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public Document Login(String Username,String Password) {
		Document res = new Document();
		Login_backend lgnObj = new Login_backend();
		
		res = lgnObj.verifyUser(Username, Password);
		
		return res;
	}

	public static void main(String[] args) {

		//Json file read 
		JSONParser pars = new JSONParser();
		
		// Initializing the chat result HashMap
		ChatbotBackend cbknd = new ChatbotBackend();
		cbknd.createbot();

		// Instantiating the Backend Class to call required methods
		BackEnd bkdObj = new BackEnd();
		// Initialize the Gson Object
		Gson gson = new Gson();
		
		// Specifying the port on which the requests will be listened
		port(8080);

		// Set folder for access of static files
		staticFiles.location("/public");

		
		
		options("/*",(req,res)->{
			String accessControlRequestHeaders = req.headers("Access-Control-Request-Headers");
			if (accessControlRequestHeaders != null) {
	            res.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
	        }
			
			String accessControlRequestMethod = req.headers("Access-Control-Request-Method");
	        if (accessControlRequestMethod != null) {
	            res.header("Access-Control-Allow-Methods", accessControlRequestMethod);
	        }
	        
	        return "OK";
			
		});
		
		before((req,res)->{
			res.header("Access-Control-Allow-Origin", "*");
			res.header("Access-Control-Allow-Headers", "Content-Type");
			res.header("Access-Control-Allow-Methods", "POST, GET, HEAD");
			res.type("");
			
		});

		// Get html Pages

		//Login Page
		get("/Login", (req,res)->{
			res.type("text/html");
			res.redirect("/html/Login Page/index.html");
			return "";
		});

		
		path("/api",()->{

			get("/getCoords", (req,res)->{
				res.type("application/json");
				try {
					Object obj = pars.parse(new FileReader("BackEnd\\JAVA_FILES\\name.json"));
					JSONObject jsob = (JSONObject)obj;
					return jsob;
				} catch (Exception e) {
					System.out.println(e);
				}
				return "";
			});

			post("/GetComplaints", (req,res)->{
				
				HashMap<String,String> robj = gson.fromJson(req.body(),HashMap.class);
				Complaint_Lodging_System cls = new Complaint_Lodging_System();

				ArrayList<Document> resp = cls.getComplaint(robj);
				
				return gson.toJson(resp);
			});

			get("/GetComplaints", (req,res)->{
				res.type("application/json");

				Complaint_Lodging_System cls = new Complaint_Lodging_System();

				ArrayList<Document> resp = cls.getComplaint();
				
				return gson.toJson(resp);
			});

			post("/ChatBot", (req,res)->{
				res.type("application/json");

				String[] rarr  = gson.fromJson(req.body(), String[].class);
				String ans = cbknd.resolveCrimeDescription(rarr[0], rarr[1]);

				return ans;
			});

			post("/Complaints/Add",(req,res)->{
				res.type("application/json");

				Document cmpo = gson.fromJson(req.body(), Document.class);
				Complaint_Lodging_System cls = new Complaint_Lodging_System();

				cls.createComplaint((String)cmpo.get("UserName"),(String) cmpo.get("Title"),(String) cmpo.get("Description"),(String) cmpo.get("District"),(String) cmpo.get("State"),(String) cmpo.get("Status"));

				return "Complaint Added";
			});

			post("/Complaints/SetStatus", (req,res)->{
				res.type("application/json");

				HashMap<String,String> reParam = gson.fromJson(req.body(), HashMap.class);

				Complaint_Lodging_System cls = new Complaint_Lodging_System();
				cls.setStatus(reParam.get("_id"), reParam.get("Status"));

				return "Status updated";
			});

			get("/getPredict/:Year", (req,res)->{
				
				res.type("application/json");

				CSVReader obj = new CSVReader(new FileReader("BackEnd\\JAVA_FILES\\Values_m_b.csv"));

				String[] nxtLine = obj.readNext();
				Double weight = Double.parseDouble(nxtLine[0]);
				Double bias = Double.parseDouble(nxtLine[1]);
				Integer Year = Integer.parseInt(req.params("Year"));

				Double expOtp = weight*Year + bias;


				return gson.toJson(expOtp.intValue());
			});

			get("/getCrimes", (req,res)->{
				Crimes Cobj = new Crimes();
				ArrayList<Document> arr = Cobj.getCrimes();
				return gson.toJson(arr);
			});

			get("/GetMissing", (req,res)->{
				res.type("application/json");
				
				MissingPerson mpo = new MissingPerson();
				ArrayList<Document> arr = mpo.getMissing_Person(); 
				
				return gson.toJson(arr);
			});

			post("/GetMissing", (req,res)->{
				// set response content type
				res.type("application/json");

				// Post parameters
				Document introbj  = gson.fromJson(req.body(), Document.class);
				HashMap<String,String> obj = new HashMap<>();
				for(String key:introbj.keySet()){
					obj.put(key, (String)introbj.get(key));
				}
				MissingPerson mpo = new MissingPerson();
				ArrayList arr = mpo.getMissing_Person(obj);

				return gson.toJson(arr);
			});

			//SignUp			
			post("/SignUpUser","application/json",(req,res)->{
				res.type("application/json");
				// Post Request Body
				Document reqBdy = gson.fromJson(req.body(), Document.class);
				
				// Calling The Signup Function
				Document respo = bkdObj.Signup(reqBdy.getString("UserName"),reqBdy.getString("PassWord"),reqBdy.getString("Name"),reqBdy.getString("PhoneNo"));
				
				return gson.toJson(respo);
			});
			
			//Login
			post("/LoginUser",(req,res)->{
				res.type("application/json");
				//Post request body
				Document reqBdy = gson.fromJson(req.body(), Document.class);
				
				//Calling Login Function
				Document respo = bkdObj.Login(reqBdy.getString("UserName"), reqBdy.getString("PassWord"));
				return gson.toJson(respo);
			});

			// Image Upload
			post("/Missing/ImgUpload", (req,res)->{

				// defining form data to obtain image from the request
				res.type("multipart/form-data");
				req.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));

				// file from the form-data
				Part uploadedFile = null;
				try {
					//get the file element from the request
					uploadedFile = req.raw().getPart("file");

					//Convert file to byteStream
					InputStream inp = uploadedFile.getInputStream();

					// Map for rest of the parameters
					Map<String,String[]> paramerterMap = req.raw().getParameterMap();

					// Save file
					Missing_Person_Images mpi = new Missing_Person_Images();
					String pathString =".\\BackEnd\\JAVA_FILES\\src\\main\\resources\\public\\Images\\";
					pathString = pathString.concat(paramerterMap.get("user")[0]);
					mpi.createFolderAndFile(pathString, uploadedFile.getSubmittedFileName(), inp.readAllBytes());
					return gson.toJson("Image Uplaoded at: http://localhost:8080/Images/"+paramerterMap.get("user")[0]+"/"+uploadedFile.getSubmittedFileName());
				} catch (Exception e) {
					e.printStackTrace();
					return gson.toJson(e);
				}
			});
		});
		
		
	}

}
