package moves.specialAttacks;

import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

/*
 * Effects
 * Hydro Pump deals damage with no additional effect.
 */
public class HydroPump extends SpecialMove {
    public HydroPump() {
        super(Type.WATER, 110, 80);
    }

    @Override
    protected String describe() {
        return "использует Hydro Pump";
    }
}
