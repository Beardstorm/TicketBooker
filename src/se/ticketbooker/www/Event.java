package se.ticketbooker.www;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.Date;
import java.sql.Time;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class Event extends JPanel{
	private String arenaName;
	private String eventName;
	private Date eventDate;
	private Time eventTime;
	private String ageLimit;
	private String eventDescription;
	private int numTickets;
	private JButton buyButton;
	private JLabel arenaLabel, eventNameLabel, eventDateLabel, eventTimeLabel, ageLimitLabel, descriptionLabel, noOfTicketsLabel;
	
	public Event(String arenaName, String eventName, Date eventDate, Time eventTime, String ageLimit, String eventDescription, int numTickets) {
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
		ageLimitLabel = new JLabel(getAgeLimit());
		descriptionLabel = new JLabel(getEventDescription());
		noOfTicketsLabel = new JLabel(Integer.toString(getNumTickets()));
		buyButton = new JButton("Buy");
		
		leftInfoPanel.add(arenaLabel);
		leftInfoPanel.add(eventNameLabel);
		leftInfoPanel.add(eventDateLabel);
		leftInfoPanel.add(eventTimeLabel);
		leftInfoPanel.add(ageLimitLabel);
		
		rightInfoPanel.add(descriptionLabel);
		rightInfoPanel.add(noOfTicketsLabel);
		rightInfoPanel.add(buyButton);
		
		this.setLayout(new GridLayout(2,1,5,5));
		this.add(leftInfoPanel);
		this.add(rightInfoPanel);
		
		this.setPreferredSize(new Dimension(200,200));
		this.setBackground(Color.white);
		this.setBorder(new LineBorder(Color.gray, 2));
		
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

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public Time getEventTime() {
		return eventTime;
	}

	public void setEventTime(Time eventTime) {
		this.eventTime = eventTime;
	}

	public String getAgeLimit() {
		return ageLimit;
	}

	public void setAgeLimit(String ageLimit) {
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
