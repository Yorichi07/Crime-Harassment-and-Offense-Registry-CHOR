package backend;

import java.io.*;
import java.util.*;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.client.*;
import com.mongodb.client.model.*;
import javax.crypto.*; 
import java.nio.charset.StandardCharsets;  
import java.security.*;  
import javax.crypto.*; 

public class SignUpBackend {
	
	static String Encrypt(String Password) throws CsvValidationException, IOException {
		
		String secret_key,salt_val;
		CSVReader reader = new CSVReader(new FileReader("Param.csv"));
		String[] nextLine;
		nextLine = reader.readNext();
		secret_key = nextLine[0];
		salt_val = nextLine[1];
		
		return null;
	}
	
	
	public Document addUser(String Name, String UserName, String PhoneNo, String Password) {
		
		MongoClient mc = MongoClients.create("mongodb+srv://Aditya07:Adit%405207902@cluster0.v2wojna.mongodb.net/?retryWrites=true&w=majority");
		MongoDatabase db = mc.getDatabase("USERS_INFO");
		MongoCollection<Document> col = db.getCollection("USERS");
		Bson filters = Filters.and(Filters.eq("UserName",UserName));
		FindIterable<Document> fr = col.find(filters);
		Iterator<Document> it = fr.iterator();	
		if(it.hasNext()){
			Document res = new Document("ResCode",409);
			res.append("Msg","User already exists!");
			return res;
		}
		
		
		Document res = new Document("UserName",UserName);
		res.append("Name",Name);
		res.append("Phone_Number",PhoneNo);
		res.append("Password",Password);
		
		
		return null;
		
	}

	public static void main(String[] args) {

	}

}
