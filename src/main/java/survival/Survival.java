package survival;

import basic.GameClass;
import characters.Player;

import java.awt.*;

public class Survival implements GameClass {

    Player p;

    public Survival() {
        p = new Player(860, 540);
    }

    public void update() {
        p.update();
    }

    public void draw(Graphics2D g) {
        p.draw(g);
    }

}
