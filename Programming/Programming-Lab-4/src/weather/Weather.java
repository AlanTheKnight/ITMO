package weather;

public class Weather {
    protected WeatherType type;

    public Weather(WeatherType type) {
        this.type = type;
    }

    public WeatherType getType() {
        return type;
    }

    public void setType(WeatherType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Weather [type=" + type + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof Weather))
            return false;
        Weather other = (Weather) obj;
        return type == other.type;
    }
}
