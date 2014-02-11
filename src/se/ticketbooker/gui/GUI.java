package se.ticketbooker.gui;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;


public class GUI extends JFrame
{	
	private JTabbedPane tabPanel;
	private JPanel contentPane, headerPanel, buttonPanel, logoPanel, searchTabPanel, searchTabPanelContent, registerTabPanel;
	private JTextField searchTextField;
	private JTextField emailTextFieldLogin;
	private JTextField passwordTextFieldLogin;
	private JButton loginButton, searchButton, registerButton;
	private JLabel iconLabel;
	private JScrollBar searchTabScrollbar;
	private JPanel headerPanelLoginPanel;
	private JPanel headerPanelFillPanel;
	private JLabel lblemail, lblpassword, lblname, lblphone; 
	private JTextField emailTextFieldRegister;
	private JTextField passwordTextFieldRegister;
	private JTextField nameTextFieldRegister;
	private JTextField phonenrTextFieldRegister;
	private JPanel searchTabPanelContentHeader;
	private JLabel loggeduserLabel;
	private JLabel registerMessageLabel;

	
	public GUI()
	{
		contentPane = new JPanel();
		headerPanel = new JPanel();
		headerPanelFillPanel = new JPanel();
		headerPanelLoginPanel = new JPanel();
		emailTextFieldLogin = new JTextField();
		passwordTextFieldLogin = new JPasswordField();
		logoPanel = new JPanel();
		iconLabel = new JLabel(new ImageIcon("resources\\ticnet.png"));
		loginButton = new JButton("Login");
		buttonPanel = new JPanel();
		tabPanel = new JTabbedPane();
		searchTabPanel = new JPanel();
		searchTabPanelContentHeader = new JPanel();
		searchButton = new JButton("Search");
		registerTabPanel = new JPanel();
		registerButton = new JButton("Register");
		lblname = new JLabel("Full Name *");
		lblemail = new JLabel("E-mail *");
		lblpassword = new JLabel("Password *");
		lblphone = new JLabel("Phone No *");
		passwordTextFieldRegister = new JPasswordField();
		emailTextFieldRegister = new JTextField();
		phonenrTextFieldRegister = new JTextField();
		nameTextFieldRegister = new JTextField();
		searchTextField = new JTextField();
		searchTabPanelContent = new JPanel();
		
		createAndShowGUI();
	}

	private void createAndShowGUI() {
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		headerPanel.setLayout(new BorderLayout(0, 0));
		contentPane.add(headerPanel, BorderLayout.NORTH);
		
		headerPanel.add(logoPanel, BorderLayout.NORTH);
		logoPanel.setLayout(new GridLayout(1, 0, 0, 0));
		logoPanel.add(iconLabel);
				
		headerPanel.add(buttonPanel);
		buttonPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		buttonPanel.add(headerPanelFillPanel);
		buttonPanel.add(headerPanelLoginPanel);
		
		headerPanelLoginPanel.setLayout(new GridLayout(1, 3, 0, 0));
		headerPanelLoginPanel.add(emailTextFieldLogin);
		
		emailTextFieldLogin.setText("Email");
		emailTextFieldLogin.setColumns(10);
		emailTextFieldLogin.addFocusListener(new CustomFocusListener(emailTextFieldLogin));
		
		headerPanelLoginPanel.add(passwordTextFieldLogin);
		passwordTextFieldLogin.setText("Password");
		passwordTextFieldLogin.setColumns(10);
		passwordTextFieldLogin.addFocusListener(new CustomFocusListener(passwordTextFieldLogin));
		
		headerPanelLoginPanel.add(loginButton);
		loginButton.setActionCommand("login");
		
		contentPane.add(tabPanel);
		
		searchTabPanel.setLayout(new BorderLayout(0, 0));
		searchTabScrollbar = new JScrollBar();
		searchTabPanel.add(searchTabScrollbar, BorderLayout.EAST);
		
		tabPanel.addTab("Search", searchTabPanel);
		tabPanel.addTab("Register", registerTabPanel);
		registerTabPanel.setLayout(null);
		
		lblemail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblemail.setBounds(107, 80, 82, 14);
		registerTabPanel.add(lblemail);
		
		lblname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblname.setBounds(107, 37, 82, 14);
		registerTabPanel.add(lblname);
		
		lblpassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblpassword.setBounds(107, 122, 82, 14);
		registerTabPanel.add(lblpassword);
		
		lblphone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblphone.setBounds(107, 164, 82, 14);
		registerTabPanel.add(lblphone);
		
		nameTextFieldRegister.setBounds(221, 35, 165, 20);
		registerTabPanel.add(nameTextFieldRegister);
		nameTextFieldRegister.setColumns(18);
		
		emailTextFieldRegister.setBounds(221, 78, 165, 20);
		registerTabPanel.add(emailTextFieldRegister);
		emailTextFieldRegister.setColumns(18);
		
		passwordTextFieldRegister.setBounds(221, 120, 165, 20);
		registerTabPanel.add(passwordTextFieldRegister);
		
		phonenrTextFieldRegister.setBounds(221, 158, 165, 20);
		registerTabPanel.add(phonenrTextFieldRegister);
		phonenrTextFieldRegister.setColumns(18);
		
		registerButton.setBounds(314, 231, 102, 23);
		registerTabPanel.add(registerButton);
		
		registerMessageLabel = new JLabel("");
		registerMessageLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		registerMessageLabel.setBounds(231, 321, 223, 20);
		registerTabPanel.add(registerMessageLabel);
		
		searchTabPanelContent.setBackground(SystemColor.menu);
		searchTabPanel.add(searchTabPanelContent, BorderLayout.CENTER);
		searchTabPanelContent.setLayout(new BorderLayout(0, 0));
		
		FlowLayout fl_searchTabPanelContentHeader = (FlowLayout) searchTabPanelContentHeader.getLayout();
		fl_searchTabPanelContentHeader.setAlignment(FlowLayout.LEFT);
		searchTabPanelContent.add(searchTabPanelContentHeader, BorderLayout.NORTH);
		
		searchTabPanelContentHeader.add(searchTextField);
		searchTextField.setText("Search");
		searchTextField.setColumns(25);
		searchTextField.addFocusListener(new CustomFocusListener(searchTextField));
		
		searchTabPanelContentHeader.add(searchButton);
		searchButton.setActionCommand("search");
		
		loggeduserLabel = new JLabel("");
		searchTabPanelContentHeader.add(loggeduserLabel);
		
		setAutoRequestFocus(false);
		setTitle("Ticketmaster");
		setResizable(false);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setVisible(true);
	}

	public void addButtonListener(ActionListener listener) {
		searchButton.addActionListener(listener);
		loginButton.addActionListener(listener);
		registerButton.addActionListener(listener);
	}
	
	public JTextField getPasswordField(){
		return passwordTextFieldLogin;
	}
	
	public JTextField getUsernameField(){
		return emailTextFieldLogin;
	}
	
	public JTextField getNameTextFieldRegister(){
		return nameTextFieldRegister;
	}

	public JTextField getEmailTextFieldRegister(){
		return emailTextFieldRegister;
	}
	
	public JTextField getPasswordTextFieldRegister(){
		return passwordTextFieldRegister;
	}
	
	public JTextField getPhonenrTextFieldRegister(){
		return phonenrTextFieldRegister;
	}
	public JLabel getloggedLabel(){
		return loggeduserLabel;
		
	}
	public JLabel getRegisterMessage(){
		return registerMessageLabel;
		
	}
	public JButton getRegisterButton(){
		return registerButton;
		
	}
}
