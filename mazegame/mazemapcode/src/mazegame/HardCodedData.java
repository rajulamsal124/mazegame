package mazegame;

import mazegame.boundary.IMazeData;
import mazegame.entity.*;
import mazegame.entity.utility.AgilityTable;
import mazegame.entity.utility.StrengthTable;
import mazegame.entity.utility.WeightLimit;


public class HardCodedData implements IMazeData {
   private Location safeHouse, lightHouse, weaponInventory, supplies, townSquare, laboratory, garage, zombieIslands;
   
    private NonPlayerCharacter npcHostile, npcNonHostile;

    public HardCodedData() {
        populateWeightLimitTable();
        populateStrengthTable();
        populateAgilityTable();
        createCharacters();
        createLocations();
        createItems();
    }

    private void createLocations() {
        safeHouse = new Location("Safe House", "Common place to meet, drink and dine.");
        safeHouse.setNonPlayerCharacter(npcNonHostile);
        lightHouse = new Location("Light House", "Tower to keep watch.");
        weaponInventory = new Shop("Weapon Inventory", "Buy or sell weapons here.");
        supplies = new Shop("Supplies", "Buy consumables here.");
        townSquare = new Location("Town Square", "Center point of the map. Also, the starting point in the game.");
        laboratory = new Location("Laboratory", "Laboratory for Zombie Research");
        garage = new Location("Garage", "To find the vehicle.");
        zombieIslands = new Location("Zombie Island", "A forbidden place where Zombies can be found.");
        zombieIslands.setNonPlayerCharacter(npcHostile);

        safeHouse.getExitCollection().addExit("south", new Exit("Supplies", supplies));
        safeHouse.getExitCollection().addExit("east", new Exit("Light House", lightHouse));

        lightHouse.getExitCollection().addExit("east", new Exit("Weapon Inventory", weaponInventory));
        lightHouse.getExitCollection().addExit("west", new Exit("Safe House", safeHouse));
        lightHouse.getExitCollection().addExit("south", new Exit("Town Square", townSquare));

        weaponInventory.getExitCollection().addExit("west", new Exit("Light House", lightHouse));
        weaponInventory.getExitCollection().addExit("south", new Exit("Laboratory", laboratory));

        supplies.getExitCollection().addExit("north", new Exit("Safe House", safeHouse));
        supplies.getExitCollection().addExit("east", new Exit("Town Square", townSquare));

        townSquare.getExitCollection().addExit("east", new Exit("Laboratory", laboratory));
        townSquare.getExitCollection().addExit("west", new Exit("Supplies", supplies));
        townSquare.getExitCollection().addExit("north", new Exit("Light House ", lightHouse));
        townSquare.getExitCollection().addExit("south", new Exit("garage", garage));

        laboratory.getExitCollection().addExit("north", new Exit("Weapon Inventory", weaponInventory));
        laboratory.getExitCollection().addExit("west", new Exit("Town Square", townSquare));
        laboratory.getExitCollection().addExit("south", new Exit("Zombie Island", zombieIslands));

        garage.getExitCollection().addExit("north", new Exit("Town Square", townSquare));
        garage.getExitCollection().addExit("east", new Exit("Zombie Island", zombieIslands));

        zombieIslands.getExitCollection().addExit("north", new Exit("Laboratory", laboratory));
        zombieIslands.getExitCollection().addExit("west", new Exit("Garage", garage));
    }

    private void createCharacters() {
        npcHostile = new NonPlayerCharacter("Zombie", true);
        npcHostile.setLifePoints(100);
        npcNonHostile = new NonPlayerCharacter("Peter", false);
        npcNonHostile.setLifePoints(50);
    }

    private void createItems() {
        Item sword = new Weapon("sword", 200, 15, "Sword");
        sword.setDamage(25);
        Item spear = new Weapon("spear", 300, 15, "Long spear");
        spear.setDamage(20);
        Item axe = new Weapon("axe", 150, 100, "Powerful but heavy axe.");
        axe.setDamage(20);
        Item crossbow = new Weapon("crossbow", 200, 10, "Able to use from distance.");
        crossbow.setDamage(10);
        Item knife = new Weapon("knife", 5, 50, "Light and easy to carry.");
        knife.setDamage(5);

        Item helmet = new Shield("helmet", 10, 5, "Protect head injuries.");
        Item armor = new Shield("armor", 25, 15, "Protect body from attacks.");

        Item healthPotion = new Armor("potion", 20, 3, "Health potion to heal from injuries.");
        Item apple = new Armor("apple", 10, 2, "Heal from injuries.");
        Item berry = new Armor("berry", 5, 1, "Get 1 health point per berry.");

        weaponInventory.getInventory().addItem(sword);
        weaponInventory.getInventory().addItem(spear);
        weaponInventory.getInventory().addItem(axe);
        weaponInventory.getInventory().addItem(crossbow);
        weaponInventory.getInventory().addItem(knife);
        weaponInventory.getInventory().addItem(helmet);
        weaponInventory.getInventory().addItem(armor);

        supplies.getInventory().addItem(healthPotion);
        supplies.getInventory().addItem(apple);
        supplies.getInventory().addItem(berry);

        townSquare.getInventory().addItem(apple);
        townSquare.getInventory().addItem(knife);

        lightHouse.getInventory().addItem(sword);
        lightHouse.getInventory().addItem(knife);
        lightHouse.getInventory().addItem(healthPotion);
        lightHouse.getInventory().addItem(armor);

        laboratory.getInventory().addItem(axe);
        laboratory.getInventory().addItem(sword);
        laboratory.getInventory().addItem(helmet);
        laboratory.getInventory().addItem(apple);

        garage.getInventory().addItem(berry);
        garage.getInventory().addItem(apple);

        zombieIslands.getInventory().addItem(spear);
        zombieIslands.getInventory().addItem(crossbow);
        zombieIslands.getInventory().addItem(helmet);
        zombieIslands.getInventory().addItem(armor);
        zombieIslands.getInventory().addItem(healthPotion);
    }

    @Override
    public Location getStartingLocation() {
        return townSquare;
    }

    @Override
    public String getWelcomeMessage() {
        return "Developer:Raju Lamsal | Prabin Maharjan\n"
                + "WELCOME TO THE MAZE GAME \n";
    }

    private void populateStrengthTable() {
        StrengthTable strengthModifiers = StrengthTable.getInstance();
        strengthModifiers.setModifier(1, 30);
        strengthModifiers.setModifier(2, 40);
        strengthModifiers.setModifier(3, 50);
        strengthModifiers.setModifier(4, 60);
        strengthModifiers.setModifier(5, 70);
        strengthModifiers.setModifier(6, 80);
    }

    private void populateAgilityTable() {
        AgilityTable agilityModifiers = AgilityTable.getInstance();
        agilityModifiers.setModifier(1, 30);
        agilityModifiers.setModifier(2, 40);
        agilityModifiers.setModifier(3, 50);
        agilityModifiers.setModifier(4, 60);
        agilityModifiers.setModifier(5, 70);
        agilityModifiers.setModifier(6, 60);
    }

    private void populateWeightLimitTable() {
        WeightLimit weightModifier = WeightLimit.getInstance();
        weightModifier.setModifier(1, 40);
        weightModifier.setModifier(2, 50);
        weightModifier.setModifier(3, 60);
        weightModifier.setModifier(4, 70);
        weightModifier.setModifier(5, 80);
        weightModifier.setModifier(6, 90);
    }
}
