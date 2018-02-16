package SearchEngine;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TryTextArea extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
	private JButton buttonClear;
	
	private JTextField fieldMessage;
	private JButton buttonSubmit;
	
    public TryTextArea()
    {
    	createView();
    	
    	setTitle("Text Area Test");
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setSize(400, 200);
    	setLocationRelativeTo(null);
    	setResizable(false);
    }
    
    private void createView()
    {
    	JPanel panel = new JPanel();
    	getContentPane().add(panel);
    	
    	JLabel label = new JLabel("Enter some text: ");
    	panel.add(label);
    	
    	fieldMessage = new JTextField(12); // Create a JTextField 12 with size of 12 columns
    	panel.add(fieldMessage);
    	
    	buttonSubmit = new JButton("Submit");
    	buttonSubmit.addActionListener(new ActionListener() // Begins filling text area when clicked
    		{
    		    public void actionPerformed(ActionEvent e)
    		    {
    		    	String message = fieldMessage.getText();
    		    	fieldMessage.setText("");
    		    	textArea.append(message + "\n");
    		    }
    		});
    	panel.add(buttonSubmit);
    	
    	textArea = new JTextArea(); // Set up presentation of text area
    	textArea.setEditable(false);
    	textArea.setLineWrap(true);
    	textArea.setWrapStyleWord(true); // Prevents words from being cut off half-way through word on line wrap
    	
    	JScrollPane scrollPane = new JScrollPane(textArea); // Adds scroll bars
    	scrollPane.setPreferredSize(new Dimension(350, 90));
    	panel.add(scrollPane); // This will add the scrollPane that now contains TextArea initialized above
    	
    	buttonClear = new JButton("Clear Text Area");
    	buttonClear.addActionListener(new ActionListener() // Clears text field when clicked
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	textArea.setText("");
		    }
		});
    	panel.add(buttonClear);
    	
    }
    
    public static void main(String[] args)
    {
    	// Create a frame and show it through SwingUtilities
    	SwingUtilities.invokeLater(new Runnable() 
    	{
    		public void run()
    		{
    			new TryTextArea().setVisible(true);
    		}
    	});
    }
}