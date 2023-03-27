import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		ArrayList<Song> allSongs = readSongs();
		
		//A quick test line
		System.out.println(allSongs.get(0));
	}
	
	//Method to read in the songs
	public static ArrayList<Song> readSongs() throws FileNotFoundException {
		String currentDirectory = System.getProperty("user.dir");
		String directoryPath = currentDirectory + "/src/Queen";
		File directory = new File(directoryPath);
		File[] files = directory.listFiles();

        ArrayList<Song> allSongs = new ArrayList<Song>();
		ArrayList<String> line = new ArrayList<String>();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                	String title = file.getName();
                	int period = title.lastIndexOf(".txt");
                	title = title.substring(0,period);

                    Scanner sc = new Scanner(new File(directoryPath + "/"+ file.getName()));
                    while(sc.hasNextLine()){
						String newLine = sc.nextLine();//takes the line of text
						
						newLine = newLine.replaceAll("[\"()?!,.']", "");//removes special characters
				        String[] words = newLine.split("\\s+"); //splits into indiviual words
				        
				        for (String word : words) {//adds the words to the arraylist
							if(word.compareTo("")==0) {
				        		continue;
				        	}
				            line.add(word);
				        }
                    }
                    Song newSong = new Song(title,line);
                    allSongs.add(newSong);
                }
            }
        }
        return allSongs;
	}
	
	public static String[] input() {
		Scanner scnr = new Scanner(System.in);
		String query = scnr.next();
		
		String[] input = query.split("\\s+");
		scnr.close();
		return input;
	}

}

