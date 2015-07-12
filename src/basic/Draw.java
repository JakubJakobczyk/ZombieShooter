package basic;

import java.awt.*;
import javax.swing.JPanel;

import main.Game;

class Draw extends JPanel implements Runnable {
    private static final long serialVersionUID = 1L;
    private Game g;
    public Color bgColor = Color.BLACK;


    // tymczasowo z braku lepszego pomyslu
    // daje do tej klasy keylistener'a
    // bo on musi byc dodawany w konstruktorze
    // i to w klasie ktore extenduje JPanel
    // a nie chce na sile dodawac tego gdzie indziej
    Draw(Game g) 
    {
        this.g = g;
    }

    public void run()
    {
        paintComponent(getGraphics());

        while (Base.isGameRunning)
            repaint();
    }

    public void paintComponent(Graphics graph) {
        try {
            Graphics2D g2d = (Graphics2D) graph;
            g2d.setColor(bgColor);
            g2d.fillRect(0, 0, getWidth(), getHeight());
            g.draw(g2d);
        } catch (NullPointerException e) {

        }
    }

}
