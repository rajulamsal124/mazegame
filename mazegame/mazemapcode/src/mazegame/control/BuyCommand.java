package mazegame.control;

import mazegame.entity.Item;
import mazegame.entity.Player;

public class BuyCommand implements Command {

    @Override
    public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
        if (userInput.getArguments().size() == 0) {
            return new CommandResponse("Tell me what item you want to buy: ");
        }

        String itemLabel = userInput.getArguments().get(0);
        Item theItem = thePlayer.getCurrentLocation().getInventory().findItem(itemLabel);

        if (theItem == null) {
            return new CommandResponse("We don't have the item with name " + itemLabel);
        }

        boolean bought = thePlayer.getItems().removeMoney(theItem.getValue());
        if (!bought) {
            return new CommandResponse("We cannot add " + itemLabel + " because there is not enough gold pieces.");
        }
        bought = thePlayer.getItems().addItem(theItem);
        if (!bought) {
            return new CommandResponse("We cannot add " + itemLabel + " because of weight restrictions");
        }
        thePlayer.getCurrentLocation().getInventory().removeItem(itemLabel);
        return new CommandResponse("You successfully bought the item " + itemLabel);
    }
}
