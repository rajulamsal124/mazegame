package mazegame.entity;

import mazegame.entity.utility.StrengthTable;

public class Player extends Character {
    private Location currentLocation;
    private Inventory items;

    public Player(String name) {
        super(name);
        items = new FiniteInventory(StrengthTable.getInstance().getKey(getStrength()));
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Inventory getItems() {
        return items;
    }

    public void setItems(Inventory items) {
        this.items = items;
    }
}
