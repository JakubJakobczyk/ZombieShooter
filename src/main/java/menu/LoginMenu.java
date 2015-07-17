package menu;

import basic.Base;
import basic.GameClass;
import fonts.Fonts;
import input.Input;
import input.InputUtil;

import java.awt.*;

class LoginMenu implements GameClass {

    private int width;
    private int height;
    private Rectangle titleRect;
    private Rectangle loginRect;
    private Point mousePos;
    private Color loginColor;

    public LoginMenu() {
        width = Base.getWidth();
        height = Base.getHeight();
        loginRect = new Rectangle(width / 2 - (Base.stringWidth(Fonts.normalFont, "Log me in!") / 2), (int) (height * 0.5),
                Base.stringWidth(Fonts.normalFont, "Log me in!"), Base.stringHeight(Fonts.normalFont));
        titleRect = new Rectangle(width / 2 - (Base.stringWidth(Fonts.titleFont, "Login") / 2), (int) (height * 0.25),
                Base.stringWidth(Fonts.titleFont, "Login"), Base.stringHeight(Fonts.titleFont));
        mousePos = Input.getMousePosition();
        loginColor = Color.WHITE;
    }

    public void update() {
        mousePos = Input.getMousePosition();
        if (loginRect.contains(mousePos) || InputUtil.wKey == true) {
            loginColor = Color.CYAN;
            if (InputUtil.mouseButton1) {
                MenuHandler.menuState = MenuHandler.menuStates.main;
                InputUtil.mouseButton1 = false;
            }
        } else loginColor = Color.WHITE;
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.BLUE);
        g.setFont(Fonts.titleFont);
        g.drawString("Login", titleRect.x, titleRect.y);
        g.setColor(loginColor);
        g.setFont(Fonts.normalFont);
        g.drawString("Log me in!", loginRect.x, loginRect.y + Base.stringHeight(Fonts.normalFont));
    }

}
