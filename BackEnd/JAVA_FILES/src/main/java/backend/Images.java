package backend;

import java.io.File;
import java.util.HashMap;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Images {
	
	public Document Imagess(HashMap UserInfo ) throws IOException {
		
		List<String> Name = new ArrayList<String>();
		MongoClient mc = MongoClients.create("mongodb+srv://Aditya07:Adit%405207902@cluster0.v2wojna.mongodb.net/?retryWrites=true&w=majority");
		MongoDatabase db = mc.getDatabase("Image");
		MongoCollection<Document> col = db.getCollection("Image_Loc");
		Document doc = new Document("Images", Name);
		
	
		
		String filename = (String) UserInfo.get("UniqueId");
		String path = "src\\main\\resources\\public\\api" + filename;
		File f1 = new File(path);
		if(f1.mkdir() == true){
			System.out.println("Folder Created with name "+filename);
		}
		
		String ImageBits = (String) UserInfo.get("Image");
		
		
		return doc;
	
		
	}
	
	
	public static void main(String[] args) {

	}

}
