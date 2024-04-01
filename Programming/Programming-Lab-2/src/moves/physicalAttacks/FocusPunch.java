package moves.physicalAttacks;

import ru.ifmo.se.pokemon.*;

/*
 * Move data
 * Type	     FIGHTING
 * Category	 Physical
 * Power	 150
 * Accuracy	 100
 * Priority	 -3
 * 
 * Effects
 * The user of Focus Punch will tighten its focus before any other moves are made.
 * If any regular move (with a higher priority than -3) directly hits the focused
 * Pokémon, it loses its focus and flinches, not carrying out the attack. If no
 * direct hits are made, Focus Punch attacks as normal.
 * 
 * Moves of lower priority than Focus Punch - for example Avalanche or Dragon
 * Tail - will not cause the user to lose focus. The user will tighten their focus,
 * Focus Punch will attack, then the opponent will use their lower priority move
 * (and in the case of Avalanche, hit with double power).
 */

public class FocusPunch extends PhysicalMove {
    public FocusPunch() {
        super(Type.FIGHTING, 150, 100);
        super.priority = -3;
    }

    @Override
    public String describe() {
        return "использует Focus Punch";
    }
}