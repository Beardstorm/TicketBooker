package se.ticketbooker.www;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DBHandler {
	//Instance variable declaration
	private MysqlDataSource ds;
	private Connection connection;
	private Statement statement;
	private ResultSet result;

	public void connect(String username, String password){
		ds = new MysqlDataSource();
		ds.setServerName("localhost");
		ds.setPort(3306);
		ds.setDatabaseName("Ticnet");

		connection = null;

		//try to establish a connection
		try {
			connection = ds.getConnection(User.getInstance().getRole(), null);
		} catch (SQLException e) {
			System.err.println("Error: failed to connect" + e.getMessage());
			return;
		}
		System.out.println("Connection Succesfull!");

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
		}


		//set user variables
		try {
			//place yourself on the first result row
			result.first();
			User.getInstance().setName(result.getString("name"));
			User.getInstance().setPhone(result.getString("phone"));
			User.getInstance().setEmail(result.getString("email"));
			User.getInstance().setRole(result.getString("role"));

		} catch (SQLException e) {
			System.err.println("Error: Could not find user " + e.getMessage());
		}
	}

	//Closes all resources
	public void closeConnection(){
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




}
