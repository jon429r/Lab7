
public class Song {
	String title;
	String lyrics;
	public Song(String title, String lyrics) {
		this.title = title;
		this.lyrics = lyrics;
	}
	public String getTitle() {
		return title;
	}
	public String getLyrics() {
		return lyrics;
	}
	public String toString() {
		return "Title: " + getTitle() + "\n\n" + getLyrics();
	}
}
