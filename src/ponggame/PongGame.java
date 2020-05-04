package ponggame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class PongGame {
	
	RealPlayer playerOne;
	Player playerTwo;
	Ball ball;
	boolean gameInProgress;
	boolean playerWins;
	int foodEarned;
	boolean returnToMenu;

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
				keyInput+=1;
				playerTwo = new RealPlayer(350,200,2);
				goodInput = true;
			}
			else if (StdDraw.isKeyPressed(KeyEvent.VK_1)) {
				keyInput+=1;
				playerTwo = new ProjectPlayer();
				goodInput = true;
			}
		}
	}

	public void setUpGameScreen() {
		StdDraw.setCanvasSize(400, 400);
		StdDraw.setXscale(0,400);
		StdDraw.setYscale(0,400);
		StdDraw.enableDoubleBuffering();
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

	public void update() {
		Collisions collision = ball.update(playerOne, playerTwo);
		playerOne.update(collision);
		if (playerTwo instanceof ProjectPlayer) {
			((ProjectPlayer) playerTwo).update(ball, playerOne, collision);
		}
		else {
			((RealPlayer) playerTwo).update(collision);
		}
	}
	
	public void checkGameOver() {
		if (playerOne.getScore()==8) {
			playerWins = true;
			gameInProgress=false;
		}
		else if (playerTwo.getScore()==8) {
			playerWins = false;
			gameInProgress=false;
		}
	}
	
	public void checkFoodEarned() {
		if (playerWins) {
			foodEarned += 2;
		}
		else {
			foodEarned += 1;
		}
	}
	
	public void drawGameOverScreen() {
		StdDraw.clear();
		System.out.println("Going to draw end of game input screen");
		if (playerWins) {
			System.out.println("Player wins");
			Font font = new Font("Sans Serif", Font.PLAIN, 24);
			StdDraw.setPenColor(3, 252, 227);
			StdDraw.setFont(font);
			StdDraw.text(200, 300,"You won!!");
		}
		if (!playerWins) {
			System.out.println("Player does not win");
			Font font = new Font("Sans Serif", Font.PLAIN, 24);
			StdDraw.setPenColor(252, 169, 3);
			StdDraw.setFont(font);
			StdDraw.text(200, 300,"You lost...");
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
			this.drawGameOverScreen();
			if (StdDraw.isKeyPressed(KeyEvent.VK_2)) {
				keyPress=1;
				this.checkFoodEarned();
				returnToMenu = true;
			}
			else if (StdDraw.isKeyPressed(KeyEvent.VK_1)) {
				keyPress=1;
				this.checkFoodEarned();
				returnToMenu = false;
			}
		}
	}

	public void drawGame() {
		StdDraw.clear();
		this.drawPlayerPaddle();
		this.drawBall();
		this.drawAIPaddle();
		this.drawScoreBoard();
		StdDraw.show();
		StdDraw.pause(33);
	}

	public void playGame() {
		playerOne = new RealPlayer(50,200,1);
		ball = new Ball();
		playerWins= false;
		gameInProgress=true;
		returnToMenu = false;
		while (gameInProgress) {
			this.update();
			this.checkGameOver();
			this.drawGame();	
		}
		this.gameOverInputTaker();
	}

	public int resetGame() {
		PongGame game = new PongGame();
		game.setUpGameScreen();
		game.setUpOneorTwoPlayer();
		game.playGame();
		if (returnToMenu) {
			return foodEarned;
		}
		else {
			this.resetGame();
		}
		return foodEarned;
	}

}

