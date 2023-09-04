package backend;
import java.util.Iterator;

import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.client.DistinctIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class Login_backend {
	
	
	public Document verifyUser(String Username, String Password){
		MongoClient mc = MongoClients.create("connection string - mongodb+srv://Aditya07:Adit%405207902@cluster0.v2wojna.mongodb.net/?retryWrites=true&w=majority");
		MongoDatabase db = mc.getDatabase("USERS_INFO");
		MongoCollection<Document> col = db.getCollection("USERS");
		Bson filters = Filters.eq("USERS",Username);
		FindIterable<Document> fr = col.find(filters);
		Iterator<Document> it = fr.iterator();
		if(it.next() == null) {
			Document res = new Document("ResCode",404);
			res.append("Msg","User does not exist");
			return res;
		}
		Document userinfo = it.next();
		String Pass = userinfo.getString("PassWord");
		
		
		
		if(Pass == Password) {
			Document res = new Document("ResCode",200);
			res.append("Msg","User Logged In");
			return res;
		}else {
			Document res = new Document("ResCode",401);
			res.append("Msg", "Incorrect Password");
			return res;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
