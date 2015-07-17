package items;

import basic.GameClass;

import java.awt.*;

/**
 * Created by T540p on 2015-05-24.
 */
public class Item implements GameClass {
    private Graphics2D icon;
    private double weight;
    private boolean equipped = false;

    public boolean isEquipped() {
        return equipped;
    }

    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public void draw(Graphics2D g) {

    }

    @Override
    public void update() {

    }

    public Graphics2D getIcon() {
        return icon;
    }

    public void setIcon(Graphics2D icon) {
        this.icon = icon;
    }
}
