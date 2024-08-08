package mazegame.control;

import mazegame.entity.Player;

public class JoinPartyCommand implements Command {

    @Override
    public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
        if (userInput.getArguments().size() == 0) {
            return new CommandResponse("Tell me what item you want to buy: ");
        }
        return null;
    }

}
