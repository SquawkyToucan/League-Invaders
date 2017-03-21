package Stuff;

import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	int x;
	int y;
	int width;
	int height;
	int speed;
	Rocketship(int x, int y, int width, int height, int speed) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
	}
	void up() {
		y = y + speed;
	}
	void down() {
		y = y - speed;
	}
	void left() {
		x = x - speed;
	}
	void right() {
		x = x + speed;
	}
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
}
