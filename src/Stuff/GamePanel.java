package Stuff;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer = new Timer(1000/60, this);
	GameObject object;
	GamePanel() {
		object = new GameObject();
	}
	public void startGame() {
		timer.start();
	}
	public void paintComponent(Graphics g){
		object.draw(g);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		object.update();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("typed");
	}
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("pressed");
	}
	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("released");
	}
}
