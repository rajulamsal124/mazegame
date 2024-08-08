package mazegame.entity.utility;

import mazegame.entity.Dice;

public class DiceRoller {
    private static DiceRoller instance = new DiceRoller();
    private Dice d6;

    private DiceRoller() {
        d6 = new Dice(6);
    }

    public static DiceRoller GetInstance() {
        return instance;
    }

    public int generateAbilityScore() {
        return d6.roll();
    }

}
