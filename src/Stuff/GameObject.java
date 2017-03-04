package Stuff;

import java.awt.Graphics;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	void update() {
		x++;
		y++;
	}
	void draw(Graphics graphics) {
		graphics.fillRect(x, y, 100, 100);
	}
}
