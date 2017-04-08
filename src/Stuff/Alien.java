package Stuff;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Alien extends GameObject {

	boolean isAlive;
	Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		isAlive = true;
	}
	void update() {
		super.update();
		y++;
		//int movethis = new Random().nextInt(6);
		//x = x + (movethis - 3);
	}
	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}
}
