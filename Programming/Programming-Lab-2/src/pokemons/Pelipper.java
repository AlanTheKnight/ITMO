package pokemons;

import moves.specialAttacks.HydroPump;
import moves.statusAttacks.LightScreen;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Pelipper extends Pokemon {
    public Pelipper(String name, int level) {
        super(name, level);
        setType(Type.WATER, Type.FLYING);
        setStats(60, 50, 100, 95, 70, 65);

        setMove(new LightScreen(),
                new HydroPump());
    }
}
