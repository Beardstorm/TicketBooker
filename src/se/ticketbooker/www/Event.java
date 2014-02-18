package se.ticketbooker.www;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class Event extends JPanel{
	private String arenaName;
	private String eventName;
	private String eventDate;
	private String eventTime;
	private int ageLimit;
	private String eventDescription;
	private int numTickets;
	private JButton buyButton;
	private ImageIcon icon ;
	private JLabel arenaLabel, eventNameLabel, eventDateLabel, eventTimeLabel, ageLimitLabel, noOfTicketsLabel,imageLabel;
	private JTextArea eventDescriptionText; 
	private JPanel panel;
	
	public Event(String arenaName, String eventName, String eventDate, String eventTime, int ageLimit, String eventDescription, int numTickets, int price, Blob image) {
		setArenaName(arenaName);
		setEventName(eventName);
		setEventDate(eventDate);
		setEventTime(eventTime);
		setAgeLimit(ageLimit);
		setEventDescription(eventDescription);
		setNumTickets(numTickets);
		
		JPanel leftInfoPanel = new JPanel();
		JPanel rightInfoPanel = new JPanel();
		
		leftInfoPanel.setLayout(new GridLayout(6,1,0,0));

		eventNameLabel = new JLabel(getEventName());
		arenaLabel = new JLabel("Vart: "+getArenaName());
		eventDateLabel = new JLabel("Datum: "+getEventDate().toString());
		eventTimeLabel = new JLabel("Tid: "+getEventTime().toString());
		ageLimitLabel = new JLabel("Åldersgräns: "+Integer.toString(getAgeLimit()));
		try {
			if(image != null)
				icon = new ImageIcon(image.getBytes(1L, (int) image.length()));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imageLabel = new JLabel(icon);
		leftInfoPanel.add(imageLabel);

		leftInfoPanel.add(eventNameLabel);
		leftInfoPanel.add(arenaLabel);
		leftInfoPanel.add(eventDateLabel);
		leftInfoPanel.add(eventTimeLabel);
		leftInfoPanel.add(ageLimitLabel);
		rightInfoPanel.setLayout(new BorderLayout(0, 0));
		eventDescriptionText = new JTextArea(getEventDescription());
		eventDescriptionText.setLineWrap(true);
		eventDescriptionText.setWrapStyleWord(true);
		eventDescriptionText.setEditable(false);
		eventDescriptionText.setBackground(new Color(240, 240,240));
		eventDescriptionText.setFont(new Font(eventDescriptionText.getFont().getName(), eventDescriptionText.getFont().getStyle(), eventDescriptionText.getFont().getSize()+10));
		rightInfoPanel.add(eventDescriptionText, BorderLayout.CENTER);
		
		panel = new JPanel();
		rightInfoPanel.add(panel, BorderLayout.SOUTH);
		noOfTicketsLabel = new JLabel("Antal platser: "+Integer.toString(getNumTickets()));
		panel.add(noOfTicketsLabel);
		buyButton = new JButton("Buy");
		panel.add(buyButton);
		
		this.setLayout(new GridLayout(1,2));
		this.add(leftInfoPanel);
		this.add(rightInfoPanel);
		
		this.setPreferredSize(new Dimension(450, 350));
		this.setBorder(new LineBorder(Color.gray, 1));
		
	}

	public String getArenaName() {
		return arenaName;
	}

	public void setArenaName(String arenaName) {
		this.arenaName = arenaName;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public int getAgeLimit() {
		return ageLimit;
	}

	public void setAgeLimit(int ageLimit) {
		this.ageLimit = ageLimit;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public int getNumTickets() {
		return numTickets;
	}

	public void setNumTickets(int numTickets) {
		this.numTickets = numTickets;
	}
}
