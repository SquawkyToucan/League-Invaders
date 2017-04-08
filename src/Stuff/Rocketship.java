package Stuff;

import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	
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
	/*
	 *void update(){
		super.update();
		if(up == true){
			y=y-speed;
		}
		if(down == true){
			y=y+speed;
		}
		if(right == true){
			x=x+speed;
		}
		if(left == true){
			x=x-speed;
		}
	}
	 */
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
}
