package mazegame.control;

import mazegame.entity.Item;
import mazegame.entity.Player;
import mazegame.entity.Shield;
import mazegame.entity.Weapon;

public class EquipCommand implements Command {

    @Override
    public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
        if (userInput.getArguments().size() == 0) {
            return new CommandResponse("Tell me the item name to equip.");
        }

        String itemLabel = userInput.getArguments().get(0);
        Item theItem = thePlayer.getItems().findItem(itemLabel);

        if (theItem == null) {
            return new CommandResponse("There is not this item in your inventory");
        }

        if (theItem instanceof Weapon) {
            thePlayer.setM_Weapon((Weapon) theItem);
        } else if (theItem instanceof Shield) {
            thePlayer.setM_Shield((Shield) theItem);
        } else {
            return new CommandResponse("Cannot do this action.");
        }

        return new CommandResponse("successfully equipped " + itemLabel);
    }
}
