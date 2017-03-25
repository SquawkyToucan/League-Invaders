package Stuff;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	boolean isAlive;
	void update() {
		
	}
	void draw(Graphics graphics) {
		graphics.fillRect(x, y, 100, 100);
	}
	
}
