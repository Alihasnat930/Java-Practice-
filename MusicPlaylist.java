package pr.java;
public class MusicPlaylist {
    public SongNode head;

    public void playPlaylist() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }
        SongNode current = head;
        System.out.println("Playing playlist:");
        while (current != null) {
            System.out.println(current.songTitle + " - " + current.artist + " (" + current.duration + " seconds)");
            current = current.nextSong;
        }
    }

    public void addSong(String title, String artist, int duration) {
        SongNode newSong = new SongNode(title, artist, duration);
        if (head == null) {
            head = newSong;
        } else {
            SongNode current = head;
            while (current.nextSong != null) {
                current = current.nextSong;
            }
            current.nextSong = newSong;
        }
    }

    public void removeSong(String title) {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }
        if (head.songTitle.equals(title)) {
            head = head.nextSong;
        } else {
            SongNode current = head;
            while (current.nextSong != null && !current.nextSong.songTitle.equals(title)) {
                current = current.nextSong;
            }
            if (current.nextSong == null) {
                System.out.println("Song not found.");
            } else {
                current.nextSong = current.nextSong.nextSong;
            }
        }
    }

    public void rearrangeSong(String title, int newPosition) {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }
        SongNode current = head;
        SongNode prev = null;
        int currentPosition = 1;
        while (current != null && !current.songTitle.equals(title)) {
            prev = current;
            current = current.nextSong;
            currentPosition++;
        }
        if (current == null) {
            System.out.println("Song not found.");
            return;
        }
        if (newPosition < 1 || newPosition > currentPosition) {
            System.out.println("Invalid position.");
            return;
        }
        if (currentPosition == newPosition) {
            System.out.println("Song is already in that position.");
            return;
        }
        if (newPosition == 1) {
            head = current.nextSong;
            current.nextSong = null;
            addSongAtPosition(current, 1);
        } else {
            prev.nextSong = current.nextSong;
            current.nextSong = null;
            addSongAtPosition(current, newPosition);
        }
    }

    private void addSongAtPosition(SongNode newSong, int position) {
        if (head == null) {
            head = newSong;
            return;
        }
        if (position == 1) {
            newSong.nextSong = head;
            head = newSong;
            return;
        }
        SongNode current = head;
        int currentPosition = 1;
        while (currentPosition < position - 1 && current.nextSong != null) {
            current = current.nextSong;
            currentPosition++;
        }
        newSong.nextSong = current.nextSong;
        current.nextSong = newSong;
    }

    public void printPlaylist() {
        SongNode current = head;
        while (current != null) {
            System.out.println(current.songTitle + " by " + current.artist + " (" + current.duration + "s)");
            current = current.nextSong;
        }
    }

}