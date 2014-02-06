package se.ticketbooker.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Scrollbar;
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


@SuppressWarnings("serial")
public class GUI_Test extends JFrame
{	
	private JPanel contentPane, headerPanel, buttonPanel, logoPanel, fillPanel, bodyPanel, eventContents;
	private JTextField searchTextField;
	private JTextField usernameTextField;
	private JTextField passwordTextField;
	private JButton loginButton, registerButton, searchButton;
	private JLabel iconLabel;
	private JScrollBar scrollbar;
	
	public GUI_Test()
	{
		setAutoRequestFocus(false);
		setTitle("Ticketmaster");
		setResizable(false);
		setType(Type.UTILITY);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		headerPanel = new JPanel();
		headerPanel.setLayout(new BorderLayout(0, 0));
		contentPane.add(headerPanel, BorderLayout.NORTH);
		
		
		logoPanel = new JPanel();
		headerPanel.add(logoPanel, BorderLayout.NORTH);
		logoPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		iconLabel = new JLabel(new ImageIcon("resources\\ticnet.png"));
		logoPanel.add(iconLabel);
		
		buttonPanel = new JPanel();
		headerPanel.add(buttonPanel);
		buttonPanel.setLayout(new GridLayout(0, 7, 0, 0));
		
		searchTextField = new JTextField();
		searchTextField.setText("Search");
		searchTextField.setColumns(10);
		searchTextField.addFocusListener(new FocusListener(){
			@Override
			public void focusGained(FocusEvent e)
			{
				if(searchTextField.getText().equals("Search")){
					searchTextField.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e){
				
				if(searchTextField.getText().isEmpty()){
					searchTextField.setText("Search");
				}
			}
		});
		buttonPanel.add(searchTextField);
		
		searchButton = new JButton("Search");
		searchButton.setActionCommand("search");
		buttonPanel.add(searchButton);
		
		fillPanel = new JPanel();
		buttonPanel.add(fillPanel);
		
		usernameTextField = new JTextField();
		usernameTextField.setText("Username");
		usernameTextField.setColumns(10);
		usernameTextField.addFocusListener(new FocusListener(){
			@Override
			public void focusGained(FocusEvent e)
			{
				if(usernameTextField.getText().equals("Username"))
					usernameTextField.setText("");
			}
			public void focusLost(FocusEvent e){
				
				if(usernameTextField.getText().isEmpty()){
					usernameTextField.setText("Username");
				}
			}
		});
		buttonPanel.add(usernameTextField);
		
		passwordTextField = new JTextField();
		passwordTextField.setText("Password");
		passwordTextField.setColumns(10);
		passwordTextField.addFocusListener(new FocusListener(){
			@Override
			public void focusGained(FocusEvent e)
			{
				if(passwordTextField.getText().equals("Password"))
					passwordTextField.setText("");
			}
			public void focusLost(FocusEvent e){
				
				if(passwordTextField.getText().isEmpty()){
					passwordTextField.setText("Password");
				}
			}
		});
		buttonPanel.add(passwordTextField);
		
		loginButton = new JButton("Login");
		loginButton.setActionCommand("login");
		buttonPanel.add(loginButton);
		
		registerButton = new JButton("Register");
		registerButton.setActionCommand("register");
		buttonPanel.add(registerButton);
		
		bodyPanel = new JPanel();
		contentPane.add(bodyPanel);
		bodyPanel.setLayout(new BorderLayout(0, 0));
		
		scrollbar = new JScrollBar();
		bodyPanel.add(scrollbar, BorderLayout.EAST);
		
		eventContents = new JPanel();
		eventContents.setBackground(Color.WHITE);
		bodyPanel.add(eventContents, BorderLayout.CENTER);
	}

	public void addButtonListener(ActionListener listener) {
		searchButton.addActionListener(listener);
		loginButton.addActionListener(listener);
		registerButton.addActionListener(listener);
	}
	
	public JTextField getPasswordField(){
		return passwordTextField;
	}
	
	public JTextField getUsernameField(){
		return usernameTextField;
	}
}
