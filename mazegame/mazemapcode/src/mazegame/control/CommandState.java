package mazegame.control;

import mazegame.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class CommandState {
    private HashMap<String, Command> availableCommands;

    public abstract CommandState update(Player thePlayer);

    public CommandState() {
        availableCommands = new HashMap<String, Command>();
    }

    public HashMap<String, Command> getAvailableCommands() {
        return this.availableCommands;
    }

    public void setAvailableCommands(HashMap<String, Command> hashmap) {
        availableCommands = hashmap;
    }

    public Command getCommand(String commandLabel) {
        return availableCommands.get(commandLabel);
    }

    public ArrayList<String> getLabels() {
        return new ArrayList<String>(availableCommands.keySet());
    }
}

