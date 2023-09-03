package backend;

import java.io.*;
import java.util.*;
import com.opencsv.CSVReader;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.client.DistinctIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;



public class Regression {
	
	public static void main(String[] args) {
		
		Integer[] year = new Integer[14];
		Integer[] case_inyear = new Integer[14]; 
		Integer total_Cases = 0,current_year,p=0;
		
		MongoClient mc = MongoClients.create("mongodb+srv://Aditya07:Adit%405207902@cluster0.v2wojna.mongodb.net/?retryWrites=true&w=majority");   
		MongoDatabase db = mc.getDatabase("CRIME_STATISTICS");   //connecting to the database
		MongoCollection<Document> col = db.getCollection("Total_IPC");	//retrieving required collection from database
		DistinctIterable<String> iterDoc = col.distinct("Year", String.class);	//collecting distinct values of key:"Year" which is of string class type
		Iterator<String> it = iterDoc.iterator();	
		
		while(it.hasNext()) {
			current_year =Integer.parseInt(it.next());	//for first iteration of while loop, current_year=1
			Bson filter = Filters.and(Filters.eq("Year",String.valueOf(current_year)),Filters.eq("District","TOTAL"));	//filtering for specific year with only district as total which contain total number of cases for a state in a year
			FindIterable<Document> yrcas = col.find(filter);	//saving above filtering into an object
			Iterator<Document> itr = yrcas.iterator();
			while(itr.hasNext()) {
				total_Cases = total_Cases + Integer.parseInt(itr.next().getString("Total_IPC"));	//adding total cases of all states for a specific year
			}
			
//			System.out.println(current_year+" :  "+total_Cases);
			
			year[p]=current_year;	
			case_inyear[p]=total_Cases;
			p++;
			
			total_Cases = 0;    //making it zero for calculation of next year
				
		}
		
//		for(int o=0;o<year.length;o++) {
//		System.out.println(year[o]+" "+case_inyear[o]);
//		}
			
		Integer[] x = year.clone();
		Integer[] y = case_inyear.clone();
		
		
//		int i=0;
		
//		try {
//			CSVReader reader = new CSVReader(new FileReader("DATASET/test.csv"));
//			String[] nextLine;
//			while((nextLine = reader.readNext())!= null) {
//				try{
//					x[i]=Double.parseDouble(nextLine[0]);
//					y[i]=Double.parseDouble(nextLine[1]);
//				}catch(Exception e) {
//					x[i] =Double.parseDouble(nextLine[0].substring(1));
//					y[i] =Double.parseDouble(nextLine[1]);
//				}
//				i++;
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
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
		
		Double[] y_pred = new Double[84];
		
		for(int n=0;n<x.length;n++) {
			y_pred[n]=m*x[n]+b;
		}
		
		for(int q=0;q<x.length;q++) {
			System.out.println(y_pred[q]);
		}
	}

}
