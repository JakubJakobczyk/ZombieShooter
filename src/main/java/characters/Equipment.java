package characters;

import basic.GameClass;
import items.Item;
import items.weapons.Weapon;

import java.awt.*;

/**
 * Created by T540p on 2015-05-24.
 */
public class Equipment implements GameClass {

    private double total_weight;
    private double max_weight;
    private Item[] bag; // miejsce na itemy w plecaku?
    private Weapon weapon;

    public double getTotal_weight() {
        return total_weight;
    }

    public void setTotal_weight(double total_weight) {
        this.total_weight = total_weight;
    }

    public double getMax_weight() {
        return max_weight;
    }

    public void setMax_weight(double max_weight) {
        this.max_weight = max_weight;
    }

    public Item[] getBag() {
        return bag;
    }

    public void setBag(Item[] bag) {
        this.bag = bag;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public void draw(Graphics2D g) {

    }

    @Override
    public void update() {

    }
}
