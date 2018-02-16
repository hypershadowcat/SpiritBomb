package SearchEngine;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

public class TryBorderLayout extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
	private JButton buttonClear;
	
	private JTextField fieldMessage;
	private JButton buttonSubmit;
	
    public TryBorderLayout()
    {
    	createView();
    	
    	//Make window exit app on close
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setSize(400, 200);
    	setLocationRelativeTo(null);
    	setTitle("Text Area Test");
    	setResizable(true);
    }
    
    private void createView()
    {
    	JPanel panel = new JPanel();
    	panel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Keeps 10 pixel margins on either side
    	panel.setLayout(new BorderLayout()); // Sets it to border layout instead of flow layout
    	getContentPane().add(panel);
    	
    	// North
    	JPanel panelNorth = new JPanel(new BorderLayout());
    	panel.add(panelNorth, BorderLayout.NORTH); // Adds the panel to the NORTH of border layout
    	panelNorth.add(new JLabel("Enter a message: "), BorderLayout.WEST); // Adds it to the west of the NORTH part of the layout
    	
    	fieldMessage = new JTextField();
    	panelNorth.add(fieldMessage, BorderLayout.CENTER);
    	
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
    	panelNorth.add(buttonSubmit, BorderLayout.EAST);
    	//
    	
    	// Center
    	textArea = new JTextArea();
    	textArea.setEditable(false);
    	textArea.setLineWrap(true);
    	textArea.setWrapStyleWord(true);
    	JScrollPane scrollPane = new JScrollPane(textArea);
    	panel.add(scrollPane);
    	//
    	
    	// South
    	JPanel panelSouth = new JPanel();
    	panel.add(panelSouth, BorderLayout.SOUTH);
    	
    	buttonClear = new JButton("Clear Text");
    	buttonClear.addActionListener(new ActionListener() // Clears text field when clicked
    			{
    			    public void actionPerformed(ActionEvent e)
    			    {
    			    	textArea.setText("");
    			    }
    			});
    	panelSouth.add(buttonClear);
    	//
    	
    }
    
    public static void main(String[] args)
    {
    	SwingUtilities.invokeLater(new Runnable()
    	    {
    		    public void run()
    		    {
    		    	new TryBorderLayout().setVisible(true);
    		    }
    	    });
    }
}