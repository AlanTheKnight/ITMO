package pokemons;

import moves.specialAttacks.HydroPump;
import moves.specialAttacks.PetalDance;
import moves.statusAttacks.LightScreen;
import moves.statusAttacks.PowerSwap;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Ralts extends Pokemon {
    public Ralts(String name, int level) {
        super(name, level);
        setType(Type.PSYCHIC, Type.FAIRY);
        setStats(28, 25, 25, 45, 35, 40);

        setMove(
                new PetalDance(),
                new HydroPump(),
                new PowerSwap(),
                new LightScreen());
    }
}
