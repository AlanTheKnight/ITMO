package room;

import java.util.ArrayList;
import characters.Character;

public class PoohRoom {

    protected Candle candle = new Candle();
    protected Cupboard cupboard = new Cupboard();
    protected Bed bed = new Bed();

    public class Candle implements Ligtable {
        protected boolean isLit = false;

        public String getName() {
            return "свеча";
        }

        public boolean getIsLit() {
            return isLit;
        }

        public void light() {
            isLit = true;
            System.out.println("Свеча зажглась");
        }

        public void extinguish() {
            isLit = false;
            System.out.println("Свеча потухла");
        }
    }

    public class Cupboard implements RoomObject {
        public ArrayList<RoomObject> itemsInside = new ArrayList<RoomObject>();

        public String getName() {
            return "буфет";
        }

        public boolean isEmpty() {
            return itemsInside.isEmpty();
        }
    }

    public class Bed implements RoomObject {
        protected Character character;

        public String getName() {
            return "кровать";
        }

        public void setCharacter(Character character) {
            this.character = character;
        }

        public Character getCharacter() {
            return character;
        }

        public boolean hasCharacter() {
            return character != null;
        }

        public void removeCharacter() {
            character = null;
        }

        public void wakeUp(Object reason) {
            class ReasonDefiner {
                public String defineReason(Object reason) {
                    if (reason instanceof Character) {
                        return ((Character) reason).getName() + " разбудил " + character.getName();
                    } else if (reason instanceof String) {
                        return character.getName() + " проснулся по причине: " + reason;
                    } else if (reason == null) {
                        return character.getName() + " проснулся без причины";
                    } else {
                        return "Что-то разбудило " + character.getName();
                    }
                }
            }

            System.out.println((new ReasonDefiner()).defineReason(reason));
            removeCharacter();
        }
    }

    public String toString() {
        return "Комната Винни-Пуха";
    }

    public Candle getCandle() {
        return candle;
    }

    public Cupboard getCupboard() {
        return cupboard;
    }

    public Bed getBed() {
        return bed;
    }
}
