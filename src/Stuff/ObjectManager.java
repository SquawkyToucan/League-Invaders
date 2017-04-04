package Stuff;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	ArrayList<GameObject> objects;
	
	private int score = 0;
	
	long enemyTimer = 0;
	int enemySpawnTime = 2500;
	
	public ObjectManager() {
		objects = new ArrayList<GameObject>();
	}

	public void addObject(GameObject o) {
		objects.add(o);
		System.out.println("Object successfully added.");
		System.out.println(objects.size());
	}

	public void update() {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.update();
			System.out.println("Updated items");
			System.out.println("김정은");
		}
	}

	public void draw(Graphics g) {
		System.out.println(objects.size());
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.draw(g);
		}
		purgeObjects();
	}

	private void purgeObjects() {
		for (int i = 0; i < objects.size(); i++) {
			if (!objects.get(i).isAlive) {
				objects.remove(i);
			}
		}
	}

	public void manageEnemies(){
		if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
			addObject(new Alien(new Random().nextInt(500), 0, 50, 50));
			enemyTimer = System.currentTimeMillis();
		}
	}
	public void checkCollision() {
		System.out.println("check collision");
		for (int i = 0; i < objects.size(); i++) {
			for (int j = i + 1; j < objects.size(); j++) {
				GameObject o1 = objects.get(i);
				GameObject o2 = objects.get(j);
				
				if(o1.collisionBox.intersects(o2.collisionBox)){
					if((o1 instanceof Alien && o2 instanceof Projectile) ||
					   (o2 instanceof Alien && o1 instanceof Projectile)){
						score++;
						System.out.println("hi");
						o1.isAlive = false;
						o2.isAlive = false;
					}
					else if((o1 instanceof Alien && o2 instanceof Rocketship) ||
							(o2 instanceof Alien && o1 instanceof Rocketship)){
						o1.isAlive = false;
						o2.isAlive = false;
					}   
				}
			}
		}
	}
	
	public int getScore(){
		return score;
	}
	
	public void setScore(int s){
		score = s;
	}
	
	public void reset(){
		objects.clear();
	}
}
