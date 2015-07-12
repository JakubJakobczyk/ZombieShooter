package menu;

import java.awt.Graphics2D;

import basic.GameClass;

public class MenuHandler implements GameClass {
    enum menuStates 
    {
        main,
        login,
        options,
        credits
    }

    static menuStates menuState;

    private LoginMenu loginMenu;
    private MainMenu mainMenu;

    public MenuHandler() 
    {
        loginMenu = new LoginMenu();
        mainMenu = new MainMenu();
        menuState = menuStates.login;
    }

    public void update() 
    {
        switch (menuState) 
        {
            case login:
                loginMenu.update();
                break;
            case main:
                mainMenu.update();
                break;
        }

    }

    public void draw(Graphics2D g) {
        switch (menuState) {
            case login:
                loginMenu.draw(g);
                break;
            case main:
                mainMenu.draw(g);
                break;
        }

    }
}
