package backend;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.bson.conversions.Bson;
import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MissingPerson {

    public void getMissing_Person(Map<String,Object> filterMap){
        MongoClient mc = MongoClients.create("mongodb+srv://Aditya07:Adit%405207902@cluster0.v2wojna.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase db = mc.getDatabase("MISSING_PERSON");
        MongoCollection<Document> col = db.getCollection("Missing_Person_Info");
        
        Bson filterConditions = Filters.and(filterMap.entrySet().stream().map(entry -> Filters.eq(entry.getKey(), entry.getValue())).toArray(Bson[]::new));

        try(MongoCursor<Document> cursor = col.find(filterConditions).iterator()){
            while(cursor.hasNext()){
                Document doc = cursor.next();
                System.out.println("\n\n");
                System.out.println(doc.toJson());
            }
        }    
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter Field: ");
        String Key = sc.nextLine();

        System.out.println("Enter Value: ");
        Object Value = sc.nextLine();

        Map<String, Object> filterMap = new HashMap<>();
        filterMap.put(Key,Value);
        
        MissingPerson obj = new MissingPerson();
        obj.getMissing_Person(filterMap);
     }    
}
