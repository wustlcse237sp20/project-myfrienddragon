package ponggame;

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class PongGame {
	RealPlayer player;
	ProjectPlayer AIplayer;
	Ball ball;
	
public void setUpGameScreen() {
	StdDraw.setCanvasSize(400, 400);
	StdDraw.setXscale(0,400);
	StdDraw.setYscale(0,400);
	StdDraw.enableDoubleBuffering();
}
public void drawPlayerPaddle() {
	StdDraw.filledRectangle(player.getxPos(), player.getyPos(), player.getWidth(), player.getHeight());
	
}
public void drawAIPaddle() {
	StdDraw.filledRectangle(AIplayer.getxPos(), AIplayer.getyPos(), AIplayer.getWidth(), AIplayer.getHeight());
	
}
public void drawBall() {
	StdDraw.filledCircle(ball.getxPos(), ball.getyPos(), ball.radius);
}

public void update() {
	this.takeMovement();
	ball.update(player, AIplayer);
	AIplayer.update(ball, player);
}

public void drawGame() {
	StdDraw.clear();
	this.drawPlayerPaddle();
	this.drawBall();
	this.drawAIPaddle();
	StdDraw.show();
	StdDraw.pause(66);
	
}
public void takeMovement() {
	if (StdDraw.isKeyPressed(KeyEvent.VK_W) || StdDraw.isKeyPressed(KeyEvent.VK_S)) {
		if (StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			player.moveUp();	
		}
		if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			player.moveDown();
		}
	}
	
	
}
public void playGame() {
	player = new RealPlayer();
	AIplayer = new ProjectPlayer();
	ball = new Ball();
	while (true) {
		this.update();
		this.drawGame();	
	}

}
public static void main (String[]args) {
	PongGame game = new PongGame();
	game.setUpGameScreen();
	game.playGame();
	
}

}
