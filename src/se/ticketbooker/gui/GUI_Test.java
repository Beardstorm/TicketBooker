package se.ticketbooker.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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




@SuppressWarnings("serial")
public class GUI_Test extends JFrame
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
	private JTextField emailTextFieldRegister;
	private JTextField passwordTextFieldRegister;
	private JTextField nameTextFieldRegister;
	private JTextField phonenrTextFieldRegister;
	private JPanel searchTabPanelContentHeader;
	private JPanel searchTabPanelContentBody;
	
	public GUI_Test()
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
		passwordTextFieldRegister = new JPasswordField();
		emailTextFieldRegister = new JTextField();
		phonenrTextFieldRegister = new JTextField();
		searchTabPanelContentBody = new JPanel();
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
		registerTabPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		emailTextFieldRegister.setText("Email");
		emailTextFieldRegister.setColumns(10);
		registerTabPanel.add(emailTextFieldRegister);
		emailTextFieldRegister.addFocusListener(new CustomFocusListener(emailTextFieldRegister));
		
		passwordTextFieldRegister.setText("Password");
		passwordTextFieldRegister.setColumns(10);
		registerTabPanel.add(passwordTextFieldRegister);
		passwordTextFieldRegister.addFocusListener(new CustomFocusListener(passwordTextFieldRegister));
		
		nameTextFieldRegister = new JTextField();
		nameTextFieldRegister.setText("Name");
		registerTabPanel.add(nameTextFieldRegister);
		nameTextFieldRegister.setColumns(10);
		nameTextFieldRegister.addFocusListener(new CustomFocusListener(nameTextFieldRegister));
		
		phonenrTextFieldRegister.setText("Phone Number");
		registerTabPanel.add(phonenrTextFieldRegister);
		phonenrTextFieldRegister.setColumns(10);
		phonenrTextFieldRegister.addFocusListener(new CustomFocusListener(phonenrTextFieldRegister));
		
		registerButton.setActionCommand("register");
		registerTabPanel.add(registerButton);
		
		searchTabPanelContent.setBackground(Color.WHITE);
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
		
		searchTabPanelContent.add(searchTabPanelContentBody, BorderLayout.CENTER);
		
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
	

}
