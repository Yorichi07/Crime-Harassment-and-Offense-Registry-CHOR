package backend;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class Crimes {
    public ArrayList<Document> getCrimes(){
        MongoClient mc = MongoClients.create("mongodb+srv://Aditya07:Adit%405207902@cluster0.v2wojna.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase mcDb = mc.getDatabase("CRIME_STATISTICS");
        MongoCollection mcCol = mcDb.getCollection("Total_IPC");

        MongoCursor<Document> Mcur = mcCol.find().iterator();
        ArrayList<Document> res = new ArrayList<>();
        
        while (Mcur.hasNext()) {
            res.add(Mcur.next());
        }

        return res;
    }
}
