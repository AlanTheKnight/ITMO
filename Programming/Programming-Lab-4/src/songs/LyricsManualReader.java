package songs;

import java.util.ArrayList;

public class LyricsManualReader implements LyricsReader {
    private ArrayList<String> lyrics;

    LyricsManualReader(ArrayList<String> lyrics) {
        this.lyrics = lyrics;
    }

    public ArrayList<String> readLyrics() {
        return lyrics;
    }
}
