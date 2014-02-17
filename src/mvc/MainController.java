package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import se.ticketbooker.gui.GUI;
import se.ticketbooker.www.DBHandler;
import se.ticketbooker.www.Event;
import se.ticketbooker.www.User;

public class MainController {
	private GUI gui;
	private DBHandler db;
	private ArrayList<Event> eventList;

	public MainController(GUI gui, DBHandler db){
		this.gui = gui;
		this.db = db;

		eventList = new ArrayList<Event>();

		this.gui.addButtonListener(new ButtonListener());
	}

	//ActionListener for the GUI
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String action = e.getActionCommand();

			switch(action){
			case "search":
				db.connect();
				
				if(!eventList.isEmpty())
					eventList.clear();

				String searchText = gui.getSearchFieldText();
				System.out.println(searchText);
				if(searchText.equals("Search") || searchText.equals("")){
					ResultSet result = db.getAllEvents();
					try {
						result.beforeFirst();
						while(result.next()){
							eventList.add(new Event(result.getString(1), result.getString(2), result.getString(3),
									result.getString(4), result.getInt(5), result.getString(6), result.getInt(7), result.getInt(8),result.getBlob(9)));
						}
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

					gui.addEventsToGui(eventList);
			}
			else {
				
				ResultSet result = db.search(searchText);
				try {
					result.beforeFirst();
					while(result.next()){
						eventList.add(new Event(result.getString(1), result.getString(2), result.getString(3),
								result.getString(4), result.getInt(5), result.getString(6), result.getInt(7), result.getInt(8),result.getBlob(9)));
					}
				} catch (SQLException e2) {
					System.err.println("Error: Could not retrieve events " + e2.getMessage());
				}

				gui.addEventsToGui(eventList);
				
			}
				db.disconnect();
				break;

		case "login":
			db.connect();

			try {
				db.login(gui.getUsernameField().getText(),gui.getPasswordField().getText());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			String loginName = gui.getUsernameField().getText();
			String loginPass = gui.getPasswordField().getText();

			if(loginName.equals(User.getInstance().getEmail()) && loginPass.equals(User.getInstance().getPassword()))
			{
				gui.getLoginButton().setEnabled(false);
				gui.getUsernameField().setEnabled(false);
				gui.getPasswordField().setEnabled(false);
				gui.getLogoutButton().setEnabled(true);

				gui.getUsernameHeaderLabel().setVisible(true);
				gui.getUsernameHeaderLabel().setText("Logged in as " + User.getInstance().getName());
			}
			else {//login error messages
				JOptionPane.showMessageDialog(gui,
						"Invalid Username or Password..Try again",
						"Login error",
						JOptionPane.ERROR_MESSAGE);
			}

			db.disconnect();
			break;

		case "logout":
			db.logout();

			gui.getLoginButton().setEnabled(true);
			gui.getUsernameField().setEnabled(true);
			gui.getPasswordField().setEnabled(true);
			gui.getLogoutButton().setEnabled(false);
			gui.getUsernameHeaderLabel().setVisible(false);
			gui.getUsernameHeaderLabel().setText("");

			db.disconnect();
			break;

		case "register":
			db.connect();

			db.registerUser(gui.getRegisterNameTextField().getText(), gui.getRegisterPasswordTextField().getText(),
					gui.getRegisterEmailTextField().getText(), gui.getRegisterPhonenrTextField().getText());

			gui.getRegisterButton().setEnabled(false);

			try {
				db.login(gui.getRegisterEmailTextField().getText(), gui.getRegisterPasswordTextField().getText());
				gui.getRegisterMessage().setText("Registration is successful \n You're logged in");
			} catch (Exception e1) {
				System.err.println("Failed to login in register method" + e1.getMessage());
			}

			db.disconnect();
			break;
		case "AddEvent":
			db.connect();

			int arenaId = Integer.valueOf(gui.getTxtarenaid().getText());
			String eventname= gui.getTxtEventname().getText();
			String date = gui.getTxtDate().getText();
			String time = gui.getTxtTime().getText();

			int age =Integer.valueOf(gui.getTxtAgelimit().getText());
			String des = gui.getTxtDes().getText();
			int ntickets = Integer.valueOf(gui.getTxtNumtics().getText());
			int price = Integer.valueOf(gui.getTxtPrice().getText());

			db.createEvent(arenaId, eventname, date, time, age, des, ntickets, price);
			db.disconnect();
			break;
		
		case "clearText":
			gui.getTxtarenaid().setText("");
			gui.getTxtEventname().setText("");
			gui.getTxtDate().setText("");
			gui.getTxtTime().setText("");

			gui.getTxtAgelimit().setText("");
			gui.getTxtDes().setText("");
			gui.getTxtNumtics().setText("");
			gui.getTxtPrice().setText("");

			break;

		default:
			System.out.println("default case");
		}
	}
}


//main method
public static void main(String[] args){
	javax.swing.SwingUtilities.invokeLater(new Runnable(){

		@Override
		public void run() {
			new MainController(new GUI(), new DBHandler());
		}

	});
}
}
