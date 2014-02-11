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
import javax.swing.SwingConstants;
import javax.swing.JTextArea;


public class GUI extends JFrame
{	
	private JTabbedPane tabPanel;
	private JPanel contentPane, headerPanel, buttonPanel, logoPanel, searchTabPanel, searchTabPanelContent, registerTabPanel,addeventTabPanel;
	private JTextField searchTextField;
	private JTextField loginEmailTextField;
	private JTextField loginPasswordTextField;
	private JButton loginButton, logoutButton, searchButton, registerButton,addeventButton,clearButton;
	private JLabel iconLabel;
	private JScrollBar searchTabScrollbar;
	private JPanel headerLoginPanel;
	private JPanel headerFillPanel;
	private JLabel lblEmail, lblPassword, lblName, lblPhone; 
	private JTextField registerEmailTextField;
	private JTextField registerPasswordTextField;
	private JTextField registerNameTextField;
	private JTextField registerPhonenrTextField;
	private JPanel searchTabPanelContentHeader;
	private JLabel registerMessageLabel;
	private JPanel headerLoginPanelName;
	private JPanel headerLoginPanelContent;
	private JLabel usernameHeaderLabel;
	private JTextField txtarenaid;
	private JTextField txteventName;
	private JTextField txtDate;
	private JTextField txtTime;
	private JTextField txtAgelimit;
	private JTextField txtNumTic;
	private JTextField txtPrice;
	JTextArea descriptionText;

	
	public GUI()
	{
		contentPane = new JPanel();
		headerPanel = new JPanel();
		logoPanel = new JPanel();
		iconLabel = new JLabel(new ImageIcon("resources\\ticnet.png"));
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
		addeventButton = new JButton("Add Event");
		clearButton = new JButton("Clear Text");
		descriptionText = new JTextArea();
		
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
		headerFillPanel = new JPanel();
		headerLoginPanel = new JPanel();
		buttonPanel = new JPanel();
		
		headerPanel.add(buttonPanel);
		buttonPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		buttonPanel.add(headerFillPanel);
		buttonPanel.add(headerLoginPanel);
		headerLoginPanel.setLayout(new GridLayout(2, 1, 0, 0));
		
		headerLoginPanelName = new JPanel();
		headerLoginPanel.add(headerLoginPanelName);
		
		usernameHeaderLabel = new JLabel("Logged in as #USERNAME");
		usernameHeaderLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		usernameHeaderLabel.setVisible(false);
		headerLoginPanelName.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		headerLoginPanelName.add(usernameHeaderLabel);
		
		
		headerLoginPanelContent = new JPanel();
		headerLoginPanel.add(headerLoginPanelContent);
		FlowLayout fl_headerLoginPanelContent = new FlowLayout(FlowLayout.RIGHT, 5, 0);
		headerLoginPanelContent.setLayout(fl_headerLoginPanelContent);
		loginEmailTextField = new JTextField();
		headerLoginPanelContent.add(loginEmailTextField);
		
		loginEmailTextField.setText("Email");
		loginEmailTextField.setColumns(10);
		loginEmailTextField.addFocusListener(new CustomFocusListener(loginEmailTextField));
		loginPasswordTextField = new JPasswordField();
		headerLoginPanelContent.add(loginPasswordTextField);
		loginPasswordTextField.setText("Password");
		loginPasswordTextField.setColumns(10);
		loginPasswordTextField.addFocusListener(new CustomFocusListener(loginPasswordTextField));
		loginButton = new JButton("Login");
		headerLoginPanelContent.add(loginButton);
		loginButton.setActionCommand("login");
		logoutButton = new JButton("Logout");
		headerLoginPanelContent.add(logoutButton);
		logoutButton.setActionCommand("logout");
		logoutButton.setEnabled(false);
		
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
		registerButton.setActionCommand("register");
		
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
		addeventTabPanel = new JPanel();
		addeventTabPanel.setLayout(null);
		
		JLabel eventidLabel = new JLabel("ArenaID");
		eventidLabel.setBounds(48, 26, 132, 26);
		addeventTabPanel.add(eventidLabel);
		
		JLabel eventnameLabel = new JLabel("Event Name");
		eventnameLabel.setBounds(48, 74, 132, 26);
		addeventTabPanel.add(eventnameLabel);
		
		JLabel dateLabel = new JLabel("Date");
		dateLabel.setBounds(48, 120, 132, 26);
		addeventTabPanel.add(dateLabel);
		
		JLabel timeLabel = new JLabel("Time");
		timeLabel.setBounds(48, 164, 132, 26);
		addeventTabPanel.add(timeLabel);
		
		JLabel agelimitLabel = new JLabel("Age Limit");
		agelimitLabel.setBounds(48, 210, 132, 26);
		addeventTabPanel.add(agelimitLabel);
		
		JLabel desLabel = new JLabel("Description");
		desLabel.setBounds(474, 75, 133, 24);
		addeventTabPanel.add(desLabel);
		
		JLabel numticketLabel = new JLabel("Number of Tickets");
		numticketLabel.setBounds(48, 247, 132, 26);
		addeventTabPanel.add(numticketLabel);
		
		JLabel priceLabel = new JLabel("Price");
		priceLabel.setBounds(48, 287, 132, 26);
		addeventTabPanel.add(priceLabel);
		tabPanel.addTab("Add Event",addeventTabPanel);
		
		txtarenaid = new JTextField();
		txtarenaid.setBounds(232, 29, 184, 20);
		addeventTabPanel.add(txtarenaid);
		txtarenaid.setColumns(10);
		
		txteventName = new JTextField();
		txteventName.setText("");
		txteventName.setBounds(232, 77, 184, 20);
		addeventTabPanel.add(txteventName);
		txteventName.setColumns(10);
		
		txtDate = new JTextField();
		txtDate.setText("");
		txtDate.setBounds(232, 123, 184, 20);
		addeventTabPanel.add(txtDate);
		txtDate.setColumns(10);
		
		txtTime = new JTextField();
		txtTime.setText("");
		txtTime.setBounds(232, 167, 184, 20);
		addeventTabPanel.add(txtTime);
		txtTime.setColumns(10);
		
		txtAgelimit = new JTextField();
		txtAgelimit.setText("");
		txtAgelimit.setBounds(232, 209, 184, 20);
		addeventTabPanel.add(txtAgelimit);
		txtAgelimit.setColumns(10);
		
		txtNumTic = new JTextField();
		txtNumTic.setText("");
		txtNumTic.setBounds(232, 247, 184, 20);
		addeventTabPanel.add(txtNumTic);
		txtNumTic.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setText("");
		txtPrice.setBounds(232, 289, 184, 20);
		addeventTabPanel.add(txtPrice);
		txtPrice.setColumns(10);
		
		
		addeventButton.setBounds(157, 342, 132, 23);
		addeventTabPanel.add(addeventButton);
		addeventButton.setActionCommand("AddEvent");
		
		
		clearButton.setBounds(440, 342, 137, 23);
		addeventTabPanel.add(clearButton);
		clearButton.setActionCommand("clearText");
		
		
		descriptionText.setBounds(478, 120, 229, 116);
		addeventTabPanel.add(descriptionText);
		
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
		addeventButton.addActionListener(listener);
		clearButton.addActionListener(listener);
	}
	
	public JTextField getPasswordField(){
		return loginPasswordTextField;
	}
	
	public JTextField getUsernameField(){
		return loginEmailTextField;
	}
	
	public JTextField getRegisterNameTextField(){
		return registerNameTextField;
	}

	public JTextField getRegisterEmailTextField(){
		return registerEmailTextField;
	}
	
	public JTextField getRegisterPasswordTextField(){
		return registerPasswordTextField;
	}
	
	public JTextField getRegisterPhonenrTextField(){
		return registerPhonenrTextField;
	}
	
	public JPanel getHeaderLoginPanel()
	{
		return headerLoginPanel;
	}
	
	public JLabel getUsernameHeaderLabel()
	{
		return usernameHeaderLabel;
	}
	
	public JLabel getRegisterMessage()
	{
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
	
	public JTextField getTxtarenaid(){
		return txtarenaid;
		
	}
	public JTextField getTxtEventname(){
		return txteventName;
		
	}
	public JTextField getTxtDate(){
		return txtDate;
		
	}
	public JTextField getTxtTime(){
		return txtTime;
		
	}
	public JTextField getTxtAgelimit(){
		return txtAgelimit;
		
	}
	public JTextArea getTxtDes(){
		return descriptionText;
		
	}
	public JTextField getTxtNumtics(){
		return txtNumTic;
		
	}
	public JTextField getTxtPrice(){
		return txtPrice;
		
	}
	
}
