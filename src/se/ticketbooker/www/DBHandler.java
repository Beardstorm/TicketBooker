package se.ticketbooker.www;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

			//create a statement
			statement = null;
			try {
				statement = connection.createStatement();
			} catch (SQLException e) {
				System.err.println("Error: failed to create statement" + e.getMessage());
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



	public User getUserbymail(String mail, String password) throws Exception {
		try {

			result = statement.executeQuery("SELECT * FROM account where email = '"+ mail+ "'AND password ='"+password+"'");
			User member = new User();

			while (result.next()) {

				member.setName(result.getString("name"));
				member.setPassword(result.getString("password"));
				member.setPhone(result.getString("phone"));
				member.setEmail( result.getString("email"));
				member.setRole(result.getString("role"));

			} 
			return member; 

		} catch (Exception e) {
			throw e;

		} finally {

		}

	}


	public void registerUser( String name, String password, String mail, String phone)  {
		try {

			statement.executeUpdate("INSERT INTO ticnet.account SET Name='"+name+
					"',phone='"+phone+"',email='"+mail+"',password='"+password+"'");


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
