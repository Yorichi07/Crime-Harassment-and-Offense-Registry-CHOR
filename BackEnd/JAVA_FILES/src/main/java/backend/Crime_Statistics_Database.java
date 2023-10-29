package backend;

import java.io.*;
import java.util.*;
import com.opencsv.CSVReader;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class Crime_Statistics_Database {
	public static void main(String[] args) {
		
		MongoClient mc = MongoClients.create("mongodb+srv://Aditya07:Adit%405207902@cluster0.v2wojna.mongodb.net/?retryWrites=true&w=majority");
		MongoDatabase db = mc.getDatabase("CRIME_STATISTICS");
		MongoCollection<Document> col = db.getCollection("Total_IPC");
		ArrayList<Document> arr=new ArrayList<>();
		
		try{
			File f = new File("DATASET");  //Dataset is the name of the folder
			File[] files = f.listFiles();  //here 3 files 
			
			for(int i=0;i<files.length;i++){
				CSVReader reader = new CSVReader(new FileReader(files[i]));
				String[] nextLine;   //creating new string variable
				while((nextLine = reader.readNext())!=null){
					Document doc = new Document("State",nextLine[0].toUpperCase());
					doc.append("District",nextLine[1].toUpperCase());
					doc.append("Year",nextLine[2]);
					doc.append("Total_IPC",nextLine[nextLine.length-1]);
					arr.add(doc);	
				}
			}
			col.insertMany(arr);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}	

