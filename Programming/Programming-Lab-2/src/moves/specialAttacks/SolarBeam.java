package moves.specialAttacks;

import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;

/*
 * Effects
 * The user of Solar Beam will absorb light on the first turn.
 * On the second turn, Solar Beam deals damage.
 */

public class SolarBeam extends SpecialMove {
    public SolarBeam() {
        super(Type.GRASS, 0, 0);
    }

    @Override
    protected String describe() {
        return "использует Solar Beam";
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        // Deals damage
        Effect e = new Effect().turns(2).stat(Stat.HP, 60);
        p.addEffect(e);
    }
}
