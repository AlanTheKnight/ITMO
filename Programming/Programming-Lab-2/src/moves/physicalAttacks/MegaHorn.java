package moves.physicalAttacks;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;

/*
 * Move data
 * Type    	BUG
 * Category	Physical
 * Power	120
 * Accuracy	85
 *
 * Effects
 * Megahorn deals damage with no additional effect.
 */

public class MegaHorn extends PhysicalMove {
    public MegaHorn() {
        super(Type.BUG, 120, 85);
    }

    @Override
    protected String describe() {
        return "использует Mega Horn";
    }
}
