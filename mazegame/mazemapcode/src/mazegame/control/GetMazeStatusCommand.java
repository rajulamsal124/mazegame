package mazegame.control;

import mazegame.entity.FiniteInventory;
import mazegame.entity.Player;

public class GetMazeStatusCommand implements Command {

    @Override
    public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
        if (userInput.getArguments().size() == 0) {

            String loc = thePlayer.getCurrentLocation().getDescription();

            return new CommandResponse(String.format("Current Maze Location: %s\nLife points: %d\nGold coin available: %d\nStrength: %d\nAgility: %d\nCarrying capacity: %.2f\nWeight carried: %.2f"
                    , loc
                    , thePlayer.getLifePoints()
                    , thePlayer.getItems().getMoney().getTotal()
                    , thePlayer.getStrength()
                    , thePlayer.getAgility()
                    , ((FiniteInventory) thePlayer.getItems()).getWeightLimit()
                    , ((FiniteInventory) thePlayer.getItems()).getWeight()
            ));
        }

        return null;
    }
}
