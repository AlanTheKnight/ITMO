package house;

import java.util.ArrayList;

import characters.Character;

public class House {
    protected String name;
    protected Character owner = null;
    protected ArrayList<Character> characters_inside = new ArrayList<Character>();
    protected String description = "";

    public House(String name) {
        this.name = name;
    }

    public House(String name, Character owner) {
        this.name = name;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        return this.name = name;
    }

    public Character getOwner() {
        return owner;
    }

    public void setOwner(Character owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public String setDescription(String description) {
        return this.description = description;
    }

    public void addCharacter(Character character) {
        characters_inside.add(character);
    }

    public void removeCharacter(Character character) throws HouseLeavingException {
        boolean removed = characters_inside.remove(character);
        if (!removed) {
            throw new HouseLeavingException(this, character);
        }
    }

    public ArrayList<Character> getCharactersInside() {
        return characters_inside;
    }

    @Override
    public String toString() {
        return "House [name=" + name + ", owner=" + owner + ", characters_inside=" + characters_inside + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof House))
            return false;
        House house = (House) obj;
        return name.equals(house.getName()) && owner.equals(house.getOwner())
                && characters_inside.equals(house.getCharactersInside());
    }
}
