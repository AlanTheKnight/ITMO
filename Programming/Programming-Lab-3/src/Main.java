import java.util.ArrayList;

import characters.*;
import characters.Character;
import house.House;
import mistake.TerribleMistake;
import songs.*;
import weather.Weather;
import weather.WeatherType;

public class Main {
    public static void main(String[] args) {

        // Создание персонажей
        var christopherRobin = new Character("Кристофер Робин");
        var pooch = new Character("Пух");
        var pyatachok = new Character("Пятачок");
        var ia = new Character("Иа", HappinessLevel.HAPPY);

        var lyricsReader = new LyricsFileReader("lyrics/snowy_weather_song.txt");

        // Создание песен
        WeatherSongDetector wsd = (Weather weather) -> {
            switch (weather.getType()) {
                case SNOWY:
                    return new Song("Дорожняя Шумелка для Зимней Погоды", lyricsReader);
                default:
                    return null;
            }
        };

        // Создание погоды
        Weather weather = new Weather(WeatherType.SNOWY);

        // Песня для погоды
        Song song = wsd.detectSong(weather);

        // Дом Иа
        House house = new House("Дом Иа", ia);

        // Добавление персонажей в дом
        house.addCharacter(christopherRobin);
        house.addCharacter(pooch);
        house.addCharacter(pyatachok);
        house.addCharacter(ia);

        // Иа вошел в дом и снова вышел.
        ia.leaveHouse(house);
        ia.enterHouse(house);

        var threeFriends = new ArrayList<Character>(
                house.getCharactersInside().stream().filter(ch -> ch != ia).toList());

        // Все попрощались со счастливым хозяином дома
        threeFriends.forEach(ch -> ch.say("До свидания, Иа!"));

        // Кристофер Робин пошел обедать со своими друзьями -- Пухом и Пятачком
        threeFriends.forEach(ch -> ch.goToLunch());

        // По дороге друзья рассказали ему об Ужасной Ошибке, которую они совершили
        TerribleMistake tm = new TerribleMistake(
                "Иа построил себе дом из палок, которые мы случайно взяли, чтобы заново построить ему дом!");
        pooch.say(tm.getDesciption());
        pyatachok.say(tm.getDesciption());

        // Когда он кончил смеяться, все трое дружно запели Дорожную Шумелку для Снежной
        // Погоды и пели ее всю дорогу, причем Пятачок, который все еще был немного не в
        // голосе, только тирлимбомбомкал

        pyatachok.setVoice(false);
        christopherRobin.laugh(3, () -> {
            song.getLyrics().forEach(line -> {
                threeFriends.forEach(ch -> ch.sing(line));
            });
        });
    }
}
