package pokemons;

import moves.specialAttacks.SolarBeam;
import moves.specialAttacks.ThunderShock;
import moves.statusAttacks.Roar;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Swalot extends Pokemon {
    public Swalot(String name, int level) {
        super(name, level);
        setType(Type.POISON);
        setStats(100, 73, 83, 73, 83, 55);

        setMove(new ThunderShock(), new Roar(), new SolarBeam());
    }
}
