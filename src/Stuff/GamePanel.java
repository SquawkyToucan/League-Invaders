package Stuff;

import java.awt.Color;
import java.awt.Font;
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
	Rocketship rs = new Rocketship(250, 700, 50, 50, 12);
	Timer timer = new Timer(1000/60, this);
	Font titleFont;
	Font start;
	Font instruc;
	Font ufailed;
	ObjectManager om = new ObjectManager();
	GamePanel() {
		titleFont = new Font("dragon_alphabet", Font.PLAIN, 36);
		start = new Font("dragon_alphabet", Font.PLAIN, 24);
		instruc = new Font("dragon_alphabet", Font.PLAIN, 18);
	}
	public void updateMenuState() {
		
	}
	public void updateGameState() {
		om.update();
		om.checkCollision();
		om.manageEnemies();
		rs.update();
	}
	public void updateEndState() {
		
	}
	public void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 500, 800);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("League Invaders", 20, 200);
		g.setFont(start);
		g.drawString("Press Enter to Start", 50, 400);
		g.setFont(instruc);
		g.drawString("Press space for instructions", 40, 500);
	}
	public void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 800);
		om.draw(g);
		rs.draw(g);
	}
	public void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, 500, 800);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("Game Over!", 50, 200);
		g.setFont(start);
		g.drawString("You killed 0 aliens.", 50, 400);
		g.setFont(instruc);
		g.drawString("Press backspace to go back", 40, 500);
	}
	public void startGame() {
		timer.start();
	}
	public void paintComponent(Graphics g){
		if(currentState == MENU_STATE) {
			drawMenuState(g);
		}
		else if(currentState == GAME_STATE) {
			drawGameState(g);
			om.draw(g);
		}
		else if(currentState == END_STATE) {
			drawEndState(g);
		}
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

	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(currentState == END_STATE) {
				currentState = MENU_STATE;
			}
			else {
				currentState++;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			rs.down();
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			rs.up();
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			rs.left();
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rs.right();
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			om.addObject(new Projectile(rs.x + 20, rs.y + 20, 10, 10));
			System.out.println("Space key actaully works.");
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}
