package pr.java;
public class SongNode {
    public String songTitle;
    public String artist;
    public int duration;
    public SongNode nextSong;

    public SongNode(String songTitle, String artist, int duration) {
        this.songTitle = songTitle;
        this.artist = artist;
        this.duration = duration;
        this.nextSong = null;
    }
}
