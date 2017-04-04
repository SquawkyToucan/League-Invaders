package Stuff;

import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject{
	boolean isAlive = true;
	int x;
	int y;
	int width;
	int height;
	int speed;
	Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		speed = 10;
	}
	void update() {
		super.update();
		System.out.println("projectile updating");
		int speed = 10;
		y = y - speed;
		if(y < 0) {
			isAlive = false;
		}
	}
	void draw(Graphics g) {
		g.setColor(new Color(255, 0, 0));
		g.fillRect(x, y, width, height);
	}
}
