package ponggame;

public class Ball {
	
	double xPos;
	double yPos;
	double xDir;
	double yDir;
	double radius;
	double speed;
	//min or max x or y (screen boundaries)
	double minYLimit;
	double minXLimit;
	double maxYLimit;
	double maxXLimit;
	double angle;
	final double screenWidth = 395;
	final double screenHeight= 395;
	boolean changedDir;
	
	public Ball() {
		this.xPos = 200;
		this.yPos = 350*Math.random();
		this.speed = (6)*Math.random()+5;
		this.radius = 5;
		this.angle = 0;
		this.minYLimit=this.screenHeight*(1/5)+speed;
		this.minXLimit=radius+speed;
		this.xDir=1;
		this.yDir=1;
		this.maxXLimit= screenWidth-radius-speed;
		this.maxYLimit=screenHeight-radius-speed;
	}
	
	Ball(Ball ballA) {
		this.xPos = ballA.getxPos();
		this.yPos = ballA.getyPos();
		this.speed = ballA.getSpeed()*2;
		this.xDir = ballA.getxDir();
		this.yDir = ballA.getyDir();
		this.radius = 5;
		this.minYLimit= ballA.minYLimit;
		this.minXLimit=ballA.minXLimit;
		this.maxXLimit= ballA.maxXLimit;
		this.maxYLimit= ballA.maxYLimit;
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

	public double getxDir() {
		return xDir;
	}

	public void setxDir(double xDir) {
		this.xDir = xDir;
	}

	public double getyDir() {
		return yDir;
	}

	public void setyDir(double yDir) {
		this.yDir = yDir;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getMinYLimit() {
		return minYLimit;
	}

	public void setMinYLimit(double minYLimit) {
		this.minYLimit = minYLimit;
	}

	public double getMinXLimit() {
		return minXLimit;
	}

	public void setMinXLimit(double minXLimit) {
		this.minXLimit = minXLimit;
	}

	public double getMaxYLimit() {
		return maxYLimit;
	}

	public void setMaxYLimit(double maxYLimit) {
		this.maxYLimit = maxYLimit;
	}

	public double getMaxXLimit() {
		return maxXLimit;
	}

	public void setMaxXLimit(double maxXLimit) {
		this.maxXLimit = maxXLimit;
	}

	public Collisions reboundBallOffMinY() {
		this.yPos = this.minYLimit+radius;
		this.yDir=-1*this.yDir;
		return Collisions.BOTTOM_WALL;
	}

	public Collisions reboundBallOffMaxY() {
		this.yPos = this.maxYLimit-radius;
		this.yDir=-1*this.yDir;
		return Collisions.TOP_WALL;
	}
	
	public Collisions reboundBallOffMinX() {
		this.xPos = this.minXLimit+radius;
		this.xDir=-1*this.xDir;
		this.yDir=-1*this.yDir;
		changedDir = true;
		return Collisions.LEFT_WALL;	
		//update ball pos/speed
		//return collision enum based on collision with left wall	
	}
	
	public Collisions reboundBallOffMaxX() {
		this.xPos = this.maxXLimit - radius;
		this.xDir=-1*this.xDir;
		this.yDir=-1*this.yDir;
		changedDir = true;
		return Collisions.RIGHT_WALL;
		//update ball pos/speed
		//return collision enum based on collision with right wall
	}
	
	public Collisions PlayerOnePaddleCollision(RealPlayer player) {
		double playerPaddleBottomY = player.getyPos() - player.getHeight();
		double playerPaddleTopY = player.getyPos() + player.getHeight();
		double playerOneBallXPrediction = this.xPos-radius-speed;
		double playerOneBallYPrediction = (this.yPos)+((speed + radius)*this.yDir);
		if ((playerOneBallXPrediction < player.getxPos() + player.getWidth()) && this.getxDir()==-1) {
			if ((playerOneBallYPrediction <= playerPaddleTopY) && (playerOneBallYPrediction >= playerPaddleBottomY)) {
				//			if ((this.yPos-radius > playerPaddleBottomY) && this.yPos-radius < playerPaddleBottomY*0.33 ) {
				//				this.xDir=-1*this.xDir;
				//				this.yDir = -1*this.yDir;
				//				System.out.println("Bottom third player paddle");
				//			}
				//			if ((this.yPos - radius >= playerPaddleBottomY*0.33) && (this.yPos-radius < playerPaddleTopY * 0.66)) {
				//				this.xDir = -1*this.xDir;
				//				System.out.println("Middle third player paddle");
				//			}
				//			if ((this.yPos-radius >= playerPaddleTopY*0.66) && (this.yPos-radius < playerPaddleTopY)) {
				//				this.yDir = -1*this.xDir;
				//				this.xDir = -1*this.xDir;
				//				System.out.println("Top third player paddle");
				//			}
				this.xDir=this.xDir*-1;
				return Collisions.PLAYER_ONE_PADDLE;
			}
		}
		return Collisions.NONE;
	}
	
	public Collisions PlayerTwoPaddleCollision(Player playerTwo) {
		double playerPaddleBottomY = playerTwo.getyPos() - playerTwo.getHeight();
		double playerPaddleTopY = playerTwo.getyPos() + playerTwo.getHeight();
		double playerTwoBallXPrediction = this.xPos+radius+speed;
		double playerTwoBallYPrediction = (this.yPos)+((speed + radius)*this.yDir);
		if ((playerTwoBallXPrediction > (playerTwo.getxPos() - playerTwo.getWidth())) && this.xDir==1) {
			if ((playerTwoBallYPrediction <= playerPaddleTopY) && (playerTwoBallYPrediction >= playerPaddleBottomY)) {
				//			if ((ballPosWithPadding > playerPaddleBottomY) && ballPosWithPadding < playerPaddleBottomY*0.33 ) {
				//				this.xDir=-1*this.xDir;
				//				this.yDir = -1*this.yDir;
				//			}
				//			if ((this.yPos - radius >= playerPaddleBottomY*0.33) && (this.yPos-radius < playerPaddleTopY * 0.66)) {
				//				this.xDir = -1*this.xDir;
				//			}
				//			if ((this.yPos-radius >= playerPaddleTopY*0.66) && (this.yPos-radius < playerPaddleTopY)) {
				//				this.yDir = -1*this.xDir;
				//				this.xDir = -1*this.xDir;
				//			}
				this.xDir = -1*xDir;
				//ai.predictionCount=1;
				return Collisions.PLAYER_TWO_PADDLE;
			}
		}
		return Collisions.NONE;
		//update ball pos/speed
		//return collision enum based on collision with right wall
	}

	public Collisions checkCollisions(RealPlayer playerOne, Player playerTwo) {
		Collisions collision = this.PlayerOnePaddleCollision(playerOne);
		collision = this.PlayerTwoPaddleCollision(playerTwo);
		//aggregate checker function that checks collision conditions and calls rebound functions accordingly
		if (collision == Collisions.NONE) {
			if (this.yPos <= this.minYLimit) {
				collision = this.reboundBallOffMinY();
			}
			else if (this.yPos >= this.maxYLimit) {
				collision = this.reboundBallOffMaxY();
			}
			else if (this.xPos < this.minXLimit || (this.yPos < this.minYLimit && this.xPos < this.minXLimit)) {
				collision = this.reboundBallOffMinX();
			}
			else if(this.xPos > this.maxXLimit|| (this.yPos > this.maxYLimit && this.xPos > this.maxXLimit)) {
				collision = this.reboundBallOffMaxX();
			}
			else {
				collision = Collisions.NONE;
			}

		}
		return collision;
	}

	//calls 
	public void move() {
		this.xPos = (this.xPos)+(this.speed*this.xDir);
		this.yPos = (this.yPos)+(this.speed*this.yDir);
	}

	public Collisions update(RealPlayer playerOne, Player playerTwo) {
		this.move();
		Collisions collision = this.checkCollisions(playerOne, playerTwo);
		return collision;
	}

}
