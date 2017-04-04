package Stuff;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Alien extends GameObject {
	int x;
	int y;
	int width;
	int height;
	Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	void update() {
		super.update();
		y++;
		int change = new Random().nextInt(10);
		x = x + (change - 5);
	}
	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}
}
