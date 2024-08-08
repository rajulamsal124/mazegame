package mazegame.control;

import mazegame.HardCodedData;
import mazegame.entity.Item;
import mazegame.entity.Location;
import mazegame.entity.Player;
import mazegame.entity.Weapon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TestDropCommand {
    private ParsedInput playerInput;
    private Player thePlayer;
    private CommandHandler handler;
    private DropCommand drop;
    private Location townSquare;
    private Item sword;
    private HardCodedData hd;


    @Before
    public void setup() {
        hd = new HardCodedData();
        playerInput = new ParsedInput("drop", new ArrayList<>());
        sword = new Weapon("sword", 200, 15, "Sword");
        sword.setDamage(25);
        thePlayer = new Player("Rahul");
        townSquare = new Location("Town Square", "Center point of the map. Also, the starting point in the game.");
        thePlayer.getItems().addItem(sword);
        thePlayer.setCurrentLocation(townSquare);
        handler = new CommandHandler();
        drop = new DropCommand();
    }

    @Test
    public void testDropNoArg() {
        Assert.assertSame(townSquare, thePlayer.getCurrentLocation());
        // test drop command no arguments
        CommandResponse response = drop.execute(playerInput, thePlayer);
        Assert.assertFalse(response.isFinishedGame());
        Assert.assertTrue(response.getMessage().contains("Tell me what item you want to drop: "));
        Assert.assertSame(townSquare, thePlayer.getCurrentLocation());
    }

    @Test
    public void testDropNoItem() {
        Assert.assertSame(townSquare, thePlayer.getCurrentLocation());
        playerInput.getArguments().add("west");
        // test drop command no item
        CommandResponse response = drop.execute(playerInput, thePlayer);
        Assert.assertFalse(response.isFinishedGame());
        Assert.assertTrue(response.getMessage().contains("We don't have the item with name "));
        Assert.assertSame(townSquare, thePlayer.getCurrentLocation());
    }

    @Test
    public void testDropItem() {
        Assert.assertSame(townSquare, thePlayer.getCurrentLocation());
        playerInput.getArguments().add("sword");
        // test Drop command
        CommandResponse response = drop.execute(playerInput, thePlayer);
        Assert.assertFalse(response.isFinishedGame());
        Assert.assertSame(townSquare, thePlayer.getCurrentLocation());
        Assert.assertTrue(response.getMessage().contains("You successfully dropped the item sword"));
    }
}
