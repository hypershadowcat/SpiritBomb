package SearchEngine;

import javax.swing.*;
import java.awt.*;

// The main window for the search engine
// Written by Zachary Willis, 2018

public class MainWindow 
{
    public static void main( String[] args )
    {
        JFrame frame = new JFrame();
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setSize(600, 600);
        frame.getContentPane().add(panel);
        
        JButton button = new JButton("This is a button");
        panel.add(button); // Add the button to the panel
        
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, 30));
        panel.add(textField);
        
        JButton button2 = new JButton("This button is so long it has to be added on the next line which is because of the FLOW layout.");
        panel.add(button2);
        
        
        // Sets the window size
        frame.setSize(new Dimension(800, 600));
        // Set the start position to center of screen
        frame.setLocationRelativeTo(null);
        // Set a default close action
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the window color
        frame.setBackground(Color.BLUE);
        // Set the title
        frame.setTitle("Search Engine");
        //Disable resize option
        frame.setResizable(false);
        
        
        frame.setVisible(true);
    }
}
