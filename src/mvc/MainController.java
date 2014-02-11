package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
				
				if(loginName.equals(User.getInstance().getEmail()) && loginPass.equals(User.getInstance().getPassword())){
					gui.getloggedLabel().setVisible(true);
					gui.getloggedLabel().setText(User.getInstance().getName() +" " + "is logged in");
					System.out.println("member logged in");
					//.....
									
				}
			else {//login error messages
				JOptionPane.showMessageDialog(gui,
					    "Invalid Username or Password..Try again",
					    "Login error",
					    JOptionPane.ERROR_MESSAGE);


			}

				db.disconnect();
				
				break;
			case "Register":
				db.connect();
				
				db.registerUser(gui.getNameTextFieldRegister().getText(), gui.getPasswordTextFieldRegister().getText(),
							gui.getEmailTextFieldRegister().getText(), gui.getPhonenrTextFieldRegister().getText());
				
				gui.getRegisterButton().setEnabled(false);
				gui.getRegisterMessage().setText("Registration is successful");
				try {
					db.login(gui.getEmailTextFieldRegister().getText(), gui.getPasswordTextFieldRegister().getText());
				} catch (Exception e1) {
					System.err.println("Failed to login in register method" + e1.getMessage());
				}
				db.disconnect();
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
				new MainController(new GUI(), new DBHandler());
			}

		});
	}



}
