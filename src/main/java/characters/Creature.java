package characters;

import basic.GameClass;
import collisions.SquareCollider;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 * Created by T540p on 2015-05-21.
 */
public class Creature extends SquareCollider implements IDamageable, GameClass {

    protected int x, y; // position
    protected double angle = 0.0; //
    protected int max_hp;
    protected int hp;
    protected int armor;
    protected int evasiveness;
    protected int strength;
    protected int mov_speed;
    protected boolean immune;
    //protected Graphics2D sprite;
    protected Image img;

    public Creature(int x, int y, int colliderSideLength) {
        this.x = x;
        this.y = y;
        this.sideLength = colliderSideLength;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getEvasiveness() {
        return evasiveness;
    }

    public void setEvasiveness(int evasiveness) {
        this.evasiveness = evasiveness;
    }

    /*public Graphics2D getSprite() {
        return sprite;
    }

    public void setSprite(Graphics2D sprite) {
        this.sprite = sprite;
    }*/

    @Override
    public boolean dealDmg(int damage) {
        if (isImmune())
            return false;
        else
            setHp(getHp() - damage);
        return true;
    }

    @Override
    public boolean death() {
        return true;
    }

    @Override
    public boolean heal(int heal_amount) {
        if (getHp() == getMax_hp())
            return false;
        else
            setHp(getHp() + heal_amount);

        return true;
    }

    public int getMax_hp() {
        return max_hp;
    }

    public void setMax_hp(int max_hp) {
        this.max_hp = max_hp;
    }

    public boolean isImmune() {

        return immune;
    }

    public void setImmune(boolean immune) {
        this.immune = immune;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getevasiveness() {
        return evasiveness;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getMov_speed() {
        return mov_speed;
    }

    public void setMov_speed(int mov_speed) {
        this.mov_speed = mov_speed;
    }

    public void setevasiveness(int evasiveness) {
        this.evasiveness = evasiveness;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    @Override
    public void draw(Graphics2D g) {
        BufferedImage bImg = (BufferedImage) img;
        AffineTransform at = AffineTransform.getTranslateInstance((getX() - img.getWidth(null)) / 2, (getY() - img.getHeight(null)) / 2);

        at.rotate(-angle + (Math.PI), bImg.getWidth() / 2, bImg.getHeight() / 2);

        g.drawImage(bImg, at, null);
    }

    @Override
    public void update() {

    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void rotate(Point targetPosition) {
        int tarX = (int) targetPosition.getX();
        int tarY = (int) targetPosition.getY();

        double rotation = Math.atan2(tarX - (x / 2), tarY - (y / 2));

//warunek ¿eby ujemnych nie by³o
        if (rotation < 0) {
            rotation += Math.PI * 2;
        }

        this.angle = rotation;
    }

    @Override
    public boolean onCollision() {
        return false;
    }
}
