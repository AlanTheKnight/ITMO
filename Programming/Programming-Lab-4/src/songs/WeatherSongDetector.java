package songs;

import weather.Weather;

public interface WeatherSongDetector {
    Song chooseSong(Weather weather);

    default Song detectSong(Weather weather) throws SongDetectionException {
        Song song = chooseSong(weather);
        if (song == null) {
            throw new SongDetectionException(weather);
        }
        return song;
    }
}
