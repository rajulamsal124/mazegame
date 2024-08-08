package mazegame.entity;

import mazegame.entity.utility.AgilityTable;
import mazegame.entity.utility.DiceRoller;
import mazegame.entity.utility.StrengthTable;

public class Character {
    private int agility;
    private int lifePoints;
    private String name;
    private int strength;

    public Shield m_Shield;

    public Shield getM_Shield() {
        return m_Shield;
    }

    public void setM_Shield(Shield m_Shield) {
        this.m_Shield = m_Shield;
    }

    public Weapon m_Weapon;
    public Armor m_Armor;

    public Armor getM_Armor() {
        return m_Armor;
    }

    public void setM_Armor(Armor m_Armor) {
        this.m_Armor = m_Armor;
    }

    public Weapon getM_Weapon() {
        return m_Weapon;
    }

    public void setM_Weapon(Weapon m_Weapon) {
        this.m_Weapon = m_Weapon;
    }

    public Character() {
        agility = AgilityTable.getInstance().getModifier(DiceRoller.GetInstance().generateAbilityScore());
        strength = StrengthTable.getInstance().getModifier(DiceRoller.GetInstance().generateAbilityScore());
    }

    public Character(String name) {
        this.setName(name);
        m_Weapon = null;
        m_Shield = null;
        agility = AgilityTable.getInstance().getModifier(DiceRoller.GetInstance().generateAbilityScore());
        strength = StrengthTable.getInstance().getModifier(DiceRoller.GetInstance().generateAbilityScore());
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    private void setStrength(int strength) {
        this.strength = strength;
    }
}
