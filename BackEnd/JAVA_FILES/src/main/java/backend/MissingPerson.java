package backend;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.bson.Document;
import org.eclipse.jetty.util.ArrayUtil;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class MissingPerson {
    public static void main(String[] args) throws FileNotFoundException, IOException, CsvValidationException {
        MongoClient mc = MongoClients.create("mongodb+srv://Aditya07:Adit%405207902@cluster0.v2wojna.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase db = mc.getDatabase("MISSING_PERSON");
        MongoCollection<Document> col = db.getCollection("Missing_Person_Info");
        ArrayList<Document> arr = new ArrayList<>();

        FileReader fileReader = new FileReader("BackEnd\\JAVA_FILES\\missing_person.csv");
        CSVReader reader = new CSVReader(fileReader);
        // CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);

        // for (CSVRecord record : csvParser) {
        //     for (String field : record) {
        //         System.out.print(field + " ");
        //     }
        //     System.out.println(); 
        // }

        String[] nextLine;
        while((nextLine = reader.readNext())!=null){
            Document doc = new Document("Name", nextLine[0]);
            if (nextLine[1].equals("") || nextLine[2].equals("") || nextLine[3].equals("") || nextLine[4].equals("") || nextLine[6].equals("") || nextLine[8].equals("") || nextLine[10].equals("") || nextLine[11].equals("") ){
                continue;
            }
            doc.append("Gender", nextLine[1]);
            doc.append("Relative", nextLine[2]);
            doc.append("Address", nextLine[3]);
            doc.append("Age", nextLine[4]);
            doc.append("Height", nextLine[6]);
            doc.append("Built", nextLine[8]);
            doc.append("District", nextLine[10]);
            doc.append("State", nextLine[11]);
            doc.append("Image", null);
            arr.add(doc);
        }
        col.insertMany(arr);
    
    }    
}
