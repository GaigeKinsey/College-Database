package edu.neumont.kinsey.database.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class SavableObjects extends ArrayList<Savable>{

	private static final long serialVersionUID = 1L;
	
	final String directory = "database";

	public void save() {
		for(Savable obj : this) {
			saveSavable(obj);
		}
	}
	
	private void saveSavable(Savable obj) {
		OutputStream out = null;
		try {
			out = new FileOutputStream(directory + "\\" + obj.getFileName());
		} catch (FileNotFoundException e) {
			System.out.println("Directory does not exist.");
		}
		PrintStream outFile = new PrintStream(out);
		outFile.print(obj.toSaveFormat());
		outFile.close();
	}
	
	public void load(SavableFactory factory) {
		File savableDirectory = new File(directory);
		File[] files = savableDirectory.listFiles();
		for(File file : files) {
			String content = null;
			content = loadFile(file.getAbsolutePath());
			Savable obj = factory.createInstance();
			obj.fromLoadFormat(content);
			this.add(obj);
		}
	}

	private String loadFile(String absolutePath) {
		InputStream in = null;
		try {
			in = new FileInputStream(absolutePath);
		} catch (FileNotFoundException e) {
			System.out.println("File Path does not exist.");
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String content = "";
		try {
			while(reader.ready()) {
				String line = reader.readLine().trim();
				content += line + "\r\n";
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Something went wrong..");
		}
		return content;
	}
}
