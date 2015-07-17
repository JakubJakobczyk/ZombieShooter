package menu;

import basic.Base;
import basic.GameClass;
import fonts.Fonts;
import input.Input;
import input.InputUtil;
import main.Game;
import main.gameStates;

import java.awt.*;
import java.util.ArrayList;

class MainMenu implements GameClass {

    private int width;
    private int height;
    private Rectangle titleRect;
    private Point mousePos;

    private ArrayList<MenuItem> menuItems;

    public MainMenu() {
        width = Base.getWidth();
        height = Base.getHeight();
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(width / 2 - (Base.stringWidth(Fonts.normalFont, "Survival") / 2), (int) (height * 0.40),
                "Survival", Color.WHITE, Color.CYAN, Fonts.normalFont));
        menuItems.add(new MenuItem(width / 2 - (Base.stringWidth(Fonts.normalFont, "Hardcore") / 2), (int) (height * 0.50),
                "Hardcore", Color.RED, Color.RED, Fonts.normalFont));
        menuItems.add(new MenuItem(width / 2 - (Base.stringWidth(Fonts.normalFont, "Exit") / 2), (int) (height * 0.60),
                "Exit", Color.RED, Color.RED, Fonts.normalFont));
        titleRect = new Rectangle(width / 2 - (Base.stringWidth(Fonts.titleFont, "Zombie Shooter Awesome Game") / 2), (int) (height * 0.25),
                Base.stringWidth(Fonts.titleFont, "Zombie Shooter Awesome Game"), Base.stringHeight(Fonts.titleFont));
        mousePos = Input.getMousePosition();
    }

    public void update() {
        mousePos = Input.getMousePosition();
        for (MenuItem item : menuItems) {
            if (item.rect.contains(mousePos)) {
                item.color = item.highlightedColor;
                if (InputUtil.mouseButton1 && item == menuItems.get(0)) {
                    Game.gameState = gameStates.SURVIVAL;
                }
            } else
                item.color = item.defaultColor;
        }
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.BLUE);
        g.setFont(Fonts.titleFont);
        g.drawString("Zombie Shooter Awesome Game", titleRect.x, titleRect.y);

        for (MenuItem i : menuItems) {
            g.setFont(i.font);
            g.setColor(i.color);
            g.drawString(i.string, i.rect.x, i.rect.y + Base.stringHeight(i.font));
        }
    }


}
