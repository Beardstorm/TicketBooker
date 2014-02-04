package se.ticketbooker.www;

public class Main {
	public static void main(String[] args){
		DBHandler dbh = new DBHandler();
		dbh.connect("viktor@localhost.com", "skagget");
		
		System.out.println(User.getInstance().getRole());
	}
}
