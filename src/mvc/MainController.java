package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import se.ticketbooker.gui.GUI_Test;
import se.ticketbooker.www.DBHandler;

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
				db.search("Stockholm");
				//do stuff
				db.disconnect();
				break;
			case "login":
				db.login(gui.getUsernameField().getText(), gui.getPasswordField().getText());
				
				break;
			case "register":
				System.out.println("register");
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
