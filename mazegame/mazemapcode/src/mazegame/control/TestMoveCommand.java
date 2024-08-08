package mazegame.control;

import mazegame.HardCodedData;
import mazegame.entity.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TestMoveCommand {
    private ParsedInput playerInput;
    private Player thePlayer;
    private CommandHandler handler;
    private MoveCommand move;
    private Location townSquare, kingsPalace;
    private HardCodedData hd;

    @Before
    public void setup() {
        hd = new HardCodedData();
        playerInput = new ParsedInput("get", new ArrayList<>());
        thePlayer = new Player("Manisha");
        townSquare = new Location("Town Square", "Center point of the map. Also, the starting point in the game.");
        kingsPalace = new Location("King's Palace", "King's Palace");
        townSquare.getExitCollection().addExit("east", new Exit("King's Palace", kingsPalace));
        kingsPalace.getExitCollection().addExit("west", new Exit("Town Square", townSquare));
        Item sword = new Weapon("sword", 200, 15, "Sword");
        sword.setDamage(25);
        kingsPalace.getInventory().addItem(sword);
        thePlayer.setCurrentLocation(townSquare);
        handler = new CommandHandler();
        move = new MoveCommand();
    }

    @Test
    public void testMoveNoWhere() {
        Assert.assertSame(townSquare, thePlayer.getCurrentLocation());
        // test move command no arguments
        CommandResponse response = move.execute(playerInput, thePlayer);
        Assert.assertFalse(response.isFinishedGame());
        Assert.assertTrue(response.getMessage().contains("If you want to move you need to tell me where."));
        Assert.assertSame(townSquare, thePlayer.getCurrentLocation());
    }

    @Test
    public void testMoveNoExit() {
        Assert.assertSame(townSquare, thePlayer.getCurrentLocation());
        playerInput.getArguments().add("west");
        // test move command no exit
        CommandResponse response = move.execute(playerInput, thePlayer);
        Assert.assertFalse(response.isFinishedGame());
        Assert.assertTrue(response.getMessage().contains("There is no exit there . . . try moving somewhere else!"));
        Assert.assertSame(townSquare, thePlayer.getCurrentLocation());
    }

    @Test
    public void testTakeExit() {
        Assert.assertSame(townSquare, thePlayer.getCurrentLocation());
        playerInput.getArguments().add("east");
        // test move command no exit
        CommandResponse response = move.execute(playerInput, thePlayer);
        Assert.assertFalse(response.isFinishedGame());
        Assert.assertTrue(response.getMessage().contains("You successfully move"));
        Assert.assertSame(kingsPalace, thePlayer.getCurrentLocation());
    }
}
