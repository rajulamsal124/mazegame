package mazegame.control;

import mazegame.entity.Player;

public class HelpCommand implements Command {

    @Override
    public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
        if (userInput.getArguments().size() == 0) {
            return new CommandResponse("****HELP FOR PLAYING GAME****\n"
                    + "1. To move between location: move direction | Example: move west\n"
                    + "2. To buy/sell items in shop: buy/sell itemName| Example: buy/sell ak47\n"
                    + "3. To get/drop items found on location: get/drop itemName| Example: get/drop rbj\n"
                    + "4. To look for items available on location: look\n"
                    + "5. To see list of items carried by you: list\n"
                    + "6. To equip/unequip weapons and shield: equip/unequip itemName | Example: equip/unequip ak47\n"
                    + "7. To get maze game status(Current location): getmaze\n"
                    + "8. To flee to next possible location in danger: flee\n"
                    + "9. To collect the item to add life points: collect itemName | Example: collect blueberry\n"
                    + "10. To exit game: quit");
        }

        return new CommandResponse("This is a help Section.");
    }


}
