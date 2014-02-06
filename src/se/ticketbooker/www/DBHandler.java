package se.ticketbooker.www;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
			connection = ds.getConnection("guest", null);
		} catch (SQLException e) {
			System.err.println("Error: failed to connect" + e.getMessage());
			return;
		}
		System.out.println("Connection Succesfull!");
	}
	
	public boolean login(String username, String password){
		connect();
		if(connection != null){
			statement = null;
			try {
				statement = connection.createStatement();
			} catch (SQLException e) {
				System.err.println("Error: failed to create statement" + e.getMessage());
				return false;
			}

			try {
				result = statement.executeQuery("SELECT * FROM account WHERE email='" + username + "' AND password='" + password + "'");
			} catch (SQLException e) {
				System.err.println("Error: could not retrieve a result " + e.getMessage());
				return false;
			}
			
			if(result != null){
				disconnect();
			}

//			//set user variables
//			try {
//				//place yourself on the first result row
//				result.first();
//				User.getInstance().setName(result.getString("name"));
//				User.getInstance().setPhone(result.getString("phone"));
//				User.getInstance().setEmail(result.getString("email"));
//				User.getInstance().setRole(result.getString("role"));
//				
//				System.out.println(User.getInstance().getName());
//
//			} catch (SQLException e) {
//				System.err.println("Error: Could not find user " + e.getMessage());
//				return false;
//			}
//			// returns true if everything went as planned
//			System.out.println("true");
//			return true;
		}
		return false;
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
	}
	
	public void search(String input){
		try {
//			result = statement.executeQuery("SELECT name, date, time, age_limit, description"
//					+ "FROM event WHERE arena_id IN(SELECT arena_id FROM arena WHERE city =" + input + ")");
			statement.executeUpdate("INSERT INTO ticket(event_id, price, customer_id) VALUES('1', '100', '1')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




}
