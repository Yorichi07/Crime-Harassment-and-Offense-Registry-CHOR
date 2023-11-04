package backend;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class Missing_Person_Images {

	public void createFolderAndFile(String folderName, String fileName, byte[] fileData) throws IOException{

		//create the folder if it doesn't exist
		Path folderPath = Paths.get(folderName);
		if( !Files.exists(folderPath)){
			Files.createDirectory(folderPath);
		}

		//create the file and convert int data to string
		Path filePath = Paths.get(folderName,fileName);

		//Write the data to the file
		Files.write(filePath,fileData);
	}

}
