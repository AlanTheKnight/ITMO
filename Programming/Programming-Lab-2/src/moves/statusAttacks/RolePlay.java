package moves.statusAttacks;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

/*
 * Move data
 * Type    	PSYCHIC
 * Category	Status
 * Power	—
 * Accuracy	—
 * 
 * Effects
 * Role Play copies the opponent's ability, replacing its own with that of the target's.
 */

public class RolePlay extends StatusMove {
    Pokemon opponent = null;

    public RolePlay() {
        super(Type.PSYCHIC, 0, 0);
    }

    @Override
    protected String describe() {
        return "использует Role Play";
    }

    @Override
    public final void applyOppEffects(Pokemon opp) {
        // Remember the opponent.
        opponent = opp;
    }

    protected void applySelfEffects(Pokemon p, Pokemon opp) {
        System.out.println("RolePlay.applySelfEffects: " + p.toString() + " " + opp.toString());

        if (opponent == null) {
            System.out.println("RolePlay.applySelfEffects: opponent is null");
            return;
        }

        // The user's ability changes to match the target's current ability.
        p.setStats(
                opp.getStat(Stat.HP),
                opp.getStat(Stat.ATTACK),
                opp.getStat(Stat.DEFENSE),
                opp.getStat(Stat.SPECIAL_ATTACK),
                opp.getStat(Stat.SPECIAL_DEFENSE),
                opp.getStat(Stat.SPEED));
    }
}
