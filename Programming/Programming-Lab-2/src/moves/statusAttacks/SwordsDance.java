package moves.statusAttacks;

import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

/*
 * Move data
 * Type    	NORMAL
 * Category	Status
 * Power	—
 * Accuracy	—
 * 
 * Effects
 * Swords Dance raises the user's Attack by two stages.
 */

public class SwordsDance extends StatusMove {
    public SwordsDance() {
        super(Type.NORMAL, 0, 0);
    }

    @Override
    protected String describe() {
        return "использует Swords Dance";
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        // Raise the user's Attack by two stages.
        p.setMod(Stat.ATTACK, 2);
    }
}
