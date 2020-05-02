package ponggame;

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class PongGame {
	RealPlayer playerOne;
	Player playerTwo;
	Ball ball;
	
public void drawSetupMessage() {
	StdDraw.clear();
	StdDraw.text(200, 200, "Press 1 for single-player pong");
	StdDraw.text(200, 180, "Press 2 for classic two-player pong");
	StdDraw.show();
}
	
public void setUpOneorTwoPlayer() {
	this.drawSetupMessage();
	boolean goodInput = false;
	while (!goodInput) {

		this.drawSetupMessage();

		if (StdDraw.isKeyPressed(KeyEvent.VK_2)) {
			playerTwo = new RealPlayer(350,200, 2);
			goodInput = true;
		}
		else if (StdDraw.isKeyPressed(KeyEvent.VK_1)) {
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

public void drawScore() {
	StdDraw.rectangle(50, 0, 50, 15);
	StdDraw.rectangle(300, 0, 50, 15);
	StdDraw.text(50, 5, "Score: " + playerOne.getScore());
	StdDraw.text(300, 5,"Score: " + playerTwo.getScore());
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
	System.out.println("Player two score:: " +playerTwo.getScore());
}

public void drawGame() {
	StdDraw.clear();
	this.drawPlayerPaddle();
	this.drawBall();
	this.drawAIPaddle();
	this.drawScore();
	StdDraw.show();
	StdDraw.pause(33);
	
}

public void playGame() {
	playerOne = new RealPlayer(50, 200, 1);
	ball = new Ball();
	while (true) {
		this.update();
		this.drawGame();	
	}

}
public static void main (String[]args) {
	PongGame game = new PongGame();
	game.setUpGameScreen();
	game.setUpOneorTwoPlayer();
	game.playGame();
	
}

}
