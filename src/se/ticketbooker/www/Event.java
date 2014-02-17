package se.ticketbooker.www;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

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
	private JLabel arenaLabel, eventNameLabel, eventDateLabel, eventTimeLabel, ageLimitLabel, descriptionLabel, noOfTicketsLabel,imageLabel;
	
	public Event(String arenaName, String eventName, String eventDate, String eventTime, int ageLimit, String eventDescription, int numTickets, int price,Blob image) {
		setArenaName(arenaName);
		setEventName(eventName);
		setEventDate(eventDate);
		setEventTime(eventTime);
		setAgeLimit(ageLimit);
		setEventDescription(eventDescription);
		setNumTickets(numTickets);
		
		JPanel leftInfoPanel = new JPanel();
		JPanel rightInfoPanel = new JPanel();
		
		leftInfoPanel.setLayout(new GridLayout(5,1,5,5));
		rightInfoPanel.setLayout(new FlowLayout());
		
		arenaLabel = new JLabel(getArenaName());
		eventNameLabel = new JLabel(getEventName());
		eventDateLabel = new JLabel(getEventDate().toString());
		eventTimeLabel = new JLabel(getEventTime().toString());
		ageLimitLabel = new JLabel(Integer.toString(getAgeLimit()));
		descriptionLabel = new JLabel(getEventDescription());
		noOfTicketsLabel = new JLabel(Integer.toString(getNumTickets()));
		try {
			icon = new ImageIcon(image.getBytes(1L, (int) image.length()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imageLabel = new JLabel(icon);
		buyButton = new JButton("Buy");
		
		leftInfoPanel.add(arenaLabel);
		leftInfoPanel.add(eventNameLabel);
		leftInfoPanel.add(eventDateLabel);
		leftInfoPanel.add(eventTimeLabel);
		leftInfoPanel.add(ageLimitLabel);
		
		rightInfoPanel.add(imageLabel);
		rightInfoPanel.add(descriptionLabel);
		rightInfoPanel.add(noOfTicketsLabel);
		rightInfoPanel.add(buyButton);
		
		this.setLayout(new GridLayout(1,2));
		this.add(leftInfoPanel);
		this.add(rightInfoPanel);
		
		this.setPreferredSize(new Dimension(400, 250));
		this.setBackground(Color.white);
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
