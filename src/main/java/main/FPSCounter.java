package main;

import basic.Base;
import basic.GameClass;

import java.awt.*;

public class FPSCounter implements GameClass {

    private Font font;
    private int i;
    private int FPS;
    private String stringFPS;
    private int FPSheight;

    FPSCounter() {
        font = new Font("Arial", Font.PLAIN, 15);
        i = 0;
        FPS = 0;
        stringFPS = "FPS:0";
        FPSheight = Base.stringHeight(font);
    }

    public void update() {
        i++;
        if (i == 60) {
            stringFPS = "FPS:" + Integer.toString(FPS);
            FPS = 0;
            i = 0;
        }
    }

    public void draw(Graphics2D g) {
        FPS++;
        g.setFont(font);
        g.setColor(Color.YELLOW);
        g.drawString(stringFPS, 0, FPSheight);
    }

}
