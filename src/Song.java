import java.util.ArrayList;

public class Song {
	String title;
	ArrayList<String> lyrics;
	public Song(String title, ArrayList<String> lyrics) {
		this.title = title;
		this.lyrics = lyrics;
	}
	public String getTitle() {
		return title;
	}
	public ArrayList<String> getLyrics() {
		return lyrics;
	}
	public String toString() {
		return "Title: " + getTitle() + "\n\n" + getLyrics();
	}
}