package se.ticketbooker.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

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
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;




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
		setAutoRequestFocus(false);
		setTitle("Ticketmaster");
		setResizable(false);
		setType(Type.UTILITY);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
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
		buttonPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		headerPanelFillPanel = new JPanel();
		buttonPanel.add(headerPanelFillPanel);
		
		headerPanelLoginPanel = new JPanel();
		buttonPanel.add(headerPanelLoginPanel);
		headerPanelLoginPanel.setLayout(new GridLayout(1, 3, 0, 0));
		
		emailTextFieldLogin = new JTextField();
		headerPanelLoginPanel.add(emailTextFieldLogin);
		emailTextFieldLogin.setText("Email");
		emailTextFieldLogin.setColumns(10);
		emailTextFieldLogin.addFocusListener(new CustomFocusListener(emailTextFieldLogin));
		
		passwordTextFieldLogin = new JPasswordField();
		headerPanelLoginPanel.add(passwordTextFieldLogin);
		passwordTextFieldLogin.setText("Password");
		passwordTextFieldLogin.setColumns(10);
		passwordTextFieldLogin.addFocusListener(new CustomFocusListener(passwordTextFieldLogin));
		
		loginButton = new JButton("Login");
		headerPanelLoginPanel.add(loginButton);
		loginButton.setActionCommand("login");
		

		
		
		tabPanel = new JTabbedPane();
		contentPane.add(tabPanel);
		
		searchTabPanel = new JPanel();
		searchTabPanel.setLayout(new BorderLayout(0, 0));
		searchTabScrollbar = new JScrollBar();
		searchTabPanel.add(searchTabScrollbar, BorderLayout.EAST);
		
		registerTabPanel = new JPanel();
		
		tabPanel.addTab("Search", searchTabPanel);
		tabPanel.addTab("Register", registerTabPanel);
		registerTabPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		emailTextFieldRegister = new JTextField();
		emailTextFieldRegister.setText("Email");
		emailTextFieldRegister.setColumns(10);
		registerTabPanel.add(emailTextFieldRegister);
		emailTextFieldRegister.addFocusListener(new CustomFocusListener(emailTextFieldRegister));
		
		passwordTextFieldRegister = new JPasswordField();
		passwordTextFieldRegister.setText("Password");
		passwordTextFieldRegister.setColumns(10);
		registerTabPanel.add(passwordTextFieldRegister);
		passwordTextFieldRegister.addFocusListener(new CustomFocusListener(passwordTextFieldRegister));
		
		nameTextFieldRegister = new JTextField();
		nameTextFieldRegister.setText("Name");
		registerTabPanel.add(nameTextFieldRegister);
		nameTextFieldRegister.setColumns(10);
		nameTextFieldRegister.addFocusListener(new CustomFocusListener(nameTextFieldRegister));
		
		phonenrTextFieldRegister = new JTextField();
		phonenrTextFieldRegister.setText("Phone Number");
		registerTabPanel.add(phonenrTextFieldRegister);
		phonenrTextFieldRegister.setColumns(10);
		phonenrTextFieldRegister.addFocusListener(new CustomFocusListener(phonenrTextFieldRegister));
		
		registerButton = new JButton("Register");
		registerButton.setActionCommand("register");
		registerTabPanel.add(registerButton);
		
		searchTabPanelContent = new JPanel();
		searchTabPanelContent.setBackground(Color.WHITE);
		searchTabPanel.add(searchTabPanelContent, BorderLayout.CENTER);
		searchTabPanelContent.setLayout(new BorderLayout(0, 0));
		
		searchTabPanelContentHeader = new JPanel();
		FlowLayout fl_searchTabPanelContentHeader = (FlowLayout) searchTabPanelContentHeader.getLayout();
		fl_searchTabPanelContentHeader.setAlignment(FlowLayout.LEFT);
		searchTabPanelContent.add(searchTabPanelContentHeader, BorderLayout.NORTH);
		
		searchTextField = new JTextField();
		searchTabPanelContentHeader.add(searchTextField);
		searchTextField.setText("Search");
		searchTextField.setColumns(25);
		searchTextField.addFocusListener(new CustomFocusListener(searchTextField));
		
		searchButton = new JButton("Search");
		searchTabPanelContentHeader.add(searchButton);
		searchButton.setActionCommand("search");
		
		searchTabPanelContentBody = new JPanel();
		searchTabPanelContent.add(searchTabPanelContentBody, BorderLayout.CENTER);
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
