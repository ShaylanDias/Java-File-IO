package testers;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import io.FileIO;

public class Tester {

	public static void main(String[] args) {

		String workingDir = System.getProperty("user.dir");

		
		JFileChooser chooser = new JFileChooser(workingDir);
	    int returnVal = chooser.showOpenDialog(chooser);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	    	FileIO io = new FileIO();
			ArrayList<String> fileData = io.read(chooser.getSelectedFile().getAbsolutePath());
			System.out.println(fileData);
		    io.write("testfile", fileData);
	    }
	    
//		ArrayList<String> fileData = FileIO.read(chooser.getSelectedFile().getPath());
//		ArrayList<String> fileData = FileIO.read("src" + FileIO.fileSeparator + "FileIO.java");
//		System.out.println(fileData);
		
	}

}
