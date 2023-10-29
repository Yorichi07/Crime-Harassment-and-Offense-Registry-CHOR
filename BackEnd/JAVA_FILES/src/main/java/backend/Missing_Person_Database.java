package backend;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class Missing_Person_Database {
    public static void main(String[] args) throws CsvValidationException, IOException {
        MongoClient mc = MongoClients.create("mongodb+srv://Aditya07:Adit%405207902@cluster0.v2wojna.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase db = mc.getDatabase("MISSING_PERSON");
        MongoCollection<Document> col = db.getCollection("Missing_Person_Info");
        ArrayList<Document> arr = new ArrayList<>();

        FileReader fileReader = new FileReader("BackEnd\\JAVA_FILES\\missing_person.csv");
        CSVReader reader = new CSVReader(fileReader);

        String[] nextLine;
        while((nextLine = reader.readNext())!=null){
            if (nextLine[0].trim().equals("") || nextLine[1].trim().equals("") || nextLine[2].trim().equals("") || nextLine[3].trim().equals("") || nextLine[4].trim().equals("") || nextLine[6].trim().equals("") || nextLine[8].trim().equals("") || nextLine[10].trim().equals("") || nextLine[11].trim().equals("")){
                continue;
            }
            Document doc = new Document("Name", nextLine[0].trim());
            doc.append("Gender", nextLine[1].trim());
            doc.append("Relative", nextLine[2].trim());
            doc.append("Address", nextLine[3].trim());
            doc.append("Age", nextLine[4].trim());
            doc.append("Height", nextLine[6].trim());
            doc.append("Built", nextLine[8].trim());
            doc.append("District", nextLine[10].trim());
            doc.append("State", nextLine[11].trim());
            doc.append("Image", null);
            arr.add(doc);
        }
        col.insertMany(arr);
    }
}
