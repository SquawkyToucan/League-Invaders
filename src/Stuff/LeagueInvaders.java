package Stuff;

import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	GamePanel gamePanel;
	static final int width = 500;
	static final int height = 800;
	LeagueInvaders() {
		frame = new JFrame();
		frame.setSize(width, height);
		gamePanel = new GamePanel();
	}
	public static void main(String[] args) {
		LeagueInvaders li = new LeagueInvaders();
		li.setup();
	}
	void setup() {
		frame.add(gamePanel);
		gamePanel.startGame();
		frame.setVisible(true);
		frame.addKeyListener(gamePanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
