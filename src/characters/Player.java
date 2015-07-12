package characters;

import input.Input;
import input.InputUtil;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.*;

/**
 * Created by T540p on 2015-05-21.
 */
public class Player extends Creature {
    private Equipment eq;

    // coordinates + image
    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        mov_speed = 15;

        File img_file = new File("resources/images/player/player_temp.png");
        BufferedImage img;
        try {
            img = ImageIO.read(img_file);
            //Graphics2D sprite = img.createGraphics();
            //this.setSprite(sprite);
            this.setImg(img);
        } catch (IOException e) {
        }

    }

    public Equipment getEq() {
        return eq;
    }

    public void setEq(Equipment eq) {
        this.eq = eq;
    }

    @Override
    public void update()
    {
        this.rotate(Input.getMousePosition());
        
        if (InputUtil.wKey)
        {
        	x += Math.sin(getAngle())*mov_speed;
        	y += Math.cos(getAngle())*mov_speed;
        }
        
        if (InputUtil.sKey)
        {
        	x -= Math.sin(getAngle())*mov_speed;
        	y -= Math.cos(getAngle())*mov_speed;
        }
        
        if (InputUtil.spaceKey)
        {
        	mov_speed += 1;
        	InputUtil.spaceKey = false;
        }
    }
}
