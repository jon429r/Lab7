import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		ArrayList<Song> allSongs = readSongs();

		//A quick test line
		System.out.println(allSongs.get(0));
		input();
	}

	//Method to read in the songs
	public static ArrayList<Song> readSongs() throws FileNotFoundException {
		String currentDirectory = System.getProperty("user.dir");
		String directoryPath = currentDirectory + "/src/Queen";
		File directory = new File(directoryPath);
		File[] files = directory.listFiles();

		ArrayList<Song> allSongs = new ArrayList<Song>();
		String line = "";
		if (files != null) {
			for (File file : files) {
				if (file.isFile()) {
					String title = file.getName();
					int period = title.lastIndexOf(".txt");
					title = title.substring(0,period);

					Scanner sc = new Scanner(new File(directoryPath + "/"+ file.getName()));
					while(sc.hasNextLine()){
						line += sc.nextLine() + "\n";
					}
					Song newSong = new Song(title,line);
					allSongs.add(newSong);
				}
			}
		}
		return allSongs;
	}

	public static String[] input() {
		
		System.out.println("What would you like to search for?");

		Scanner scnr = new Scanner(System.in);
		String query = scnr.next();
		

		String[] input = query.split("\\s+");
		scnr.close();
		return input;
	}

}

