package input;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Input implements KeyListener, MouseListener {
    public static Point getMousePosition() {
        return MouseInfo.getPointerInfo().getLocation();
    }

    public void mouseClicked(MouseEvent arg0) {

    }

    public void mouseEntered(MouseEvent arg0) {

    }

    public void mouseExited(MouseEvent arg0) {

    }

    public void mousePressed(MouseEvent arg0) {
        if (arg0.getButton() == MouseEvent.BUTTON1) {
            InputUtil.mouseButton1 = true;
        }
    }

    public void mouseReleased(MouseEvent arg0) {
        if (arg0.getButton() == MouseEvent.BUTTON1) {
            InputUtil.mouseButton1 = false;
        }
    }


    //-----
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) InputUtil.aKey = true;
        if (e.getKeyCode() == KeyEvent.VK_D) InputUtil.dKey = true;
        if (e.getKeyCode() == KeyEvent.VK_S) InputUtil.sKey = true;
        if (e.getKeyCode() == KeyEvent.VK_W) InputUtil.wKey = true;
        if (e.getKeyCode() == KeyEvent.VK_SPACE) InputUtil.spaceKey = true;
    }


    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) InputUtil.aKey = false;
        if (e.getKeyCode() == KeyEvent.VK_D) InputUtil.dKey = false;
        if (e.getKeyCode() == KeyEvent.VK_S) InputUtil.sKey = false;
        if (e.getKeyCode() == KeyEvent.VK_W) InputUtil.wKey = false;
        if (e.getKeyCode() == KeyEvent.VK_SPACE) InputUtil.spaceKey = false;
    }

}
