package mazegame.control;

import java.util.ArrayList;

public class ParsedInput {
    private String command;
    private ArrayList<String> arguments;

    public ParsedInput() {
        setArguments(new ArrayList<>());
        setCommand("");
    }

    public ParsedInput(String command, ArrayList<String> arguments) {
        this.setCommand(command);
        this.setArguments(arguments);
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public ArrayList<String> getArguments() {
        return arguments;
    }

    public void setArguments(ArrayList<String> arguments) {
        this.arguments = arguments;
    }
}