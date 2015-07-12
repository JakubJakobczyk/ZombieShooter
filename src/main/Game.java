package main;

import java.awt.Graphics2D;

import survival.Survival;
import characters.Player;
import menu.MenuHandler;
import basic.*;


public class Game implements GameClass
{
    /*
    private enum gameStates
    {
        menu,
        survival,
        hardcore
    }*/
    public static gameStates gameState;
    private FPSCounter fps;

    private MenuHandler menu;
    private Survival survival;
    //private Hardcore hardcore;

    public Game() 
    {
    
    }

    public void initialize()
    {
        fps = new FPSCounter();
        menu = new MenuHandler();
        survival = new Survival();
        gameState = gameStates.MENU;
    }

    public void update() 
    {
        fps.update();
        switch (gameState) 
        {
            case SURVIVAL:
            	survival.update();
                break;
            case HARDCORE:
                break;
            case MENU:
                menu.update();
                break;
        }
    }

    public void draw(Graphics2D g)
    {
        fps.draw(g);
        switch (gameState)
        {
            case SURVIVAL:
            	survival.draw(g);
                break;
            case HARDCORE:
                break;
            case MENU:
                menu.draw(g);
                break;
        }
    }
}
