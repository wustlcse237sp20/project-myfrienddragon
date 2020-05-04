package ponggame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;
import game.Game;
import game_abstractions.GameManager;
import game_abstractions.GameScene;

public class PongGame extends GameScene {
	RealPlayer playerOne;
	Player playerTwo;
	Ball ball;
	boolean gameInProgress;
	boolean playerWins;
	int foodEarned;
	
	public PongGame(GameManager manager, GameScene parent) {
		super(manager, parent);
		this.setUpOneorTwoPlayer();
		this.playerOne = new RealPlayer(50, 200, 1);
		this.ball = new Ball();
		this.playerWins = false;
		this.gameInProgress = true;
		this.foodEarned = 0;
	}

	public void drawSetupMessage() {
		StdDraw.clear();
		StdDraw.text(200, 200, "Press 1 for single-player pong");
		StdDraw.text(200, 180, "Press 2 for classic two-player pong");
		StdDraw.show();
	}

	public void setUpOneorTwoPlayer() {
		boolean goodInput = false;
		int keyInput = 0;
		while (!goodInput && keyInput != 1) {
			this.drawSetupMessage();
			if (StdDraw.isKeyPressed(KeyEvent.VK_2)) {
				keyInput += 1;
				playerTwo = new RealPlayer(350, 200, 2);
				goodInput = true;
			} else if (StdDraw.isKeyPressed(KeyEvent.VK_1)) {
				keyInput += 1;
				playerTwo = new ProjectPlayer();
				goodInput = true;
			}
		}
	}
	public void drawPlayerPaddle() {
		StdDraw.filledRectangle(playerOne.getxPos(), playerOne.getyPos(), playerOne.getWidth(), playerOne.getHeight());

	}

	public void drawAIPaddle() {
		StdDraw.filledRectangle(playerTwo.getxPos(), playerTwo.getyPos(), playerTwo.getWidth(), playerTwo.getHeight());

	}

	public void drawBall() {
		StdDraw.filledCircle(ball.getxPos(), ball.getyPos(), ball.radius);
	}

	public void drawScoreBoard() {
		StdDraw.rectangle(50, 15, 50, 15);
		StdDraw.rectangle(350, 15, 50, 15);
		StdDraw.text(50, 15, "Score: " + playerOne.getScore());
		StdDraw.text(350, 15, "Score: " + playerTwo.getScore());
	}

	public void gameUpdate() {
		Collisions collision = ball.update(playerOne, playerTwo);
		playerOne.update(collision);
		if (playerTwo instanceof ProjectPlayer) {
			((ProjectPlayer) playerTwo).update(ball, playerOne, collision);
		} else {
			((RealPlayer) playerTwo).update(collision);
		}
	}

	public void checkGameOver() {
		if (playerOne.getScore() == 8) {
			playerWins = true;
			gameInProgress = false;
		} else if (playerTwo.getScore() == 8) {
			playerWins = false;
			gameInProgress = false;
		}
	}

	public void checkFoodEarned() {
		if (playerWins) {
			foodEarned += 2;
		} else {
			foodEarned += 1;
		}
		Game.dragon.updateFoodStore(foodEarned);

	}




	public void drawGame() {
		StdDraw.clear();
		this.drawPlayerPaddle();
		this.drawBall();
		this.drawAIPaddle();
		this.drawScoreBoard();
	}
	

	public void update() {
		if (this.gameInProgress) {
				this.gameUpdate();
				this.drawGame();
				this.checkGameOver();
			}
		else {
			this.checkFoodEarned();
			GameScene pongGameOver = new PongGameOver(this.getGameManager(), this, this.playerWins);
			this.getGameManager().setScene(pongGameOver);
		}
			
	}
}

