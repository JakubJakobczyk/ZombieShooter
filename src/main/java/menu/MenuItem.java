package menu;

import basic.Base;

import java.awt.*;

public class MenuItem {
    Rectangle rect;
    String string;
    Color defaultColor;
    Color highlightedColor;
    Color color;
    Font font;

    MenuItem(int x, int y, String s, Color defaultColor, Color highlightedColor, Font f) {
        rect = new Rectangle(x, y, Base.stringWidth(f, s), Base.stringHeight(f));
        this.string = s;
        this.defaultColor = defaultColor;
        this.highlightedColor = highlightedColor;
        this.font = f;
        color = defaultColor;
    }
}
