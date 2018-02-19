package SearchEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActionListenerTest extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JButton buttonCounter, buttonReset;
	private JLabel labelCount;
	
	private int clicks = 0;
	
	public ActionListenerTest() // Create the constructor
	{
		createView(); // Create the window
		
		setTitle("Click Me"); // Set the window properties
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack(); // Make the window only as large as the elements in the window
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	private void createView()
	{
		JPanel panel = new JPanel(); // Create a new panel
		getContentPane().add(panel); // Add the panel to the frame
		
		labelCount = new JLabel(); // Create a new text label
		labelCount.setPreferredSize(new Dimension(200, 30)); // Set the text label size
		panel.add(labelCount); // Add the label to the panel created above
		
		updateCounter();
		
		buttonCounter = new JButton("Click me"); // Create a button
		buttonCounter.addActionListener(new ButtonCounterActionListener());
		panel.add(buttonCounter); // Add the button
		
		buttonReset = new JButton("Reset");
		buttonReset.addActionListener( // Alternate, easier way to implement simple task ActionListeners
				new ActionListener()
				{
			        public void actionPerformed(ActionEvent e)
			        {
			        	clicks = 0;
			        	updateCounter();
			        }
				}
				);
		panel.add(buttonReset);
	}
	
	private void updateCounter()
	{
		labelCount.setText("Clicked " + clicks + " times"); // Will keep track of how many times the user has clicked the button
	}
	
    public static void main(String[] args) 
    {
    	SwingUtilities.invokeLater(new Runnable() // Call to create the Frame
    	{
    		public void run()
    		{
    			new ActionListenerTest().setVisible(true);
    		}
    	});
    }
    
    private class ButtonCounterActionListener implements ActionListener // Way to implement ActionListeners for more complex tasks
    {

		public void actionPerformed(ActionEvent e) // What to do when the button is clicked
		{
			clicks++;
			updateCounter();
		}
    	
    }
}