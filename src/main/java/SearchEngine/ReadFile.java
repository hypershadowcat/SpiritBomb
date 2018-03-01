package SearchEngine;

import java.io.*;
import java.util.*;

import javax.swing.*;

class ReadFile
{
    public void run() throws IOException
    {
    	try
    	{
    		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    	}
    	catch (Exception e) {}
    	
    	HashMap<String, Integer> wordPositionMap = new HashMap<String, Integer>();
    	BufferedReader reader = null;
    	String currentLine;
    	
    	JFileChooser fileSelect = new JFileChooser(".");
    	int status = fileSelect.showOpenDialog(null);
    	if(status == JFileChooser.APPROVE_OPTION)
    	{
    		File selectedFile = fileSelect.getSelectedFile();
    		
    		
    		try 
    		{
				reader = new BufferedReader(new FileReader((selectedFile))); // Reads the file one word at a time
				
			} 
    		catch (FileNotFoundException e) 
    		{
				e.printStackTrace();
			}
    		
    		try 
    		{
				currentLine = reader.readLine();
			} 
    		catch (IOException e) 
    		{
				e.printStackTrace();
				currentLine = null;
			}
    		
    		while (currentLine != null)
    		{
			    String[] words = currentLine.toLowerCase().split(" ");
			
			    for(String word : words)
			    {
			        if(wordPositionMap.containsKey(word))
			        { 
				        wordPositionMap.put(word, wordPositionMap.get(word)+1);
			        }
			        else
			        {
			        	wordPositionMap.put(word,  1);
			        }
			        
			        MainWindow.getSearchResults().append(word);
			    }
			    
			    currentLine = reader.readLine();
			    
    		}
    		
    	}
    }
}