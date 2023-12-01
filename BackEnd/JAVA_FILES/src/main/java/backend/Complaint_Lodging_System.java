package backend;

import java.util.ArrayList;
import java.util.HashMap;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class Complaint_Lodging_System {

    MongoClient mc = MongoClients.create("mongodb+srv://Aditya07:Adit%405207902@cluster0.v2wojna.mongodb.net/?retryWrites=true&w=majority");
    MongoDatabase db = mc.getDatabase("COMPLAINTDB");
    MongoCollection<Document> col = db.getCollection("COMPLAINTS");
    
    public void createComplaint(String Username, String Title, String Description,String District, String State, String Status){
        Document doc = new Document("Username",Username);
        doc.append("Title", Title);
        doc.append("Description", Description);
        doc.append("District", District);
        doc.append("State", State);
        doc.append("Status", Status);
        col.insertOne(doc);
    }

    public void deleteComplaint(String Username){
        col.deleteOne(Filters.eq("Username",Username));
    }

    public void setStatus(String Username, String newStatus){
        col.updateOne(Filters.eq("Username",Username), new Document("$set",new Document("Status", newStatus)));
    }

<<<<<<< HEAD
    public static void main(String[] args) {
        Complaint_Lodging_System obj = new Complaint_Lodging_System();
    }
    
=======
    public ArrayList<Document> getComplaint(){
>>>>>>> 8235dc95895949f8911ec52d54641ffc1df9a8fc

        FindIterable<Document> cur = col.find();
        MongoCursor<Document> itr = cur.iterator();
        ArrayList<Document> res = new ArrayList<>();

        while(itr.hasNext()){
            res.add(itr.next());
        }

        return res;
    }

    public ArrayList<Document> getComplaint(HashMap<String,String> ftr){
        
        Bson fltr = Filters.and(ftr.entrySet().stream().map(el->Filters.eq(el.getKey(),el.getValue())).toArray(Bson[]::new));

        FindIterable<Document> cur = col.find(fltr);
        MongoCursor<Document> itr = cur.iterator();
        ArrayList<Document> res = new ArrayList<>();

        while(itr.hasNext()){
            res.add(itr.next());
        }
        return res;
    }
}