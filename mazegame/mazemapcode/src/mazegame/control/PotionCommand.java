package mazegame.control;

import mazegame.entity.Item;
import mazegame.entity.Player;

public class PotionCommand implements Command {

    @Override
    public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
        if (userInput.getArguments().size() == 0) {
            return new CommandResponse("Tell me the potion name to collect.");
        }
        String itemLabel = userInput.getArguments().get(0);
        Item theItem = thePlayer.getItems().findItem(itemLabel);

        if (theItem == null) {
            return new CommandResponse("There is not this item in your inventory");
        }

        int lifePointValFromPotion = theItem.getValue();

        if (thePlayer.getLifePoints() < 100) {
            thePlayer.setLifePoints(thePlayer.getLifePoints() + lifePointValFromPotion);
            if (thePlayer.getLifePoints() > 100) thePlayer.setLifePoints(100);
            thePlayer.getItems().removeItem(itemLabel);
            return new CommandResponse("Now you have life points of :" + thePlayer.getLifePoints());
        } else {
            return new CommandResponse("You already have maximum life points. ");
        }
    }

}
