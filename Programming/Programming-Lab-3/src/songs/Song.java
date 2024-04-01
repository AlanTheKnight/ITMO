package songs;

import java.util.ArrayList;

public class Song extends MusicalObject {
    protected ArrayList<String> lyrics = new ArrayList<String>();

    public Song(String name, LyricsReader lyricsReader) {
        super(name);
        this.lyrics = lyricsReader.readLyrics();
    }

    public ArrayList<String> getLyrics() {
        return lyrics;
    }

    @Override
    public String getRepresentation() {
        return String.join("\n", lyrics);
    }

    @Override
    public String toString() {
        return "Song [name=" + name + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof Song))
            return false;
        Song other = (Song) obj;
        return name == other.name;
    }
}
