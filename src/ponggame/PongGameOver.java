package ponggame;

import java.awt.Font;
import java.awt.event.KeyEvent;

import SpaceInvaders.GameBoard;
import edu.princeton.cs.introcs.StdDraw;
import game.GameMenuInteractions;
import game_abstractions.GameManager;
import game_abstractions.GameScene;

public class PongGameOver extends GameScene {
	int frame;
	GameMenuInteractions interactionLevel;
	boolean playerWins;

	
	public PongGameOver(GameManager manager, GameScene parent, boolean playerWins) {
		super(manager, parent);
		this.frame = 0;
		this.interactionLevel = GameMenuInteractions.wait;
		this.playerWins = playerWins;
	}
	public void drawGameOverScreen() {
		StdDraw.clear();
		System.out.println("Going to draw end of game input screen");
		if (playerWins) {
			System.out.println("Player wins");
			Font font = new Font("Sans Serif", Font.PLAIN, 24);
			StdDraw.setPenColor(3, 252, 227);
			StdDraw.setFont(font);
			StdDraw.text(200, 300, "You won!!");
		}
		if (!playerWins) {
			System.out.println("Player does not win");
			Font font = new Font("Sans Serif", Font.PLAIN, 24);
			StdDraw.setPenColor(252, 169, 3);
			StdDraw.setFont(font);
			StdDraw.text(200, 300, "You lost...");
		}
		StdDraw.setPenColor();
		StdDraw.setFont();
		StdDraw.text(200, 100, "Press 1 to play again");
		StdDraw.text(200, 80, "Press 2 to return to minigame menu");
		StdDraw.show();
	}

	public void gameOverInputTaker() {
		System.out.println("In end-of-game input function");
		int keyPress = 0;
		boolean goodInput = false;
		while (!goodInput && keyPress != 1) {
			if (StdDraw.isKeyPressed(KeyEvent.VK_2)) {
				keyPress = 1;
				this.getGameManager().setScene(this.parent.getParent());
			} else if (StdDraw.isKeyPressed(KeyEvent.VK_1)) {
				keyPress = 1;
				GameScene newPong = new PongGame(this.getGameManager(), this.parent.getParent());
				this.getGameManager().setScene(newPong);
			}
		}
	}
	public void update() {
		this.drawGameOverScreen();
		this.gameOverInputTaker();
		
		
	}
	

}
