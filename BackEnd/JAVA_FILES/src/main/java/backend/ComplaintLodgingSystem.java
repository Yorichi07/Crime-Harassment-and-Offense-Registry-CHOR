package backend;
import java.util.ArrayList;
import java.util.Scanner;

class Complaint{
	private String title;
	private String description;
	
	public Complaint(String title, String description) {
		this.title=title;
		this.description=description;
	}
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
}

class ComplaintSystem{
	private ArrayList<Complaint>complaints;
	
	public ComplaintSystem() {
		complaints = new ArrayList<>();
	}
	public void submitComplaints(String title, String description) {
		Complaint complaint = new Complaint(title,description);
		complaints.add(complaint);
		System.out.println("Complaint submitted successfully");
	}
	
	public void viewComplaints() {
		System.out.println("List of complaints:");
		for(int i=0;i<complaints.size();i++) {
			Complaint complaint = complaints.get(i);
			System.out.println("Complaint#" + (i+1));
			System.out.println("Title: " + complaint.getTitle());
			System.out.println("Description: " + complaint.getDescription());
			System.out.println();
		}
	}
	
}

public class ComplaintLodgingSystem {
	public static void main(String args[]) {
		ComplaintSystem complaintSystem = new ComplaintSystem();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("Complaint Lodging System of C.H.O.R");
			System.out.println("1. Submit a complaint");
			System.out.println("2. View complaints");
			System.out.println("3. EXIT");
			System.out.println("Enter your choice here: ");
			
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch(choice) {
			case 1:
				System.out.println("Enter the complaint title: ");
				String title = scanner.nextLine();
				System.out.println("Enter the complaint description: ");
				String description = scanner.nextLine();
				complaintSystem.submitComplaints(title, description);
				break;
			case 2:
				complaintSystem.viewComplaints();
				break;
			case 3:
				System.out.println("Exiting Complaint Lodging System of C.H.O.R");
				System.out.println(0);
			default:
				System.out.println("Invalid choice. Please try again");
			}
		}
	}
}
