package moves.statusAttacks;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;

/*
 * Effects
 * Light Screen reduces damage from Special attacks by
 * 50%, for 5 turns. Its effects apply to all Pokémon
 * on the user's side of the field.
 */
public class LightScreen extends StatusMove {
    public LightScreen() {
        super(Type.PSYCHIC, 0, 0);
    }

    @Override
    protected String describe() {
        return "использует Light Screen";
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        // Reduces damage from Special attacks by 50%, for 5 turns
        Effect e = new Effect().turns(5).stat(Stat.SPECIAL_DEFENSE, 2);
        p.addEffect(e);
    }
}
