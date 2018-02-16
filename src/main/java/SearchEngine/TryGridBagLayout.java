package SearchEngine;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

public class TryGridBagLayout extends JFrame
{
    public TryGridBagLayout()
    {
    	createView();
    	
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setSize(400, 200);
    	setLocationRelativeTo(null);
    	setResizable(true);
    }
    
    private void createView()
    {
    	JPanel panelMain = new JPanel();
    	getContentPane().add(panelMain);
    	
    	JPanel panelForm = new JPanel(new GridBagLayout());
    	panelMain.add(panelForm);
    	
    	GridBagConstraints c = new GridBagConstraints(); // Setting the grid constraints
    	c.gridx = 0;
    	c.gridy = 0;
    	c.anchor = GridBagConstraints.LINE_END; // Anchors labels to end of column
    	
    	panelForm.add(new JLabel("First Name: "), c); // Add component according to constraints set in c
    	c.gridy++;
    	panelForm.add(new JLabel("Last Name: "), c);
    	c.gridy++;
    	panelForm.add(new JLabel("Email: "), c);
    	c.gridy++;
    	panelForm.add(new JLabel("Username: "), c);
    	c.gridy++;
    	panelForm.add(new JLabel("Password: "), c);
    	
    	c.gridx = 1; // Resetting the coordinates to add components to the next grid
    	c.gridy = 0;
    	c.anchor = GridBagConstraints.LINE_START;
    	
    	panelForm.add(new JTextField(8), c);
    	c.gridy++;
    	panelForm.add(new JTextField(8), c);
    	c.gridy++;
    	panelForm.add(new JTextField(15), c);
    	c.gridy++;
    	panelForm.add(new JTextField(10), c);
    	c.gridy++;
    	panelForm.add(new JTextField(10), c);
    	
    }
    
    public static void main(String[] args)
    {
    	SwingUtilities.invokeLater(new Runnable()
	    {
		    public void run()
		    {
		    	new TryGridBagLayout().setVisible(true);
		    }
	    });
    }
}