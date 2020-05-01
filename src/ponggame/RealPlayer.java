package ponggame;

public class RealPlayer {
	double xPos;
	double yPos;
	int score;
	double height;
	double maxY;
	double minY;
	final double topYCoord = 400;
	final double bottomYCoord = 0;
	public RealPlayer() {
		this.xPos = 50;
		this.yPos = 200;
		this.score=0;
		this.height = 10;
		this.maxY= topYCoord-height/2;
		this.minY = bottomYCoord+ height/2;
	}
	public double getScore() {
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

}
