package moves.statusAttacks;

import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

/*
 * Move data
 * Type    	NORMAL
 * Category	Status
 * Power	—
 * Accuracy	—
 * Priority	-6
 * 
 * Effects
 * In the wild, Roar causes the target Pokémon to flee
 * if they are of a lower level, and the battle ends.
 */

public class Roar extends StatusMove {
    public Roar() {
        super(Type.NORMAL, 0, 0);
        priority = -6;
    }

    @Override
    protected String describe() {
        return "использует Roar";
    }
}
