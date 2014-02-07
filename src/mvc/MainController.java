package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import se.ticketbooker.gui.GUI_Test;
import se.ticketbooker.www.DBHandler;
import se.ticketbooker.www.User;

public class MainController {
	private GUI_Test gui;
	private DBHandler db;
	
	// ROW ADDED FOR GITHUB TEST

	public MainController(GUI_Test gui, DBHandler db){
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
				User member = new User();
				try {
					member = db.getUserbymail(gui.getUsernameField().getText(),gui.getPasswordField().getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String mail = member.getEmail();
				String pass = member.getPassword();
				String loginName = gui.getUsernameField().getText();
				String loginPass = gui.getPasswordField().getText();
				String role = member.getRole();
				
				
				if(loginName.equals(mail) && loginPass.equals(pass)){
					System.out.println("member logged in");
					//.....
					db.disconnect();
				}

				db.login(gui.getUsernameField().getText(), gui.getPasswordField().getText());
				break;
			case "Register":
				db.connect();
				User newuser = new User();
				newuser.setName(gui.getNameTextFieldRegister().getText());
				newuser.setEmail(gui.getEmailTextFieldRegister().getText());
				newuser.setPhone(gui.getPhonenrTextFieldRegister().getText());
				newuser.setPassword(gui.getPasswordTextFieldRegister().getText());
				
				String name = newuser.getName();
				String email = newuser.getEmail();
				String password = newuser.getPassword();
				String phone = newuser.getPhone();
				
				db.registerUser(name, password, email, phone);
				db.disconnect();
				System.out.println(name);
				break;
			default:
				System.out.println("default");
			}

		}

	}


	//main method
	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				new MainController(new GUI_Test(), new DBHandler());
			}

		});
	}



}
