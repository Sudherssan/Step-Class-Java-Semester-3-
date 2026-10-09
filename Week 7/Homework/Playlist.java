
import java.util.*;

public class Playlist {

    // Private array to store song titles
    private String[] songs;

    // Number of songs added
    private int songCount;

    // Constructor
    public Playlist(int maxSize) {
        if (maxSize < 0) {
            throw new IllegalArgumentException(
                "Playlist size cannot be negative"
            );
        }

        songs = new String[maxSize];
        songCount = 0;
    }

    // Add a song
    public void addSong(String song) {
        if (song == null || song.trim().isEmpty()) {
            System.out.println("Invalid song title");
            return;
        }

        if (songCount >= songs.length) {
            System.out.println("Playlist is full");
            return;
        }

        songs[songCount] = song;
        songCount++;
    }

    // Return a copy of the songs added so far
    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    // Return the number of songs
    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {

        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        // Get a copy of the playlist
        String[] copy = p.getSongs();

        System.out.println("Original playlist:");
        System.out.println(Arrays.toString(p.getSongs()));

        // Modify the returned copy
        copy[0] = "Hacked";

        System.out.println("Modified copy:");
        System.out.println(Arrays.toString(copy));

        System.out.println("Actual playlist after modification:");
        System.out.println(Arrays.toString(p.getSongs()));

        System.out.println("Song count: " + p.getSongCount());
    }
}
