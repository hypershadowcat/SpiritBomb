package SearchEngine;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

// Written by Craig Anderson, Ihor Panchenko, Juliet Mercado, and Zachary Willis, 2018

class MaintenanceWindow extends JFrame 
{
	private static final long serialVersionUID = 1L;
	
	public MaintenanceWindow() 
	{
	    // Maintenance Window
	    setTitle("Search Engine Maintenance");
	    setSize(700, 500);
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Destroys itself instead of ending program
	    setLocationRelativeTo(null);
	    getContentPane().setBackground(new Color(163, 228, 237));
	    setResizable(false);
				
	    // Container for the whole window
	    Box main = Box.createVerticalBox();
	    add(main);
		
	    // Label
	    JLabel title = new JLabel("Search Engine - Index Maintenance");
	    title.setFont(new Font("SansSerif", 1, 24));
	    Box titleBox = Box.createHorizontalBox();
	    titleBox.add(title);
	    titleBox.add(Box.createHorizontalStrut(10)); // invisible, horizontal, fixed-width component; force a certain amount of space between components 
	    main.add(titleBox);
	    main.add(Box.createVerticalStrut(10)); // invisible, vertical, fixed-width component
	   
	    // File Table
	    Box tableBox = Box.createHorizontalBox();
	    String columns[] = {"File Name", "Status"}; // created only to see how it appears on the table
	    DefaultTableModel model = new DefaultTableModel(columns, 30);
	    JTable fileTable = new JTable(model);
	    fileTable.getTableHeader().setReorderingAllowed(false);
	    fileTable.setBackground(new Color(163, 228, 237));
	    fileTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
	    fileTable.setFillsViewportHeight(true);
	    tableBox.add(Box.createHorizontalStrut(16));
	    tableBox.add(fileTable);
	    JScrollPane scrollPane = new JScrollPane(fileTable);
	    tableBox.add(scrollPane);
	    tableBox.add(Box.createHorizontalStrut(16));
	    main.add(tableBox);
	    main.add(Box.createVerticalStrut(12));
	    
	    // Container for the buttons
	    Box buttonsBox = Box.createHorizontalBox();
	    main.add(buttonsBox);
	    main.add(Box.createVerticalStrut(10));
	    buttonsBox.add(Box.createHorizontalGlue());
		
	    // Add File Button
	    JButton addFile = new JButton("Add File...");
	    buttonsBox.add(addFile);
	    buttonsBox.add(Box.createHorizontalGlue());
	    
	    // Rebuild Button
	    JButton rebuildOldData = new JButton("Rebuild Out-of-date");
	    buttonsBox.add(rebuildOldData);	    
	    buttonsBox.add(Box.createHorizontalGlue());
	    
	    // Remove Button
	    JButton removeFile = new JButton("Remove Selected Files");
	    buttonsBox.add(removeFile);
	    buttonsBox.add(Box.createHorizontalGlue());
	    
	    // Reset Window Button
	    JButton resetWindow = new JButton("Reset Windows");
	    buttonsBox.add(resetWindow);
	    buttonsBox.add(Box.createHorizontalGlue());

	    // Container (footer) with number of files and program version
	    Box footer = Box.createHorizontalBox();
	    main.add(footer);
	    footer.add(Box.createHorizontalStrut(32));

	    footer.add(new JLabel("Number of files indexed: 0"));
	    footer.add(Box.createGlue());
	    
	    footer.add(new JLabel("Search Engine version 0.0"));
	    footer.add(Box.createHorizontalStrut(32));
	    main.add(Box.createVerticalStrut(8));
    }
}