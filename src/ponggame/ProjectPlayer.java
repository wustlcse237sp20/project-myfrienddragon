package ponggame;


public class ProjectPlayer implements Player {
	
	double xPos;
	double yPos; 
	double yDir;
	int score;
	double maxY;
	double minY;
	double height;
	double width;
	final double topYCoord = 395;
	final double bottomYCoord = 30;
	final double xWidth = 395;
	double doublexPrediction;
	double doubleyPrediction;
	double error;
	double reactionSpeed;
	int predictionCount = 0;
	Ball predictionBall;
	public ProjectPlayer() {
		xPos = 350;
		yPos = 200;
		this.predictionBall = new Ball();
		this.doublexPrediction=0;
		this.doubleyPrediction=0;
		this.score = 0;
		this.height = 20;
		this.width = 10;
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
		
//		double distanceX = Math.abs(this.xPos - ball.getxPos());
//		double time = distanceX/ball.getSpeed();
//		double predictionY = ball.getyPos()+time*ball.getSpeed();
//		if(predictionY>=this.maxY) {
//			150=(15)(x)+65
//		   double bounceX = (this.maxY/ball.getSpeed())
//			
//		}
//		double intermediatePrediction=0;
//		double print1 = (this.xPos) - (distanceX);
//		int timeReflected = (int) Math.floor(print1/this.maxY);
//		if (timeReflected % 2 == 0) {
//			intermediatePrediction= print1 % this.maxY;
//			if (intermediatePrediction < 0) {
//				predictionY= intermediatePrediction+this.maxY;
//			}
//		}
//		else {
//			intermediatePrediction = this.maxY-(print1 % this.maxY);
//		}
	
		this.predictionBall = new Ball(ball);
		
		while (predictionBall.getxPos() + predictionBall.getRadius() + predictionBall.getSpeed() < this.xPos) {
			System.out.println("Updating prediction ball");
			predictionBall.update(player, this);
			System.out.println("Prediction ball update: " + predictionBall.getxPos() + " " + predictionBall.yPos);
			
		}
		double predictionY = predictionBall.getyPos();
		double err = determineErr(player);
		double chooseErr=  ((Math.random()*(err-(-1*err)+1)+err));
		this.doubleyPrediction=  predictionY + chooseErr;
		if(this.doubleyPrediction > this.maxY) {
			this.doubleyPrediction=this.maxY;
		}
		return this.doubleyPrediction;	
		
	}
	public double determineErr(RealPlayer player) {
		int difference = player.getScore()-this.getScore();
		switch(difference) {
		case 8:
			this.error = 5;
			this.reactionSpeed=30;
			break;
		case 7:
			this.error = 7;
			this.reactionSpeed=30;
			break;
		case 6:
			this.error = 9;
			this.reactionSpeed=25;
			break;
		case 5:
			this.error = 11;
			this.reactionSpeed=25;
			break;
		case 4:
			this.error = 12;
			this.reactionSpeed=20;
			break;
		case 3:
			this.error = 14;
			this.reactionSpeed=20;
			break;
		case 2:
			this.error = 16;
			this.reactionSpeed=15;
			break;
		case 1:
			this.error = 18;
			this.reactionSpeed=15;
			break;
		case 0:
			this.error = 20;
			this.reactionSpeed=15;
			break;
		case -1:
			this.error = 20;
			this.reactionSpeed=15;
			break;
		case -2:
			this.error=20;
			this.reactionSpeed=10;
			break;
		case -3:
			this.error = 20;
			this.reactionSpeed=10;
			break;
		case -4:
			this.error= 20;
			this.reactionSpeed = 10;
			break;
		case -5:
			this.error = 20;
			this.reactionSpeed=10;
			break;
		case -6:
			this.error=20;
			this.reactionSpeed = 5;
			break;
		case -7:
			this.error=20;
			this.reactionSpeed=5;
			break;
		case -8:
			this.error=20;
			this.reactionSpeed=5;
			break;
		}
		double AInoise = this.error;
		return AInoise;		
		
	}
	public void redoPrediction(Ball ball, RealPlayer player) {
		//make prediction if ball is moving towards ai side of court
		//}
		if (ball.getxDir()==-1) {
			predictionCount = 0;
		}
		if (ball.getxDir()== 1 && predictionCount == 0) {
	     	this.makePrediction(ball, player);
	     	predictionCount = 1;
		}
		if (this.doubleyPrediction < (this.maxY) && this.doubleyPrediction > (this.yPos)) {
			this.yDir = 1;
			this.moveTo();
		}
		if (this.doubleyPrediction > this.minY && this.doubleyPrediction < (this.yPos)) {
			this.yDir = -1;
			this.moveTo();
		}
		
	}
	
	public void moveTo() {
		if (this.yPos != this.doubleyPrediction) {
		this.yPos = this.yPos + (this.yDir*this.reactionSpeed);
		}
		
	}

	public void checkScoreUpdate(Collisions collision) {
		if (collision == Collisions.LEFT_WALL) {
			this.updateScore();
			System.out.println("Update project player score" + this.score);
		}
	}
	public void update(Ball ball, RealPlayer player, Collisions collision) {
		this.redoPrediction(ball, player);
		this.checkScoreUpdate(collision);
	}
	public double getWidth() {
		// TODO Auto-generated method stub
		return this.width;
	}
	public double getHeight() {
		return this.height;
	}

	@Override
	public void updateScore() {
		this.score+=1;
		
	}
	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		
	}


}
