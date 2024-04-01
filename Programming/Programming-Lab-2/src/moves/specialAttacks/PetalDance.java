package moves.specialAttacks;

import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Effect;

/*
 * Effects
 * The user of Petal Dance attacks for 2-3 turns,
 * during which it cannot switch out, and then
 * becomes confused.
 */
public class PetalDance extends SpecialMove {
    public PetalDance() {
        super(Type.GRASS, 120, 100);
    }

    @Override
    protected String describe() {
        return "использует Petal Dance";
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        // The user of Petal Dance attacks for 2-3 turns,
        // during which it cannot switch out, and then
        // becomes confused.
        Effect e = new Effect().turns(2).stat(Stat.ATTACK, 2);
        p.addEffect(e);

        p.confuse();
    }

}
