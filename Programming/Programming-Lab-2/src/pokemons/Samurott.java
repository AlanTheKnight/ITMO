package pokemons;

import moves.specialAttacks.HydroPump;
import moves.statusAttacks.LightScreen;
import moves.statusAttacks.PowerSwap;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Samurott extends Pokemon {
    public Samurott(String name, int level) {
        super(name, level);
        setType(Type.WATER);
        setStats(95, 100, 85, 108, 70, 70);

        setMove(
                new LightScreen(),
                new HydroPump(),
                new PowerSwap());
    }
}
