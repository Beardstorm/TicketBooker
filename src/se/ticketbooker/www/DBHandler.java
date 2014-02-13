package se.ticketbooker.www;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import se.ticketbooker.www.User;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DBHandler{
	//Instance variable declaration
	private MysqlDataSource ds;
	private Connection connection;
	private Statement statement;
	private ResultSet result;

	public void connect()
	{
		ds = new MysqlDataSource();
		ds.setServerName("localhost");
		ds.setPort(3306);
		ds.setDatabaseName("Ticnet");

		connection = null;

		//try to establish a connection
		try {
			connection = ds.getConnection(User.getInstance().getRole(), null);
			System.out.println("Connection Succesfull!");
		} catch (SQLException e) {
			System.err.println("Error: failed to connect" + e.getMessage());
			e.printStackTrace();
			return;
		}

		if(connection != null){
			statement = null;
			try {
				statement = connection.createStatement();
			} catch (SQLException e) {
				System.err.println("Error: failed to create statement" + e.getMessage());
				return;
			}
		}

	}




	public void search(String input){
		try {
				result = statement.executeQuery("SELECT name, date, time, age_limit, description"
							+ "FROM event WHERE arena_id IN(SELECT arena_id FROM arena WHERE city =" + input + ")");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public void login(String mail, String password) throws Exception {
		try {

			result = statement.executeQuery("SELECT * FROM account where email = '"+ mail+ "'AND password ='"+password+"'");

			result.first();
			User.getInstance().setName(result.getString("name"));
			User.getInstance().setPassword(result.getString("password"));
			User.getInstance().setPhone(result.getString("phone"));
			User.getInstance().setEmail( result.getString("email"));
			User.getInstance().setRole(result.getString("role"));

		} catch (Exception e) {
			throw e;

		} finally {

		}

	}

	public void logout(){
		User.getInstance().setEmail(null);
		User.getInstance().setName(null);
		User.getInstance().setPassword(null);
		User.getInstance().setPhone(null);
		User.getInstance().setRole("guest");
	}
	

	//Closes all resources
	public void disconnect(){
		if(result != null){
			try {
				result.close();
			} catch (SQLException e) {
				System.err.println("Error: Could not close ResultSet " + e.getMessage());
			}
		}
		if(statement != null){
			try {
				statement.close();
			} catch (SQLException e) {
				System.err.println("Error: Could not close Statement " + e.getMessage());
			}
		}
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				System.err.println("Error: Could not close Connection " + e.getMessage());
			}
		}
		
		ds = null;
	}


	public void registerUser( String name, String password, String mail, String phone)  {
		try {

			statement.executeUpdate("INSERT INTO ticnet.account SET Name='"+name+
					"',phone='"+phone+"',email='"+mail+"',password='"+password+"', role='member'");


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void createTicket(){
		//make a ticket
	}
	
	public void createEvent(int arenaId,String eventname,String date,String time,int age,String des,int ntickets,int price){
		//create a new event
		try {
//			statement.executeUpdate("INSERT INTO event SET arena_id='"+arenaId+"', name = '"+eventname+"',date=STR_TO_DATE('"+date+")',time='"+time+
//					"',age_limit ='"+age+"',description = '"+des+"',num_tickets= '"+ntickets+"',price='"+price+"'");
			
			statement.executeUpdate("INSERT INTO `event` (`arena_id`,`name`,`date`,`time`,`age_limit`,`description`,`num_tickets`,`price`) VALUES ('"+arenaId+"','"+eventname+"','"+date+"','"+time+"','"+age+"','"+des+"','"+ntickets+"','"+price+"')");
		} catch (SQLException e) {
			System.err.println("quary error");
			e.printStackTrace();
		}
	}
	
	public ResultSet getEvents(){
		try {
			result = statement.executeQuery("SELECT * FROM arena INNER JOIN event WHERE arena.arena_id=event.arena_id");
		} catch (SQLException e) {
			System.err.println("could not get resultset from method getEvents " + e.getMessage());
		}
		return result;
	}
}
