package se.ticketbooker.gui;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;


public class CustomFocusListener implements FocusListener 
{
	private JTextField mTextField;
	private String defaultText;
	
	public CustomFocusListener(JTextField textField) 
	{
		System.out.println("Text Field: "+textField.getText());
		defaultText = textField.getText();
		mTextField = textField;
	}

	@Override
	public void focusGained(FocusEvent e) 
	{
		try {
			if(mTextField.getText().equals(defaultText))
				mTextField.setText("");
		} catch (NullPointerException e1) {
			e1.printStackTrace();
		}
	}
	
	@Override
	public void focusLost(FocusEvent e){
		
		try {
			if(mTextField.getText().isEmpty()){
				mTextField.setText(defaultText);
			}
		} catch (NullPointerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}