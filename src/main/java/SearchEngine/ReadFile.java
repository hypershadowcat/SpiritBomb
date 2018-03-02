package SearchEngine;

import java.io.*;
import java.util.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

class ReadFile {
	public void run() throws IOException {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e1) {
			System.out.println("Unable to load Windows look and feel");
		}

		HashMap<String, Integer> wordPositionMap = new HashMap<String, Integer>();
		BufferedReader reader = null;
		String currentLine;

		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
		JFileChooser fileSelect = new JFileChooser();
		fileSelect.setFileFilter(filter);
		int status = fileSelect.showDialog(null, "Add file");

		if (status == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileSelect.getSelectedFile();

			MaintenanceWindow.getModel()
			.addRow(new Object[] { selectedFile.getName(), "Indexed", selectedFile.getParent() });

			try {
				reader = new BufferedReader(new FileReader((selectedFile))); // Reads the file one word at a time
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			try {
				currentLine = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
				currentLine = null;
			}

			while (currentLine != null) {
				String[] words = currentLine.toLowerCase().split(" ");

				for (String word : words) {
					if (wordPositionMap.containsKey(word)) {
						wordPositionMap.put(word, wordPositionMap.get(word) + 1);
					} else {
						wordPositionMap.put(word, 1);
					}

					MainWindow.getSearchResults().append(word);
				}

				currentLine = reader.readLine();
			}
		}
	}
}