package io;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

	public static final String FILE_SEPARATOR = System.getProperty("file.separator");
	public static final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	public ArrayList<String> read(String filename) {

		Scanner scan = null;

		try {
			ArrayList<String> output = new ArrayList<String>();
			FileReader reader = new FileReader(filename);
			scan = new Scanner(reader);
			while(scan.hasNextLine()){
				output.add(scan.nextLine());
			}
			return output;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(scan != null)
				scan.close();
		}
		return null;
	}

	public void write(String filename, ArrayList<String> input) {
		
		FileWriter writer = null;

		try {
			try {
				writer = new FileWriter(filename);
				for(String line : input) {
					writer.write(line + LINE_SEPARATOR);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if(writer != null)
					writer.close();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}