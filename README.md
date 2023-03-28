# Lab7
Members: Thomas Powis, Jonathan Day, Jimmy Core, Nikki Gorski

Seperation of duties:

Thomas Powis was responsible for building the song object class and the readSongs() method. You can see the original readSongs() method built by Thomas below.

Jonathan Day was responsbile for tokenization and sanitizing user input. Jonathan did this by adding tokenization to the readSongs() method as well as adding regex code for sanitization to the readSongs() method. Jonathan also made some changes to the song object class as well to get the tokenization to work.

Jimmy Gore was responsible for handling the tfidf calculations, he did this by building the Data class.

Nikki Gorski was responsible for building the ranking system. 


Original readSongs method():
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
