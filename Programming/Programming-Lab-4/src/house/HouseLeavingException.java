package house;

import characters.Character;

public class HouseLeavingException extends Exception {
    protected House house;
    protected Character character;

    public HouseLeavingException(House house, Character character) {
        super();
        this.house = house;
        this.character = character;
    }

    @Override
    public String getMessage() {
        return character.getName() + " не может выйти из дома " + house.getName() + ", так как не находится в нем";
    }
}
