package moves.specialAttacks;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

/*
 * Move data
 * Type	     ELECTRIC
 * Category  Special
 * Power	 40
 * Accuracy	 100
 * 
 * Effects
 * Thunder Shock deals damage and has a 10% chance of paralyzing the target.
 */

public class ThunderShock extends SpecialMove {
    public ThunderShock() {
        super(Type.ELECTRIC, 40, 100);
    }

    @Override
    protected String describe() {
        return "использует Thunder Shock";
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        // 10% chance of paralyzing the target.
        if (Math.random() <= 0.1)
            Effect.paralyze(p);
    }
}
