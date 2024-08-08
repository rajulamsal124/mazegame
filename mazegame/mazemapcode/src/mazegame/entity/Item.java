package mazegame.entity;

public abstract class Item {

    private String label;
    private int value;
    private double weight;
    private String description;

    private int damage;

    public Item(String label, int value, double weight, String description) {
        this.label = label;
        this.value = value;
        this.weight = weight;
        this.description = description;
    }

    public String getLabel() {
        return label;
    }

    public int getValue() {
        return value;
    }

    public double getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "Item{" +
                "label='" + label + '\'' +
                ", value=" + value +
                ", weight=" + weight +
                ", description='" + description + '\'' +
                '}';
    }
}
