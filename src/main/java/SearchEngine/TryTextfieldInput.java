package SearchEngine;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TryTextfieldInput extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JTextField fieldName;
	private JLabel labelMessage;
	private JButton buttonSubmit;

	public TryTextfieldInput()
    {
    	createView();
    	
    	setTitle("Greetings");
    	// Make window exit app on close
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setSize(400,200); // Set the size
    	setLocationRelativeTo(null); // Set the position to the center of the screen
    	setResizable(true); // Disallow user to readjust window size
    }
    
    // Initializes all UI components
    private void createView()
    {
    	JPanel panel = new JPanel(); // Create a panel to hold the contents of the window on the frame
    	getContentPane().add(panel);
    	
    	JLabel label = new JLabel("Enter your name: "); // Create a label and add it to the panel
    	panel.add(label);
    	
    	fieldName = new JTextField(); // Create a text field and set it's size before adding it to the panel
    	fieldName.setPreferredSize(new Dimension(150, 30));
    	panel.add(fieldName);
    	
    	buttonSubmit = new JButton("Submit");
    	buttonSubmit.addActionListener(new ActionListener() // Creates an event to happen when the button is pressed
    		{
    		    public void actionPerformed(ActionEvent e)
    		    {
    		    	String name = fieldName.getText(); // Returns text entered in text field
    		    	if(name.isEmpty()) 
    		    	{
    		    		labelMessage.setText("Your name can't simply be nothing can it?");
    		    	}
    		    	else
    		    	{
    		    		labelMessage.setText("Hello there, " + name + ". How are you?");
    		    	}
    		    }
    		});
    	panel.add(buttonSubmit);
    	
    	labelMessage = new JLabel("Please enter your name!");
    	panel.add(labelMessage);
    	
    }
    
    public static void main(String[] args)
    {
    	// Create a frame and show it through SwingUtilities
    	SwingUtilities.invokeLater(new Runnable() 
    	{
    		public void run()
    		{
    			new TryTextfieldInput().setVisible(true);
    		}
    	});
    }
}