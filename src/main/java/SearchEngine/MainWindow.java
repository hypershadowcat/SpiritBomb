package SearchEngine;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Written by Craig Anderson, Ihor Panchenko, Juliet Mercado, and Zachary Willis, 2018

public class MainWindow extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	private JLabel searchTitle;
	
	private JLabel instructions;
	private JTextField searchCriteria;
	private JButton searchButton;
	
	private JRadioButton allTerms;
	private JRadioButton anyTerms;
	private JRadioButton exactTerms;
	
	private static JTextArea searchResults;
	
	private JButton maintenanceWindow;
	private JLabel filesIndexed;
	private JButton aboutButton;
	
	public MainWindow()
	{
		createView();
		
		//Make window exit app on close
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setSize(800, 600);
    	setLocationRelativeTo(null);
    	setTitle("Spirit Bomb Search Engine");
    	setResizable(true);
	}
	
	private void createView()
	{
		JPanel panelMain = new JPanel();
    	panelMain.setBorder(new EmptyBorder(10, 10, 10, 10)); // Keeps 10 pixel margins on either side
    	panelMain.setLayout(new BorderLayout()); // Sets it to border layout instead of flow layout
    	getContentPane().add(panelMain);
    	
    	// North
    	JPanel panelNorth = new JPanel(new GridBagLayout());
    	panelMain.add(panelNorth, BorderLayout.NORTH); // Adds the panel to the north of the border layout
    	
    	GridBagConstraints c = new GridBagConstraints();
    	c.gridx = 1;
    	c.gridy = 0;
    	c.anchor = GridBagConstraints.BASELINE;
    	
    	searchTitle = new JLabel("Search Engine");
    	panelNorth.add(searchTitle, c);
    	c.gridy++;
    	c.gridx = 0;
    	
    	c.anchor = GridBagConstraints.LINE_END;
    	instructions = new JLabel("Search Terms: ");
    	panelNorth.add(instructions, c);
    	c.gridx++;
    	
    	c.anchor = GridBagConstraints.CENTER;
    	c.weightx = 1;
    	c.fill = GridBagConstraints.HORIZONTAL;
    	searchCriteria = new JTextField(600);
    	panelNorth.add(searchCriteria, c);
    	c.gridx++;
    	
    	c.anchor = GridBagConstraints.LINE_START;
    	c.weightx = 0;
    	c.fill = GridBagConstraints.NONE; // Make the buttons not expand
    	searchButton = new JButton("Search");
    	panelNorth.add(searchButton, c);
    	c.gridx = 0;
    	c.gridy++;
    	
    	c.anchor = GridBagConstraints.CENTER;
    	c.weightx = 1; // Makes the cell expand horizontally
    	c.insets.right = 0; // --> makes the buttons stand side by side
    	c.insets.left = 0; // --> makes the buttons stand side by side
    	
    	allTerms = new JRadioButton("All Search Terms");
    	panelNorth.add(allTerms, c);
    	c.gridx++;
    	
    	anyTerms = new JRadioButton("Any Search Terms");
    	panelNorth.add(anyTerms, c);
    	c.gridx++;
    	
    	c.anchor = GridBagConstraints.WEST;
    	exactTerms = new JRadioButton("Exact Phrase Only");
    	panelNorth.add(exactTerms, c);
    	//
    	
    	// Center
    	searchResults = new JTextArea();
    	searchResults.setEditable(false);
    	searchResults.setLineWrap(true);
    	searchResults.setWrapStyleWord(true);
    	JScrollPane scrollPane = new JScrollPane(searchResults); // Creates the searchResults in a scrollable pane
    	panelMain.add(scrollPane, BorderLayout.CENTER);
    	//
    	
    	// South
    	JPanel panelSouth = new JPanel();
    	panelMain.add(panelSouth, BorderLayout.SOUTH);
    	
    	maintenanceWindow = new JButton("Maintenance");
    	maintenanceWindow.addActionListener(new ActionListener() 
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    	        MaintenanceWindow maintenance = new MaintenanceWindow();
    	        maintenance.setVisible(true);
    		}
    	});
    	panelSouth.add(maintenanceWindow, BorderLayout.WEST);
    	
    	filesIndexed = new JLabel("Number of files index: 0");
    	panelSouth.add(filesIndexed, BorderLayout.CENTER);
    	
    	aboutButton = new JButton("About");
    	aboutButton.addActionListener(new ActionListener() // Lists details about the program through a show message dialog
    			{
    			    public void actionPerformed(ActionEvent e)
    			    {
    			    	ImageIcon icon = new ImageIcon("src\\main\\java\\search.png");
    			    	JOptionPane.showMessageDialog(null, "Search Engine 0.0\n" +
    			    		"Model Solution to COP-2805 Search Engine Project\n" +
    			    		"Written by Craig Anderson, Ihor Panchenko, \n" +
    			    		"Juliet Mercado, and Zachary Willis",
    			    		"Search Engine", 1, icon);
    			    }
    			});
    	panelSouth.add(aboutButton, BorderLayout.EAST);
    	//
	}
	
	public static void main( String[] args )
	{
		SwingUtilities.invokeLater(new Runnable()
		{
		    public void run()
		    {
		    	new MainWindow().setVisible(true);
		    }
	    });
	}

	public static JTextArea getSearchResults() 
	{
		return searchResults;
	}

	public void setSearchResults(JTextArea searchResults) 
	{
		this.searchResults = searchResults;
	}
}
