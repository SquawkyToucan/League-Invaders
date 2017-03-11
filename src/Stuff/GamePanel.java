package Stuff;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Graphics graphics;
	Timer timer = new Timer(1000/60, this);
	GameObject object;
	GamePanel() {
		object = new GameObject();
	}
	public void updateMenuState() {
		drawMenuState(graphics);
	}
	public void updateGameState() {
		drawGameState(graphics);
	}
	public void updateEndState() {
		drawEndState(graphics);
	}
	public void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 500, 800);
	}
	public void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 800);
	}
	public void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, 500, 800);
	}
	public void startGame() {
		timer.start();
	}
	public void paintComponent(Graphics g){
		object.draw(g);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(currentState == MENU_STATE) {
			updateMenuState();
		}
		else if(currentState == GAME_STATE) {
			updateGameState();
		}
		else if(currentState == END_STATE) {
			updateEndState();
		}
		repaint();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("typed");
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(currentState > END_STATE) {
				currentState = MENU_STATE;
			}
			else {
				currentState++;
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("released");
	}
}
