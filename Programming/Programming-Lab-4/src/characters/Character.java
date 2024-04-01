package characters;

import house.House;
import room.Ligtable;
import room.PoohRoom;
import room.RoomObject;
import songs.Song;

public class Character {
    protected String name;
    protected boolean voice = true;
    protected StressLevel stressLevel = StressLevel.NEUTRAL;
    protected HappinessLevel happinessLevel = HappinessLevel.NEUTRAL;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, boolean hasVoice) {
        this.name = name;
        this.voice = hasVoice;
    }

    public Character(String name, HappinessLevel happinessLevel) {
        this.name = name;
        this.happinessLevel = happinessLevel;
    }

    public Character(String name, boolean hasVoice, HappinessLevel happinessLevel) {
        this.name = name;
        this.voice = hasVoice;
        this.happinessLevel = happinessLevel;
    }

    public HappinessLevel getHappinessLevel() {
        return happinessLevel;
    }

    public void setHappinessLevel(HappinessLevel happinessLevel) {
        this.happinessLevel = happinessLevel;
    }

    public String getName() {
        return name;
    }

    public void enterHouse(House house) {
        house.addCharacter(this);
        System.out.println(name + " вошел в дом " + house.getName());
    }

    public void leaveHouse(House house) {
        try {
            house.removeCharacter(this);
            System.out.println(name + " вышел из дома " + house.getName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void say(String message) {
        System.out.println(name + " сказал: " + message);
    }

    public void sayGoodbye() {
        say("До свидания!");
    }

    public void laugh(int seconds, LaughCallback callback) {
        System.out.println(name + " смеется");
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(name + " перестал смеяться");
        if (callback != null)
            callback.afterLaugh();
    }

    public boolean getVoice() {
        return voice;
    }

    public void setVoice(boolean hasVoice) {
        this.voice = hasVoice;
    }

    public void setStressLevel(StressLevel stressLevel) {
        this.stressLevel = stressLevel;
    }

    public StressLevel getStressLevel() {
        return stressLevel;
    }

    public void check(boolean condition, String message) {
        if (condition)
            System.out.println(name + " проверил: " + message + " -- верно");
        else
            System.out.println(name + " проверил: " + message + " -- неверно");
    }

    public void hear(String message) {
        System.out.println(name + " услышал: " + message);
    }

    public void goTo(RoomObject roomObject) {
        System.out.println(name + " подошел к " + roomObject.getName());
    }

    public void sing(Song song) {
        sing(song.getRepresentation());
    }

    public void sing(String lyrics) {
        if (voice)
            System.out.println(name + " поет: " + lyrics);
        else
            System.out.println(name + " тирлимбомбомкает: " + lyrics);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        Character character = (Character) obj;
        return name.equals(character.getName());
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public void goToLunch() {
        System.out.println(name + " пошел на обед");
    }

    public void light(Ligtable roomObject) {
        System.out.println(name + " зажег " + roomObject.getName());
        roomObject.light();
    }

    public void extinguish(Ligtable roomObject) {
        System.out.println(name + " потушил " + roomObject.getName());
        roomObject.extinguish();
    }

    public void wakeUp(PoohRoom.Bed bed, Object reason) {
        System.out.println(name + " проснулся");
        bed.wakeUp(reason);
    }

    public void layDown(PoohRoom.Bed bed) {
        System.out.println(name + " лег на " + bed.getName());
        bed.setCharacter(this);
    }
}
