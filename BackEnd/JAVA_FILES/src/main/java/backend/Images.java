package backend;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Images {

	public void createFolderAndFile(String folderName, String fileName, int fileData) throws IOException{

		//create the folder if it doesn't exist
		Path folderPath = Paths.get(folderName);
		if( !Files.exists(folderPath)){
			Files.createDirectory(folderPath);
		}

		//create the file and convert int data to string
		Path filePath = Paths.get(folderName,fileName);
		String fileDataString = Integer.toString(fileData);

		//Write the data to the file
		Files.write(filePath,fileDataString.getBytes());
	}
	
	public static void main(String[] args) {
		
	}

}
