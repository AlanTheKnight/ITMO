package weather;

public enum WeatherType {

    SNOWY("Snowy"),
    RAINY("Rainy"),
    SUNNY("Sunny"),
    WINDY("Windy"),
    CLOUDY("Cloudy"),
    FOGGY("Foggy");

    private String name;
    private boolean isRainy;

    WeatherType(String name) {
        this.name = name;
    }

    WeatherType(String name, boolean isRainy) {
        this.name = name;
        this.isRainy = isRainy;
    }

    public String getName() {
        return name;
    }

    public boolean getIsRainy() {
        return isRainy;
    }
}
