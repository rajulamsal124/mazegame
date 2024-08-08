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

public class TestGetCommand {
    private ParsedInput playerInput;
    private Player thePlayer;
    private CommandHandler handler;
    private GetCommand get;
    private Location northTower;
    private Item spear = new Weapon("spear", 300, 15, "Long spear");
    private HardCodedData hd;

    @Before
    public void setup() {
        hd = new HardCodedData();
        playerInput = new ParsedInput("get", new ArrayList<>());
        thePlayer = new Player("Sagar");
        northTower = new Location("North Tower", "Tower to keep watch.");
        northTower.getInventory().addItem(spear);
        thePlayer.setCurrentLocation(northTower);
        handler = new CommandHandler();
        get = new GetCommand();
    }

    @Test
    public void testGetNoArg() {
        Assert.assertSame(northTower, thePlayer.getCurrentLocation());
        // test get command no arguments
        CommandResponse response = get.execute(playerInput, thePlayer);
        Assert.assertFalse(response.isFinishedGame());
        Assert.assertTrue(response.getMessage().contains("Tell me what item you want to get: "));
        Assert.assertSame(northTower, thePlayer.getCurrentLocation());
    }

    @Test
    public void testGetNoItem() {
        Assert.assertSame(northTower, thePlayer.getCurrentLocation());
        playerInput.getArguments().add("west");
        // test get command no item
        CommandResponse response = get.execute(playerInput, thePlayer);
        Assert.assertFalse(response.isFinishedGame());
        Assert.assertTrue(response.getMessage().contains("We don't have this item here"));
        Assert.assertSame(northTower, thePlayer.getCurrentLocation());
    }

    @Test
    public void testGetItem() {
        Assert.assertSame(northTower, thePlayer.getCurrentLocation());
        playerInput.getArguments().add("spear");
        // test move command no exit
        CommandResponse response = get.execute(playerInput, thePlayer);
        Assert.assertFalse(response.isFinishedGame());
        Assert.assertTrue(response.getMessage().contains("You successfully got the item"));
        Assert.assertSame(northTower, thePlayer.getCurrentLocation());
        Assert.assertTrue(thePlayer.getCurrentLocation().getInventory().addItem(spear));
    }
}
