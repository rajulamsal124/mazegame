package mazegame.control;

import mazegame.entity.Player;

public class ListCommand implements Command {
    @Override
    public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
        return new CommandResponse(thePlayer.getItems().toString());
    }
}
