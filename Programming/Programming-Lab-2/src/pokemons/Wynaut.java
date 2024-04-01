package pokemons;

import moves.physicalAttacks.FocusPunch;
import moves.physicalAttacks.MegaHorn;
import moves.statusAttacks.Charge;
import moves.statusAttacks.SwordsDance;
import ru.ifmo.se.pokemon.*;

public class Wynaut extends Pokemon {
    public Wynaut(String name, int level) {
        super(name, level);
        setType(Type.PSYCHIC);
        setStats(95, 23, 48, 23, 48, 23);

        setMove(
                new Charge(),
                new FocusPunch(),
                new SwordsDance(),
                new MegaHorn());
    }
}
