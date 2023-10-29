package backend;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class Missing_Person_Images {

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
	
	public static void main(String[] args) throws IOException {

		String folderName = "MyFolder";
		String fileName = "MyFile.txt";
		int fileData = 42;

		Missing_Person_Images img = new Missing_Person_Images();
		img.createFolderAndFile(folderName,fileName,fileData);
	}

}
