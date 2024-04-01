package pokemons;

import moves.statusAttacks.RolePlay;
import moves.specialAttacks.SolarBeam;
import moves.specialAttacks.ThunderShock;
import moves.statusAttacks.Roar;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Sunkern extends Pokemon {
    public Sunkern(String name, int level) {
        super(name, level);
        setType(Type.GRASS);
        setStats(30, 30, 30, 30, 30, 30);

        setMove(
                new Roar(),
                new ThunderShock(),
                new SolarBeam(),
                new RolePlay());
    }
}
