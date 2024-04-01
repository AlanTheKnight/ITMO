import pokemons.Pelipper;
import pokemons.Ralts;
import pokemons.Samurott;
import pokemons.Sunkern;
import pokemons.Swalot;
import pokemons.Wynaut;
import ru.ifmo.se.pokemon.Battle;

public class Main {
    public static void main(String[] args) {
        startBattle();
    }

    public static void startBattle() {
        Battle b = new Battle();

        Wynaut p1 = new Wynaut("Wynaut", 1);
        Swalot p2 = new Swalot("Swalot", 1);
        Sunkern p3 = new Sunkern("Sunkern", 1);
        Pelipper p4 = new Pelipper("Pelipper", 1);
        Samurott p5 = new Samurott("Samurott", 1);
        Ralts p6 = new Ralts("Ralts", 1);

        b.addAlly(p1);
        b.addAlly(p2);
        b.addAlly(p3);

        b.addFoe(p4);
        b.addFoe(p5);
        b.addFoe(p6);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                System.out.println("The great battle has ended! Quitting...");
            }
        });

        b.go();
    }
}
