package se.ticketbooker.www;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO account(name, phone, email, password, role) VALUES(?, ?, ?, ?, 'member')");
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, phone);
			preparedStatement.setString(3, mail);
			preparedStatement.setString(4, password);
			preparedStatement.executeUpdate();

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
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `event` (`arena_id`,`name`,`date`,`time`,`age_limit`,`description`,`num_tickets`,`price`) VALUES (?,?,?,?,?,?,?,?)");
			preparedStatement.setInt(1, arenaId);
			preparedStatement.setString(2, eventname);
			preparedStatement.setString(3, date);
			preparedStatement.setString(4, time);
			preparedStatement.setInt(5, age);
			preparedStatement.setString(6, des);
			preparedStatement.setInt(7, ntickets);
			preparedStatement.setInt(8, price);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Error: Could not create a new event " + e.getMessage());
			e.printStackTrace();
		}
	}

	public ResultSet getAllEvents(){
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM view_AllEvents");
			result = preparedStatement.executeQuery();
			
		} catch (SQLException e) {
			System.err.println("could not get resultset from method getEvents " + e.getMessage());
		}
		return result;
	}

	public ResultSet search(String input){
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT DISTINCT * FROM view_AllEvents "
					+ "WHERE event_name LIKE ?");
			preparedStatement.setString(1, "%" + input + "%");
			result = preparedStatement.executeQuery();

		} catch (SQLException e) {
			System.err.println("Error: Search method failed " + e.getMessage());
		}

		return result;
	}
}
