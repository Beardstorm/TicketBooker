package se.ticketbooker.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;



public class TabPane extends JFrame{
	
	private JTabbedPane tabbedPane;
	private	JPanel panel1;
	private	JPanel panel2;
	


	public TabPane()
	{
		
		setTitle( "Tabbed Pane Application" );
		setSize( 300, 200 );
		setBackground( Color.gray );

		JPanel topPanel = new JPanel();
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add( topPanel );

		// Create the tab pages
		createPage1();
		createPage2();
		

		// Create a tabbed pane
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab( "Login", panel1 );
		tabbedPane.addTab( "Register", panel2 );
		
		topPanel.add( tabbedPane, BorderLayout.CENTER );
	}
	
//	public void addButtonListener(ActionListener listener) {
//		searchButton.addActionListener(listener);
//		loginButton.addActionListener(listener);
//		registerButton.addActionListener(listener);
//	}
//	
//	public JTextField getPasswordField(){
//		return passwordTextField;
//	}
//	
//	public JTextField getUsernameField(){
//		return usernameTextField;
//	}

	public void createPage1()
	{
		panel1 = new JPanel();
		panel1.setLayout( null );

		JLabel label1 = new JLabel( "Username:" );
		label1.setBounds( 10, 15, 150, 20 );
		panel1.add( label1 );

		JTextField field = new JTextField();
		field.setBounds( 10, 35, 150, 20 );
		panel1.add( field );

		JLabel label2 = new JLabel( "Password:" );
		label2.setBounds( 10, 60, 150, 20 );
		panel1.add( label2 );

		JPasswordField fieldPass = new JPasswordField();
		fieldPass.setBounds( 10, 80, 150, 20 );
		panel1.add( fieldPass );
	}

	
	public void createPage2()
	{
		panel2 = new JPanel();
		panel2.setLayout( new GridLayout( 3, 2 ) );

		panel2.add( new JLabel( "First Name:" ) );
		panel2.add( new TextArea() );
		panel2.add( new JLabel( "Last Name :" ) );
		panel2.add( new TextArea() );
		panel2.add( new JLabel( "UserName:" ) );
		panel2.add( new TextArea() );
	}

	public static void main( String args[] )
	{
		TabPane mainFrame	= new TabPane();
		mainFrame.setVisible( true );
	}
}
