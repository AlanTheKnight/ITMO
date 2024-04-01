package moves.statusAttacks;

import ru.ifmo.se.pokemon.*;

/*
 * Move data
 * Type    	ELECTRIC
 * Category	Status
 * Power	—
 * Accuracy	—
 * 
 * Effects
 * Charge raises the user's Special Defense by one stage.
 */

public class Charge extends StatusMove {
    public Charge() {
        super(Type.ELECTRIC, 0, 0);
    }

    @Override
    protected String describe() {
        return "использует Charge";
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        // Raise the user's Special Defense by one stage.
        p.setMod(Stat.SPECIAL_DEFENSE, 1);
    }
}
