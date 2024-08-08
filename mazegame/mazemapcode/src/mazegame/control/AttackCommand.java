package mazegame.control;

import mazegame.entity.NonPlayerCharacter;
import mazegame.entity.Player;

public class AttackCommand implements Command {

    @Override
    public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
        if (userInput.getArguments().size() == 0) {
            return new CommandResponse("Who do you want to attack?");
        }

        String itemLabel = userInput.getArguments().get(0);
        NonPlayerCharacter nonPlayerCharacter = thePlayer.getCurrentLocation().getNonPlayerCharacter();

        if (nonPlayerCharacter == null) {
            return new CommandResponse(itemLabel + " is not present here.");
        }

        if (thePlayer.getM_Weapon() == null) {
            return new CommandResponse("Equip a weapon first");
        }

        thePlayer.getCurrentLocation().getNonPlayerCharacter().setLifePoints(nonPlayerCharacter.getLifePoints() - thePlayer.getM_Weapon().getDamage());

        nonPlayerCharacter = thePlayer.getCurrentLocation().getNonPlayerCharacter();

        if (nonPlayerCharacter.getLifePoints() > 0) {
            return new CommandResponse("Attacked with a "
                    + thePlayer.getM_Weapon().getDescription()
                    + ". Damage dealt: "
                    + thePlayer.getM_Weapon().getDamage()
                    + "\n"
                    + nonPlayerCharacter.getName()
                    + " has "
                    + nonPlayerCharacter.getLifePoints()
                    + " left."
            );
        } else {
            thePlayer.getCurrentLocation().setNonPlayerCharacter(null);
            return new CommandResponse("Attacked with a "
                    + thePlayer.getM_Weapon().getDescription()
                    + ". Damage dealt: "
                    + thePlayer.getM_Weapon().getDamage()
                    + "\n"
                    + nonPlayerCharacter.getName()
                    + " is dead. Congratulations."
            );
        }
    }

}
