package backend;

import java.util.*;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.client.DistinctIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class Regression {							//linear regression
	
	public static void main(String[] args) throws IOException {
		
		Integer[] year = new Integer[14];			//to store the years 									
		Integer[] case_inyear = new Integer[14]; 	//to store total cases for each year
		Integer total_Cases = 0,current_year,p=0;	
		
		MongoClient mc = MongoClients.create("mongodb+srv://Aditya07:Adit%405207902@cluster0.v2wojna.mongodb.net/?retryWrites=true&w=majority");   
		MongoDatabase db = mc.getDatabase("CRIME_STATISTICS");   				//selecting specific db from Mongodb server
		MongoCollection<Document> col = db.getCollection("Total_IPC");			//retrieving required collection from database
		DistinctIterable<String> iterDoc = col.distinct("Year", String.class);	//collecting distinct values of key:"Year" which is of string class type
		Iterator<String> it = iterDoc.iterator();	
		
		while(it.hasNext()) {
			current_year =Integer.parseInt(it.next());			//for first iteration of while loop, current_year=1
			Bson filter = Filters.and(Filters.eq("Year",String.valueOf(current_year)),Filters.eq("District","TOTAL"));	//filtering for specific year with District-total that contains total no. of cases for specific state
			FindIterable<Document> yrcas = col.find(filter);	//saving above filtering into an object
			Iterator<Document> itr = yrcas.iterator();
			while(itr.hasNext()) {
				total_Cases = total_Cases + Integer.parseInt(itr.next().getString("Total_IPC"));	//adding total cases of all states for a specific year
			}
			
			year[p]=current_year;	
			case_inyear[p]=total_Cases;
			p++;
			
			total_Cases = 0;    //making it zero for calculation of next year
				
		}
			
		Integer[] x = year.clone();				//cloning years array into x
		Integer[] y = case_inyear.clone();		//cloning case_inyear array into y
				
		double x_mean;
		double y_mean;
		double sum1=0;
		double sum2=0;
		
		for(int k=0;k<x.length;k++) {
			sum1+=x[k];
		}
		x_mean=(sum1)/(x.length);
		
		for(int l=0;l<y.length;l++) {
			sum2+=y[l];
		}
		y_mean=(sum2)/(y.length);

		double num=0;
		double den=0;
		
		for(int m=0;m<x.length;m++) {
			num+=(x[m]-x_mean)*(y[m]-y_mean);
			den+=(x[m]-x_mean)*(x[m]-x_mean);
		}
		
		double m = (num)/(den);
		double b = y_mean-(m*x_mean);
		
		String values = String.valueOf(m)+","+String.valueOf(b);
		Path fileName = Path.of("Values.csv"); 		//saving values of m and b in values.csv
		Files.writeString(fileName,values);
		
				
		Double y_pred = m*(2014)+b;
		System.out.print(y_pred);
	}

}
