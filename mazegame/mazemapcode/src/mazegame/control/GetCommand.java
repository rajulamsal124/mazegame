package mazegame.control;


import mazegame.entity.Item;
import mazegame.entity.Player;

public class GetCommand implements Command {

    @Override
    public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
        if (userInput.getArguments().size() == 0) {
            return new CommandResponse("Tell me what item you want to get: ");
        }

        String itemLabel = (String) userInput.getArguments().get(0);
        Item theItem = thePlayer.getCurrentLocation().getInventory().findItem(itemLabel);

        if (theItem == null) {
            return new CommandResponse("We don't have this item here");
        }

        boolean added = thePlayer.getItems().addItem(theItem);
        if (!added) {
            return new CommandResponse("We cannot add " + itemLabel + " due to weight restriction");
        }
        thePlayer.getCurrentLocation().getInventory().removeItem(itemLabel);
        return new CommandResponse("You successfully got the item " + itemLabel);
    }

}
