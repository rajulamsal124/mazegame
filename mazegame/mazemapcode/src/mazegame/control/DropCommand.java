package mazegame.control;

import mazegame.entity.Item;
import mazegame.entity.Player;

public class DropCommand implements Command {

    @Override
    public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
        if (userInput.getArguments().size() == 0) {
            return new CommandResponse("Tell me what item you want to drop: ");
        }

        String itemLabel = userInput.getArguments().get(0);
        Item theItem = thePlayer.getItems().findItem(itemLabel);
        if (theItem == null) {
            return new CommandResponse("We don't have the item with name " + itemLabel);
        }
        thePlayer.getCurrentLocation().getInventory().addItem(theItem);
        thePlayer.getItems().removeItem(itemLabel);
        return new CommandResponse("You successfully dropped the item " + itemLabel);
    }
}
