package se.ticketbooker.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class GUI_Test extends JFrame {


	private JPanel contentPane;
	private JTextField searchTextField;
	private JTextField usernameTextField;
	private JTextField passwordTextField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Test frame = new GUI_Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_Test() 
	{
		setAutoRequestFocus(false);
		setTitle("Ticketmaster");
		setResizable(false);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel header = new JPanel();
		contentPane.add(header, BorderLayout.NORTH);
		header.setLayout(new BorderLayout(0, 0));
		
		JPanel logo = new JPanel();
		header.add(logo, BorderLayout.NORTH);
		logo.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel(new ImageIcon("C:\\Dropbox\\Workspace\\Test\\ticnet.png"));
		logo.add(lblNewLabel);
		
		JPanel buttons = new JPanel();
		header.add(buttons);
		buttons.setLayout(new GridLayout(0, 7, 0, 0));
		
		searchTextField = new JTextField();
		buttons.add(searchTextField);
		searchTextField.setText("Search text");
		searchTextField.setColumns(10);
		searchTextField.addFocusListener(new MyFocusListener(){
			@Override
			public void focusGained(FocusEvent e)
			{
				searchTextField.setText("");
			}
		});
		
		JButton btnNewButton = new JButton("Search");
		buttons.add(btnNewButton);
		
		JPanel empty_panel_1 = new JPanel();
		buttons.add(empty_panel_1);
		
		usernameTextField = new JTextField();
		buttons.add(usernameTextField);
		usernameTextField.setText("Username");
		usernameTextField.setColumns(10);
		usernameTextField.addFocusListener(new MyFocusListener(){
			@Override
			public void focusGained(FocusEvent e)
			{
				usernameTextField.setText("");
			}
		});
		
		passwordTextField = new JTextField();
		buttons.add(passwordTextField);
		passwordTextField.setText("Password");
		passwordTextField.setColumns(10);
		passwordTextField.addFocusListener(new MyFocusListener(){
			@Override
			public void focusGained(FocusEvent e)
			{
				passwordTextField.setText("");
			}
		});
		
		JButton btnNewButton_1 = new JButton("Login");
		buttons.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Register");
		buttons.add(btnNewButton_2);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JPanel body = new JPanel();
		contentPane.add(body);
		body.setLayout(new BorderLayout(0, 0));
		
		JScrollBar scrollBar = new JScrollBar();
		body.add(scrollBar, BorderLayout.EAST);
		
		JPanel eventContents = new JPanel();
		eventContents.setBackground(Color.WHITE);
		body.add(eventContents, BorderLayout.CENTER);
	}

	
	private class MyFocusListener implements FocusListener{
		@Override
		public void focusLost(FocusEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void focusGained(FocusEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
