package backend;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
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

    public static void main(String[] args) {
        Complaint_Lodging_System obj = new Complaint_Lodging_System();
    }
    

}