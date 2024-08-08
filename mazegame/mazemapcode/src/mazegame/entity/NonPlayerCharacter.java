package mazegame.entity;

public class NonPlayerCharacter extends Character {

    private String name;
    private Boolean hostile;

    public NonPlayerCharacter(String name, Boolean hostile) {
        super();
        this.name = name;
        this.hostile = hostile;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public boolean getHostile() {
        return this.hostile;
    }

    public void setHostile(boolean hostile) {
        this.hostile = hostile;
    }
}
