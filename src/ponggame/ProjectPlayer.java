package ponggame;

public class ProjectPlayer implements Player{
	
	double xPos;
	double yPos; 
	double yDir;
	int score;
	double maxY;
	double minY;
	double height;
	double width;
	final double topYCoord = 400;
	final double bottomYCoord = 30;
	final double xWidth = 400;
	double doublexPrediction;
	double doubleyPrediction;
	double error;
	double reactionSpeed;
	int predictionCount = 0;
	public ProjectPlayer() {
		xPos = 350;
		yPos = 200;
		this.doublexPrediction=0;
		this.doubleyPrediction=0;
		this.score = 0;
		this.height = 20;
		this.width = 2;
		this.maxY= topYCoord-height/2;
		this.minY = bottomYCoord+ height/2;
		this.error=0;
		this.reactionSpeed = 25;
		this.yDir = 0;
		
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
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public double makePrediction(Ball ball, RealPlayer player) {
		double copyX = ball.getxPos();
		double copyY = ball.getyPos();
		double copySpeed = ball.getSpeed();
		double distance = Math.abs((copyX-this.xPos));
		double predictionY = 0;
	while (copyX < this.getxPos()) {
		copyX = copyX + copySpeed;
		copyY = copyY + copySpeed;
		}
		predictionY = copyY;
		double[] errmatrix = determineErr(player);
		double err = errmatrix[1];
		this.doubleyPrediction=  predictionY + ((err* Math.random())* this.yDir);
		return this.doubleyPrediction;
		
		
		
	}
	public double[] determineErr(RealPlayer player) {
		int difference = player.getScore()-this.getScore();
		switch(difference) {
		case 8:
			this.error = 30;
			this.reactionSpeed=75;
			break;
		case 7:
			this.error = 40;
			this.reactionSpeed=65;
			break;
		case 6:
			this.error = 50;
			this.reactionSpeed=60;
			break;
		case 5:
			this.error = 60;
			this.reactionSpeed=55;
			break;
		case 4:
			this.error = 70;
			this.reactionSpeed=50;
			break;
		case 3:
			this.error = 80;
			this.reactionSpeed=45;
			break;
		case 2:
			this.error = 90;
			this.reactionSpeed=35;
			break;
		case 1:
			this.error = 100;
			this.reactionSpeed=30;
			break;
		case 0:
			this.error = 110;
			this.reactionSpeed=25;
			break;
		case -1:
			this.error = 120;
			this.reactionSpeed=25;
			break;
		case -2:
			this.error=130;
			this.reactionSpeed=25;
			break;
		case -3:
			this.error = 140;
			this.reactionSpeed=25;
			break;
		case -4:
			this.error= 150;
			this.reactionSpeed = 25;
			break;
		case -5:
			this.error = 160;
			this.reactionSpeed=25;
			break;
		case -6:
			this.error=170;
			this.reactionSpeed = 25;
			break;
		case -7:
			this.error=180;
			this.reactionSpeed=25;
			break;
		case -8:
			this.error=190;
			this.reactionSpeed=25;
			break;
		}
		double[]AInoise= {this.error, this.reactionSpeed};
		return AInoise;		
		
	}
	public void redoPrediction(Ball ball, RealPlayer player) {
		//make prediction if ball is moving towards ai side of court
	

		if (ball.getxDir() == 1 && ball.getxPos() < this.xPos && ball.getxPos() > 50) {
			System.out.println("About to make prediction");
		if (predictionCount == 0) {
			this.makePrediction(ball, player);
		
		}
	}
		if (this.doubleyPrediction < (this.maxY) && this.doubleyPrediction > (this.yPos)) {
			this.moveUp();
		}
		if (this.doubleyPrediction > this.minY && this.doubleyPrediction < (this.yPos)) {
			this.moveDown();
		}
		
	}
	
	public void moveUp() {
		this.yDir = 1;
		this.yPos = this.yPos + (this.yDir*this.reactionSpeed);
		
	}
	public void moveDown() {
		this.yDir = -1;
		this.yPos= this.yPos + (this.yDir* this.reactionSpeed);
		
	}
	public void checkScoreUpdate(Collisions collision) {
		if (collision == Collisions.LEFT_WALL) {
			System.out.println("Update project player score" + this.score);
			this.updateScore();
		}
	}
	public void update(Ball ball, RealPlayer player, Collisions collision) {
		this.redoPrediction(ball, player);
		this.checkScoreUpdate(collision);
		
	}
	public double getWidth() {
		return this.width;
	}
	public double getHeight() {
		return this.height;
	}
	@Override
	public void updateScore() {
		this.score+=1;
		
	}


}
