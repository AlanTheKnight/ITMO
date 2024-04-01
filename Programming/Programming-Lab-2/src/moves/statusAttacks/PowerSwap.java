package moves.statusAttacks;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.Stat;

/*
 * Effects
 * User and opponent swap Attack and Special Attack.
 */
public class PowerSwap extends StatusMove {
    private Pokemon opponent = null;

    public PowerSwap() {
        super(Type.PSYCHIC, 0, 0);
    }

    @Override
    protected String describe() {
        return "использует Power Swap";
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        opponent = p;
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        if (opponent == null) {
            return;
        }

        double attack = p.getStat(Stat.ATTACK);
        double specialAttack = p.getStat(Stat.SPECIAL_ATTACK);

        p.setStats(
                p.getStat(Stat.HP),
                opponent.getStat(Stat.ATTACK),
                p.getStat(Stat.DEFENSE),
                opponent.getStat(Stat.SPECIAL_ATTACK),
                p.getStat(Stat.SPECIAL_DEFENSE),
                p.getStat(Stat.SPEED));

        opponent.setStats(
                opponent.getStat(Stat.HP),
                attack,
                opponent.getStat(Stat.DEFENSE),
                specialAttack,
                opponent.getStat(Stat.SPECIAL_DEFENSE),
                opponent.getStat(Stat.SPEED));
    }
}
