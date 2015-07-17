package collisions;

import java.util.ArrayList;

/**
 * Created by T540p on 2015-07-17.
 */

//TODO: synchronised, poprawne dzialanie listy obiektow
// TODO: sprawdzic czy wszystkie warunki sa sprawdzane
public class CollisionManager implements Runnable {
    final int MIN_SCREEN_LENGTH = 0, MIN_SCREEN_HEIGHT = 0;
    public ArrayList<SquareCollider> objectList; // lista obiektów do sprawdzania kolizji
    int MAX_SCREEN_LENGTH, MAX_SCREEN_HEIGHT;

    void leaveScreenCheck() {
        for (SquareCollider sc : objectList) {
            if (sc.getX() <= MIN_SCREEN_LENGTH) {
            } // wylazl z lewej
            if (sc.getY() <= MIN_SCREEN_HEIGHT) {
            } // wylazl z gory
            if (sc.getX() >= MAX_SCREEN_HEIGHT) {
            } // wylazl z dolu
            if (sc.getY() >= MAX_SCREEN_LENGTH) {
            } // wylazl z prawej
        }
    }

    void collisionCheck() {
        for (int i = 0; i < objectList.size(); i++)
            for (int j = 1; j < objectList.size(); j++) {
                haveCollided(objectList.get(i), objectList.get(j));
            }
    }

    void haveCollided(SquareCollider a, SquareCollider b) {
        if (contain(a, b)) {
            a.onCollision();
            b.onCollision();
        }

    }

    boolean contain(SquareCollider a, SquareCollider b) {
        if (a.getX() + a.getSideLength() < b.getX() || a.getX() > b.getX()) return false;
        else if (a.getY() < b.getY()) return false;
        else if (getLength(a.getX(), a.getY(), b.getX(), b.getY()) <= b.getSideLength()) return true;
        else if (getLength(a.getX() + a.getSideLength(), a.getY(), b.getX(), b.getY()) <= b.getSideLength())
            return true;
        else if (getLength(a.getX(), a.getY() + a.getSideLength(), b.getX(), b.getY()) <= b.getSideLength())
            return true;
        else
            return getLength(a.getX() + a.getSideLength(), a.getY() + a.getSideLength(), b.getX(), b.getY()) <= b.getSideLength();
    }

    double getLength(int a, int b, int x, int y) {
        return Math.sqrt(Math.pow(x - a, 2) + Math.pow(y - b, 2));
    }

    public void run() {
        collisionCheck();
    }
}
