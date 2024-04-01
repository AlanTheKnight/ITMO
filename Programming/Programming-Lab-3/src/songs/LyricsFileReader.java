package songs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LyricsFileReader implements LyricsReader {
    private String filename;

    public LyricsFileReader(String filename) {
        this.filename = filename;
    }

    private ArrayList<String> readLyricsFromFile() {
        ArrayList<String> lyrics = new ArrayList<String>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            while (line != null) {
                lyrics.add(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.err.println("Не удалось прочитать файл с текстом песни");
            System.exit(1);
        }
        return lyrics;
    }

    public ArrayList<String> readLyrics() {
        return readLyricsFromFile();
    }
}
