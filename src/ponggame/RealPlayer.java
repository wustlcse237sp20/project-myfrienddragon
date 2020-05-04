package ponggame;

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class RealPlayer implements Player {
	double xPos;
	double yPos;
	int score;
	double height;
	double maxY;
	double minY;
	final double topYCoord = 400;
	final double bottomYCoord = 50;
	double width;
	int playerNumber;
	int upKeyCode;
	int downKeyCode;
	public RealPlayer(double xPos, double yPos, int playerNumber) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.playerNumber = playerNumber;
		this.score= 0;
		this.height = 20;
		this.width = 10;
		this.upKeyCode=0;
		this.downKeyCode=0;
		this.setKeyCodes();
		this.maxY= topYCoord-height/2;
		this.minY = bottomYCoord+ height/2;
	}
	public double getWidth() {
		return this.width;
	}
	public double getHeight() {
		return this.height;
	}
	public int getScore() {
		return score;
	}
	public void updateScore() {
		this.score +=1;
	}
	public double getxPos() {
		return xPos;
	}

	public void setxPos(double xPos) {
		this.xPos = xPos;
	}

	public double getyPos() {
		return yPos;
	}

	public void setyPos(double yPos) {
		this.yPos = yPos;
	}
	
	public void setKeyCodes() {
		if (this.playerNumber==1) {
			this.upKeyCode = KeyEvent.VK_W;
			this.downKeyCode = KeyEvent.VK_S;
		}
		else {
			this.upKeyCode=KeyEvent.VK_P;
			this.downKeyCode=KeyEvent.VK_L;
		}
		
	}
	
	public void takeMovement() {
		if (StdDraw.isKeyPressed(this.upKeyCode) || StdDraw.isKeyPressed(this.downKeyCode)) {
			if (StdDraw.isKeyPressed(this.upKeyCode)) {
				this.moveUp();	
			}
			if (StdDraw.isKeyPressed(this.downKeyCode)) {
				this.moveDown();
			}
		}
	}
		
	
	public void checkScoreUpdate(Collisions collision) {
		if (this.playerNumber==1) {
			if (collision == Collisions.RIGHT_WALL) {
			this.updateScore();
		}
	}
		else if (this.playerNumber == 2){
			if (collision == Collisions.LEFT_WALL) {
				this.updateScore();
			}
		}
	}
		
	
	public void moveUp() {
		if (this.yPos < this.maxY) {
		this.yPos+=10;
		}
	}
	public void moveDown() {
		if (this.yPos > this.minY) {
		this.yPos=this.yPos-10;
		}
	}
	
	public void update(Collisions collision) {
		this.takeMovement();
		this.checkScoreUpdate(collision);
		
	}

}
