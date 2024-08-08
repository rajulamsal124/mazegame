package mazegame.control;

import mazegame.entity.Armor;
import mazegame.entity.Item;
import mazegame.entity.Player;
import mazegame.entity.utility.DiceRoller;

public class CollectCommand implements Command {

    @Override
    public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
        if (userInput.getArguments().size() == 0) {
            return new CommandResponse("Tell me what item you want to get: ");
        }

        String itemLabel = userInput.getArguments().get(0);
        Item theItem = thePlayer.getCurrentLocation().getInventory().findItem(itemLabel);

        if (theItem == null) {
            return new CommandResponse("We don't have the item with name " + itemLabel);
        }

        if (theItem instanceof Armor) {
            if (thePlayer.getLifePoints() < 100) {
                thePlayer.setLifePoints(thePlayer.getLifePoints() + DiceRoller.GetInstance().generateAbilityScore());
                System.out.println("life points" + thePlayer.getLifePoints());
                thePlayer.getCurrentLocation().getInventory().removeItem(itemLabel);
            } else {
                return new CommandResponse("You already have maximum life points. ");
            }

        }

        return new CommandResponse("Items collected. ");
    }

}
