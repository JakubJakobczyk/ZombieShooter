package survival;

import input.InputUtil;

import java.awt.Graphics2D;

import basic.GameClass;
import characters.Player;

public class Survival implements GameClass {

	Player p;
	
	public Survival()
	{
		p = new Player(860, 540);
	}
	
	public void update() 
	{
		p.update();
	}

	public void draw(Graphics2D g) 
	{
		p.draw(g);
	}
	
}
