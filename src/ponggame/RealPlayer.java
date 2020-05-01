package ponggame;

public class RealPlayer {
	double xPos;
	double yPos;
	double score;
	public RealPlayer() {
		this.xPos = 50;
		this.yPos = 200;
		this.score=0;
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
		this.yPos+=10;
	}
	public void moveDown() {
		this.yPos=this.yPos-10;
	}

}
