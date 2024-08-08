package mazegame.control;

import mazegame.entity.Exit;
import mazegame.entity.Player;

public class LookCommand implements Command {

    @Override
    public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
        CommandResponse response = new CommandResponse("Can't find that to look at here!");
        if (userInput.getArguments().size() == 0) {
            response.setMessage(thePlayer.getCurrentLocation().toString());
            return response;
        }
        for (String argument : userInput.getArguments()) {
            if (thePlayer.getCurrentLocation().getExitCollection().containsExit(argument)) {
                Exit theExit = thePlayer.getCurrentLocation().getExitCollection().getExit(argument);

                return new CommandResponse(theExit.getDescription());
            }
        }
        return response;
    }
}
