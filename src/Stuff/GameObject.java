package Stuff;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	boolean isAlive = true;
	Rectangle collisionBox;
	GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		collisionBox = new Rectangle();
		collisionBox.setBounds(this.x, this.y, this.width, this.height);
	}
	void update() {
		collisionBox.setBounds(x, y, width, height);
	}
	void draw(Graphics graphics) {
		//graphics.fillRect(x, y, 100, 100);
	}	
} 