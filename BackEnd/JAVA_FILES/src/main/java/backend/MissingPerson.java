package backend;

import java.util.ArrayList;
import java.util.HashMap;

import org.bson.conversions.Bson;
import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MissingPerson {

    public ArrayList<Document> getMissing_Person() {       
        MongoClient mc = MongoClients.create("mongodb+srv://Aditya07:Adit%405207902@cluster0.v2wojna.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase db = mc.getDatabase("MISSING_PERSON");
        MongoCollection<Document> col = db.getCollection("Missing_Person_Info");

        MongoCursor<Document> cursor = col.find().iterator();

        ArrayList<Document> arr = new ArrayList<>();

        while (cursor.hasNext()) {
            Document doc = cursor.next();
            arr.add(doc);
        }

        return arr;
    }

    public ArrayList<Document> getMissing_Person(HashMap<String, String> filterMap) {      //polymorphism
        MongoClient mc = MongoClients.create("mongodb+srv://Aditya07:Adit%405207902@cluster0.v2wojna.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase db = mc.getDatabase("MISSING_PERSON");
        MongoCollection<Document> col = db.getCollection("Missing_Person_Info");

        ArrayList<Document> arr = new ArrayList<>();

        // defining the filtercondition
        Bson filterConditions = Filters.and(filterMap.entrySet().stream()
                .map(entry -> Filters.eq(entry.getKey(), entry.getValue())).toArray(Bson[]::new));

        try (MongoCursor<Document> cursor = col.find(filterConditions).iterator()) {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                arr.add(doc);
            }
        }
        return arr;
        //Filters.and() it is used to combine multiple filter conditions using logical AND
        //filterMap.entrySet().stream() takes entries of filterMap and converts them into a stream of key-value pairs(entries).
        //.map(entry -> Filters.eq(entry.getKey(), entry.getValue())) here each entry in the stream is mapped to a filter condition using the Filters.eq
        //.toArray(Bson[]::new) it transforms each entry into 'Bson' filter condition condition and collects these filter condition into an array of Bson objects.
    }   
    
}
