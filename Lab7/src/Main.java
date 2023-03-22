import java.io.File;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readSongs();
	}
	
	//Method to read in the songs
	public static void readSongs() {
		String currentDirectory = System.getProperty("user.dir");
		String directoryPath = currentDirectory + "/src/Queen";
		File directory = new File(directoryPath);
		File[] files = directory.listFiles();

        // Loop through the files and print their names
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        }
    
	}
	

}
	