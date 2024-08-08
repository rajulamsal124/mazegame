package mazegame.entity;

public class Location {
    private Inventory items;
    private ExitCollection exitCollection;
    private String description;

    private NonPlayerCharacter nonPlayerCharacter;

    public NonPlayerCharacter getNonPlayerCharacter() {
        return nonPlayerCharacter;
    }

    public void setNonPlayerCharacter(NonPlayerCharacter nonPlayerCharacter) {
        this.nonPlayerCharacter = nonPlayerCharacter;
    }

    private String label;

    public Location() {
        exitCollection = new ExitCollection();
        items = new Inventory();
    }

    public Location(String description, String label) {
        this();
        this.setDescription(description);
        this.setLabel(label);
    }

    public Inventory getInventory() {
        return items;
    }

    public ExitCollection getExitCollection() {
        return exitCollection;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String toString() {
        return "**********\n"
                + this.description + " - " + this.label
                + "\n**********\n"
                + "Exits found :: " + exitCollection.availableExits()
                + "\n**********\n"
                + items.toString()
                + getNpcDetails()
                + "\n**********";
    }

    private String getNpcDetails() {
        if (nonPlayerCharacter == null)
            return "";
        String hostile = nonPlayerCharacter.getHostile() ? "hostile" : "not hostile";
        return "\n**********\nNPC found: " + nonPlayerCharacter.getName() + ". The NPC is " + hostile + " and has life points of "
                + nonPlayerCharacter.getLifePoints()+ " . You can attack by equipping a weapon or flee the area.";
    }

}
