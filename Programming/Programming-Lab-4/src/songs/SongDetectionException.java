package songs;

import weather.Weather;

public class SongDetectionException extends RuntimeException {
    protected Weather weather;

    public SongDetectionException(Weather weather) {
        super();
        this.weather = weather;
        NullPointerException np = new NullPointerException();
        this.initCause(np);
    }

    @Override
    public String getMessage() {
        return "Не удалось определить песню для погоды " + weather.getType().getName();
    }
}
