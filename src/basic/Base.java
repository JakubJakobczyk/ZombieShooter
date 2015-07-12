package basic;

import input.Input;

import java.awt.*;

import javax.swing.*;

import main.Game;

public class Base {
    public static boolean isGameRunning;
    private static Draw d;

    public static void main(String[] args)
    {

//game set
        isGameRunning = true;
        Game g = new Game();
        d = new Draw(g);
        Input input = new Input();
        
        Thread draw = new Thread(d);
        Thread update = new Thread(new Update(g));
        
//window set
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = env.getDefaultScreenDevice();
        JFrame window = new JFrame();
        setWindow(window);
        window.addKeyListener(input);
        window.addMouseListener(input);
        window.setContentPane(d);
        gd.setFullScreenWindow(window);
//------
        g.initialize();
        draw.start();
        update.start();
    }

    private static void setWindow(JFrame window) 
    {
		window.setUndecorated(true);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    //public methods
    public static int getHeight()
    {
        return d.getHeight();
    }

    public static int getWidth()
    {
        return d.getWidth();
    }

    public static void setBackgroundColor(Color color)
    {
        d.bgColor = color;
    }

    public static Graphics getGraphic()
    {
        return d.getGraphics();
    }

    public static int stringHeight(Font f)
    {
        return d.getGraphics().getFontMetrics(f).getHeight();
    }

    public static int stringWidth(Font f, String s)
    {
        return d.getGraphics().getFontMetrics(f).stringWidth(s);
    }

}
