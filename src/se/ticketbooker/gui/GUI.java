package se.ticketbooker.gui;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import se.ticketbooker.www.Event;


public class GUI extends JFrame
{	
	private JTabbedPane tabPanel;
	private JPanel contentPane, headerPanel, buttonPanel, logoPanel, searchTabPanel,
						searchTabPanelContent, registerTabPanel, addeventTabPanel;
	
	private JPanel headerLoginPanel;
	private JPanel headerFillPanel;
	private JPanel headerLoginPanelName;
	private JPanel headerLoginPanelContent;
	private JPanel searchTabPanelContentHeader;
	private JPanel searchTabPanelContentBody;

	private JTextField searchTextField;
	private JTextField loginEmailTextField;
	private JTextField loginPasswordTextField;
	private JTextField registerEmailTextField;
	private JTextField registerPasswordTextField;
	private JTextField registerNameTextField;
	private JTextField registerPhonenrTextField;
	private JTextField addEventArenaidTextField;
	private JTextField addEventNameTextField;
	private JTextField addEventDateTextField;
	private JTextField addEventTimeTextField;
	private JTextField addEventAgelimitTextField;
	private JTextField addEventNumTicketsTextField;
	private JTextField addEventPriceTextField;

	private JScrollPane searchTabScrollPane;
	private JTextArea descriptionText;

	private JButton loginButton, logoutButton, searchButton, registerButton,addeventButton,clearButton;

	private JLabel iconLabel;
	private JLabel lblEmail, lblPassword, lblName, lblPhone; 
	private JLabel registerMessageLabel;
	private JLabel usernameHeaderLabel;
	private JLabel eventidLabel;
	private JLabel eventnameLabel;
	private JLabel dateLabel;
	private JLabel timeLabel;
	private JLabel agelimitLabel;
	private JLabel desLabel;
	private JLabel numticketLabel;
	private JLabel priceLabel;

	private ArrayList<Event> eventList;
	
	public GUI()
	{
		contentPane = new JPanel();
		headerPanel = new JPanel();
		logoPanel = new JPanel();
		iconLabel = new JLabel(new ImageIcon("resources\\ticnet.png"));
		tabPanel = new JTabbedPane();
		searchTabPanel = new JPanel();
		searchTabPanelContentHeader = new JPanel();
		searchTabPanelContentBody = new JPanel();
		registerTabPanel = new JPanel();
		registerButton = new JButton("Register");
		addeventTabPanel = new JPanel();
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

		eventidLabel = new JLabel("ArenaID");
		eventnameLabel = new JLabel("Event Name");
		dateLabel = new JLabel("Date");
		timeLabel = new JLabel("Time");
		agelimitLabel = new JLabel("Age Limit");
		desLabel = new JLabel("Description");
		numticketLabel = new JLabel("Number of Tickets");
		priceLabel = new JLabel("Price");

		headerFillPanel = new JPanel();
		headerLoginPanel = new JPanel();
		buttonPanel = new JPanel();

		addEventPriceTextField = new JTextField();
		addEventNumTicketsTextField = new JTextField();
		addEventAgelimitTextField = new JTextField();
		addEventTimeTextField = new JTextField();
		addEventDateTextField = new JTextField();
		addEventArenaidTextField = new JTextField();
		addEventNameTextField = new JTextField();
		registerMessageLabel = new JLabel("");
		loginButton = new JButton("Login");
		loginPasswordTextField = new JPasswordField();
		loginEmailTextField = new JTextField();
		headerLoginPanelContent = new JPanel();
		logoutButton = new JButton("Logout");
		headerLoginPanelName = new JPanel();

		eventList = new ArrayList<Event>();

		createAndShowGUI();
	}

	private void createAndShowGUI() 
	{

		usernameHeaderLabel = new JLabel("Logged in as #USERNAME");
		usernameHeaderLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		usernameHeaderLabel.setVisible(false);
		headerLoginPanelName.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		headerLoginPanelName.add(usernameHeaderLabel);




		FlowLayout fl_headerLoginPanelContent = new FlowLayout(FlowLayout.RIGHT, 5, 0);
		headerLoginPanelContent.setLayout(fl_headerLoginPanelContent);

		headerLoginPanelContent.add(loginEmailTextField);

		loginEmailTextField.setText("Email");
		loginEmailTextField.setColumns(10);
		loginEmailTextField.addFocusListener(new CustomFocusListener(loginEmailTextField));

		headerLoginPanelContent.add(loginPasswordTextField);
		loginPasswordTextField.setText("Password");
		loginPasswordTextField.setColumns(10);
		loginPasswordTextField.addFocusListener(new CustomFocusListener(loginPasswordTextField));

		headerLoginPanelContent.add(loginButton);
		loginButton.setActionCommand("login");
		headerLoginPanelContent.add(logoutButton);
		logoutButton.setActionCommand("logout");
		logoutButton.setEnabled(false);





		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(107, 80, 82, 14);

		lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblName.setBounds(107, 37, 82, 14);

		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(107, 122, 82, 14);

		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPhone.setBounds(107, 164, 82, 14);

		registerNameTextField.setBounds(221, 35, 165, 20);
		registerNameTextField.setColumns(18);

		registerEmailTextField.setBounds(221, 78, 165, 20);
		registerEmailTextField.setColumns(18);

		registerPasswordTextField.setBounds(221, 120, 165, 20);

		registerPhonenrTextField.setBounds(221, 158, 165, 20);
		registerPhonenrTextField.setColumns(18);

		registerButton.setBounds(314, 231, 102, 23);
		registerButton.setActionCommand("register");

		registerMessageLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		registerMessageLabel.setBounds(231, 321, 223, 20);






		eventidLabel.setBounds(48, 26, 132, 26);
		eventnameLabel.setBounds(48, 74, 132, 26);
		dateLabel.setBounds(48, 120, 132, 26);
		timeLabel.setBounds(48, 164, 132, 26);
		agelimitLabel.setBounds(48, 210, 132, 26);
		desLabel.setBounds(474, 75, 133, 24);
		numticketLabel.setBounds(48, 247, 132, 26);
		priceLabel.setBounds(48, 287, 132, 26);

		addEventArenaidTextField.setBounds(232, 29, 184, 20);
		addEventArenaidTextField.setColumns(10);

		addEventNameTextField.setText("");
		addEventNameTextField.setBounds(232, 77, 184, 20);
		addEventNameTextField.setColumns(10);

		addEventDateTextField.setText("");
		addEventDateTextField.setBounds(232, 123, 184, 20);
		addEventDateTextField.setColumns(10);

		addEventTimeTextField.setText("");
		addEventTimeTextField.setBounds(232, 167, 184, 20);
		addEventTimeTextField.setColumns(10);

		addEventAgelimitTextField.setText("");
		addEventAgelimitTextField.setBounds(232, 209, 184, 20);
		addEventAgelimitTextField.setColumns(10);

		addEventNumTicketsTextField.setText("");
		addEventNumTicketsTextField.setBounds(232, 247, 184, 20);
		addEventNumTicketsTextField.setColumns(10);

		addEventPriceTextField.setText("");
		addEventPriceTextField.setBounds(232, 289, 184, 20);
		addEventPriceTextField.setColumns(10);


		addeventButton.setBounds(157, 342, 132, 23);
		addeventButton.setActionCommand("AddEvent");

		clearButton.setBounds(440, 342, 137, 23);
		clearButton.setActionCommand("clearText");

		descriptionText.setBounds(478, 120, 229, 116);

		searchTextField.setText("Search");
		searchTextField.setColumns(25);
		searchTextField.addFocusListener(new CustomFocusListener(searchTextField));

		FlowLayout fl_searchTabPanelContentHeader = (FlowLayout) searchTabPanelContentHeader.getLayout();
		fl_searchTabPanelContentHeader.setAlignment(FlowLayout.LEFT);
		searchTabPanelContentHeader.add(searchTextField);

		searchTabPanelContent.setLayout(new BorderLayout(0, 0));
		searchTabPanelContent.add(searchTabPanelContentHeader, BorderLayout.NORTH);
		searchButton = new JButton("Search");
		
		
		
				searchButton.setActionCommand("search");
				searchTabPanelContentHeader.add(searchButton);
//		searchTabPanelContent.add(searchTabPanelContentBody, BorderLayout.CENTER);
		searchTabPanelContent.setBackground(SystemColor.menu);
		
		
		searchTabPanel.setLayout(new BorderLayout(0, 0));
		searchTabPanel.add(searchTabPanelContent, BorderLayout.CENTER);
		searchTabScrollPane = new JScrollPane(searchTabPanelContentBody);
		searchTabPanelContent.add(searchTabScrollPane, BorderLayout.CENTER);
		

		registerTabPanel.add(lblEmail);
		registerTabPanel.add(lblName);
		registerTabPanel.add(lblPassword);
		registerTabPanel.add(lblPhone);
		registerTabPanel.add(registerNameTextField);
		registerTabPanel.add(registerEmailTextField);
		registerTabPanel.add(registerPasswordTextField);
		registerTabPanel.add(registerButton);
		registerTabPanel.add(registerMessageLabel);
		registerTabPanel.add(registerPhonenrTextField);
		registerTabPanel.setLayout(null);

		addeventTabPanel.add(eventidLabel);
		addeventTabPanel.add(eventnameLabel);
		addeventTabPanel.add(dateLabel);
		addeventTabPanel.add(timeLabel);
		addeventTabPanel.add(agelimitLabel);
		addeventTabPanel.add(desLabel);
		addeventTabPanel.add(numticketLabel);
		addeventTabPanel.add(priceLabel);
		addeventTabPanel.add(addEventArenaidTextField);
		addeventTabPanel.add(addEventNameTextField);
		addeventTabPanel.add(addEventDateTextField);
		addeventTabPanel.add(addEventTimeTextField);
		addeventTabPanel.add(addEventAgelimitTextField);
		addeventTabPanel.add(addEventNumTicketsTextField);
		addeventTabPanel.add(addEventPriceTextField);
		addeventTabPanel.add(addeventButton);
		addeventTabPanel.add(clearButton);
		addeventTabPanel.add(descriptionText);
		addeventTabPanel.setLayout(null);

		tabPanel.addTab("Search", searchTabPanel);
		tabPanel.addTab("Register", registerTabPanel);
		tabPanel.addTab("Add Event", addeventTabPanel);

		logoPanel.setLayout(new GridLayout(1, 0, 0, 0));
		logoPanel.add(iconLabel);

		headerLoginPanel.add(headerLoginPanelName);
		headerLoginPanel.add(headerLoginPanelContent);
		headerLoginPanel.setLayout(new GridLayout(2, 1, 0, 0));

		buttonPanel.add(headerFillPanel);
		buttonPanel.add(headerLoginPanel);
		buttonPanel.setLayout(new GridLayout(0, 2, 0, 0));

		headerPanel.setLayout(new BorderLayout(0, 0));
		headerPanel.add(logoPanel, BorderLayout.NORTH);
		headerPanel.add(buttonPanel);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(headerPanel, BorderLayout.NORTH);
		contentPane.add(tabPanel);

		setContentPane(contentPane);
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

	

	
	//receives an eventList generated in DBHandler from a ResultSet (not written yet)
	public void addEventsToGui(ArrayList<Event> eventList){
		//if eventList is not empty, remove components from GUI and clear the list
		if(!this.eventList.isEmpty()){
				searchTabPanelContentBody.removeAll();
		}
		
		//set eventList to the one received in parameter
		this.eventList = eventList;
		
		searchTabPanelContentBody.setLayout(new GridLayout(eventList.size(), 1));
		
		//add new Events to GUI
		for(Event e : eventList){
			searchTabPanelContentBody.add(e);
		}
		
		//re-validate and repaint
		searchTabPanelContentBody.revalidate();
		searchTabPanelContentBody.repaint();
	}

	public String getSearchFieldText(){
		return searchTextField.getText();
	}
	//--Getters and Setters --//
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
		return addEventArenaidTextField;

	}
	public JTextField getTxtEventname(){
		return addEventNameTextField;

	}
	public JTextField getTxtDate(){
		return addEventDateTextField;

	}
	public JTextField getTxtTime(){
		return addEventTimeTextField;

	}
	public JTextField getTxtAgelimit(){
		return addEventAgelimitTextField;

	}
	public JTextArea getTxtDes(){
		return descriptionText;

	}
	public JTextField getTxtNumtics(){
		return addEventNumTicketsTextField;

	}
	public JTextField getTxtPrice(){
		return addEventPriceTextField;

	}

}
