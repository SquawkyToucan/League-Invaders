package Stuff;

import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject{
	boolean isAlive = true;
	
	int speed;
	Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
	
		speed = 10;
	}
	void update() {
		super.update();
		//System.out.println("projectile updating");
		speed = 10;
		y = y - speed;
		if(y < 0) {
			isAlive = false;
		}
	}
	void draw(Graphics g) {
		g.drawImage(GamePanel.rocketImg, x, y, width, height, null);

	}
}
