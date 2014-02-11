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
	private JTextField loginEmailTextField;
	private JTextField loginPasswordTextField;
	private JButton loginButton, logoutButton, searchButton, registerButton;
	private JLabel iconLabel;
	private JScrollBar searchTabScrollbar;
	private JPanel headerPanelLoginPanel;
	private JPanel headerPanelFillPanel;
	private JLabel lblEmail, lblPassword, lblName, lblPhone; 
	private JTextField registerEmailTextField;
	private JTextField registerPasswordTextField;
	private JTextField registerNameTextField;
	private JTextField registerPhonenrTextField;
	private JPanel searchTabPanelContentHeader;
	private JLabel loggeduserLabel;
	private JLabel registerMessageLabel;

	
	public GUI()
	{
		contentPane = new JPanel();
		headerPanel = new JPanel();
		headerPanelFillPanel = new JPanel();
		headerPanelLoginPanel = new JPanel();
		loginEmailTextField = new JTextField();
		loginPasswordTextField = new JPasswordField();
		logoPanel = new JPanel();
		iconLabel = new JLabel(new ImageIcon("resources\\ticnet.png"));
		loginButton = new JButton("Login");
		logoutButton = new JButton("Logout");
		buttonPanel = new JPanel();
		tabPanel = new JTabbedPane();
		searchTabPanel = new JPanel();
		searchTabPanelContentHeader = new JPanel();
		searchButton = new JButton("Search");
		registerTabPanel = new JPanel();
		registerButton = new JButton("Register");
		lblName = new JLabel("Full Name *");
		lblEmail = new JLabel("E-mail *");
		lblPassword = new JLabel("Password *");
		lblPhone = new JLabel("Phone No *");
		registerPasswordTextField = new JPasswordField();
		registerEmailTextField = new JTextField();
		registerPhonenrTextField = new JTextField();
		registerNameTextField = new JTextField();
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
		headerPanelLoginPanel.add(loginEmailTextField);
		
		loginEmailTextField.setText("Email");
		loginEmailTextField.setColumns(10);
		loginEmailTextField.addFocusListener(new CustomFocusListener(loginEmailTextField));
		
		headerPanelLoginPanel.add(loginPasswordTextField);
		loginPasswordTextField.setText("Password");
		loginPasswordTextField.setColumns(10);
		loginPasswordTextField.addFocusListener(new CustomFocusListener(loginPasswordTextField));
		
		headerPanelLoginPanel.add(loginButton);
		loginButton.setActionCommand("login");
		
		headerPanelLoginPanel.add(logoutButton);
		logoutButton.setActionCommand("logout");
		logoutButton.setVisible(false);
		
		contentPane.add(tabPanel);
		
		searchTabPanel.setLayout(new BorderLayout(0, 0));
		searchTabScrollbar = new JScrollBar();
		searchTabPanel.add(searchTabScrollbar, BorderLayout.EAST);
		
		tabPanel.addTab("Search", searchTabPanel);
		tabPanel.addTab("Register", registerTabPanel);
		registerTabPanel.setLayout(null);
		
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(107, 80, 82, 14);
		registerTabPanel.add(lblEmail);
		
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblName.setBounds(107, 37, 82, 14);
		registerTabPanel.add(lblName);
		
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(107, 122, 82, 14);
		registerTabPanel.add(lblPassword);
		
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPhone.setBounds(107, 164, 82, 14);
		registerTabPanel.add(lblPhone);
		
		registerNameTextField.setBounds(221, 35, 165, 20);
		registerTabPanel.add(registerNameTextField);
		registerNameTextField.setColumns(18);
		
		registerEmailTextField.setBounds(221, 78, 165, 20);
		registerTabPanel.add(registerEmailTextField);
		registerEmailTextField.setColumns(18);
		
		registerPasswordTextField.setBounds(221, 120, 165, 20);
		registerTabPanel.add(registerPasswordTextField);
		
		registerPhonenrTextField.setBounds(221, 158, 165, 20);
		registerTabPanel.add(registerPhonenrTextField);
		registerPhonenrTextField.setColumns(18);
		
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
		logoutButton.addActionListener(listener);
		registerButton.addActionListener(listener);
	}
	
	public JTextField getPasswordField(){
		return loginPasswordTextField;
	}
	
	public JTextField getUsernameField(){
		return loginEmailTextField;
	}
	
	public JTextField getNameTextFieldRegister(){
		return registerNameTextField;
	}

	public JTextField getEmailTextFieldRegister(){
		return registerEmailTextField;
	}
	
	public JTextField getPasswordTextFieldRegister(){
		return registerPasswordTextField;
	}
	
	public JTextField getPhonenrTextFieldRegister(){
		return registerPhonenrTextField;
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
	
	public JButton getLogoutButton(){
		return logoutButton;
		
	}
	
	public JButton getLoginButton(){
		return loginButton;
		
	}
}
