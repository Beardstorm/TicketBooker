package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import se.ticketbooker.gui.GUI;
import se.ticketbooker.www.DBHandler;
import se.ticketbooker.www.User;

public class MainController {
	private GUI gui;
	private DBHandler db;
	
	// ROW ADDED FOR GITHUB TEST

	public MainController(GUI gui, DBHandler db){
		this.gui = gui;
		this.db = db;
		
		this.gui.addButtonListener(new ButtonListener());
	}
	
	//ActionListener for the GUI
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String action = e.getActionCommand();
			
			switch(action){
			case "search":
				System.out.println("search");

				//do stuff
				
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
				
				break;
				
			case "register":
				db.connect();
				
				db.registerUser(gui.getRegisterNameTextField().getText(), gui.getRegisterPasswordTextField().getText(),
							gui.getRegisterEmailTextField().getText(), gui.getRegisterPhonenrTextField().getText());
				
				gui.getRegisterButton().setEnabled(false);
				gui.getRegisterMessage().setText("Registration is successful");
				try {
					db.login(gui.getRegisterEmailTextField().getText(), gui.getRegisterPasswordTextField().getText());
				} catch (Exception e1) {
					System.err.println("Failed to login in register method" + e1.getMessage());
				}
				
				db.disconnect();
				break;
			case "AddEvent":
				db.connect();
				
				int arenaId = Integer.valueOf(gui.getTxtarenaid().getText());
				String eventname= gui.getTxtEventname().getText();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date date = formatter.parse(gui.getTxtDate().getText());
				SimpleDateFormat timeformat = new SimpleDateFormat("HH:mm");
				java.sql.Time time=timeformat.parse(gui.getTxtTime().getText());
				int age =Integer.valueOf(gui.getTxtAgelimit().getText());
				String des = gui.getTxtDes().getText();
				int ntickets = Integer.valueOf(gui.getTxtNumtics().getText());
				int price = Integer.valueOf(gui.getTxtPrice().getText());
				
				db.createEvent(arenaId, eventname, date, time, age, des, ntickets, price);
				db.disconnect();
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
