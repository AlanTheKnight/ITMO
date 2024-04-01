package songs;

import weather.Weather;

@FunctionalInterface
public interface WeatherSongDetector {
    Song detectSong(Weather weather);
}
