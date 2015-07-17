package collisions;

/**
 * Created by T540p on 2015-07-17.
 */
public abstract class SquareCollider {
    protected int x, y; //starting position
    protected int sideLength;

    public abstract boolean onCollision();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSideLength() {
        return sideLength;
    }
}
