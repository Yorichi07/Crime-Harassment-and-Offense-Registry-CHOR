package backend;

//Imports necessary Packages
import static spark.Spark.*;
import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.StringConcatFactory;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.Part;

import org.bson.Document;
import com.google.gson.Gson;
import com.opencsv.exceptions.CsvValidationException;


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
			res.redirect("/html/Login page/index.html");
			return "";
		});

		
		path("/api",()->{

			post("/GetMissing", (req,res)->{
				// set response content type
				res.type("application/json");

				// Post parameters
				HashMap<String,String> obj = gson.fromJson(req.body(), HashMap.class);
				

				return "";
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

				} catch (Exception e) {
					e.printStackTrace();
				}
				

			return "";
			});
		});
		
		
	}

}
