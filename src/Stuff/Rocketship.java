package Stuff;

import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	boolean up;
	boolean down;
	boolean left;
	boolean right;
	int speed;
	Rocketship(int x, int y, int width, int height, int speed) {
		super(x, y, width, height);
	
		this.speed = speed;
	}
	void up() {
		//super.update();
		y = y + speed;
	}
	void down() {
		//super.update();
		y = y - speed;
	}
	void left() {
		//super.update();
		x = x - speed;
	}
	void right() {
		//super.update();
		x = x + speed;
	}
	void draw(Graphics g) {
		g.drawImage(GamePanel.rocketImg, x, y, width, height, null);
	}
}
