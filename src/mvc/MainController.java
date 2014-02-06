package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import se.ticketbooker.gui.GUI_Test;
import se.ticketbooker.www.DBHandler;

public class MainController {
	private GUI_Test gui;
	private DBHandler db;

	public MainController(GUI_Test gui, DBHandler db){
		this.gui = gui;
		this.db = db;
		
		this.gui.addButtonListener(new ButtonListener());
	}
	
	//ActionListener for the GUI
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

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
