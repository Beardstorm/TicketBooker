package se.ticketbooker.www;

import java.util.ArrayList;

public abstract class Subject 
{
	private ArrayList<Observer> observers;
	
	public void notifyObservers()
	{
		for(Observer o : observers)
		{
			o.notify();
		}
	}
	
	public void addObserver(Observer o)
	{
		observers.add(o);
	}
}
