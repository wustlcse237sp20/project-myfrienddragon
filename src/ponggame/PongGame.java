package ponggame;

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class PongGame {
	RealPlayer player;
	//ProjectPlayer AIplayer;
	
public void setUpGameScreen() {
	StdDraw.setCanvasSize(400, 400);
	StdDraw.setXscale(0,400);
	StdDraw.setYscale(0,400);
	StdDraw.enableDoubleBuffering();
}
public void drawPaddle() {
	StdDraw.filledRectangle(player.getxPos(), player.getyPos(), 10, 20);
	
}

public void update() {
	this.takeMovement();
}

public void drawGame() {
	StdDraw.clear();
	this.drawPaddle();
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
