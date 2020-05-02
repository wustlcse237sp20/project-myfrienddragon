package ponggame;
//some ideas on ball class--feel free to alter if you want


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
	final double screenWidth = 395;
	final double screenHeight= 395;
	boolean changedDir;
	public Ball() {
		this.xPos = 200;
		this.yPos = 350*Math.random();
		this.speed = 10;
		this.radius = 5;
		this.minYLimit=radius+speed;
		this.minXLimit=radius+speed;
		this.xDir=1;
		this.yDir=1;
		this.maxXLimit= screenWidth-radius-speed;
		this.maxYLimit=screenHeight-radius-speed;
		changedDir = false;
		//initialize initial ball coordinates at center of screen, but at random y pos and direction
		//initialize random speed
		//initialize radius in pixels
	}
	//note: collision functions only move ball and return collision enum, do not check conditions of
	//collision...that is done in checkCollision

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
			this.yPos = radius;
			this.yDir=-1*this.yDir;
			return Collisions.bottomwall;
			
		}
	
		
	
	public Collisions reboundBallOffMaxY() {
		this.yPos = this.screenHeight-radius;
		this.yDir=-1*this.yDir;
		return Collisions.topwall;
	}
	public Collisions reboundBallOffMinX() {
			this.xPos = radius;
			this.xDir=-1*this.xDir;
			this.yDir=-1*this.yDir;
			changedDir = true;
			return Collisions.leftwall;	
		//update ball pos/speed
		//return collision enum based on collision with left wall	
	}
	public Collisions reboundBallOffMaxX() {
		this.xPos = this.screenWidth - radius;
		this.xDir=-1*this.xDir;
		this.yDir=-1*this.yDir;
		changedDir = true;
		return Collisions.rightwall;
		//update ball pos/speed
		//return collision enum based on collision with right wall
		
	}
	public Collisions PaddleCollision(RealPlayer player, ProjectPlayer ai) {
		double playerPaddleBottomY = player.getyPos() - player.getHeight();
		double playerPaddleTopY = player.getyPos() + player.getHeight();
		double ballxPrediction = this.xPos-radius-speed;
		double ballyPrediction = (this.yPos)+((speed + radius)*this.yDir);
		if ((ballxPrediction <= player.getxPos() + player.getWidth())) {
			if ((ballyPrediction< playerPaddleTopY) && (ballyPrediction > playerPaddleBottomY)) {
//			if ((this.yPos-radius > playerPaddleBottomY) && this.yPos-radius < playerPaddleBottomY*0.33 ) {
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
			return Collisions.playerpaddle;
		}
	}
		return Collisions.none;
		//update ball pos/speed
		//return collision enum based on collision with right wall
		
	}
	
	public Collisions checkCollisions(RealPlayer player, ProjectPlayer ai) {
		Collisions collision = this.PaddleCollision(player, ai);
		//aggregate checker function that checks collision conditions and calls rebound functions accordingly
	if (collision == Collisions.none) {
		if (this.yPos < this.minYLimit) {
			collision = this.reboundBallOffMinY();
		}
		if (this.yPos > this.maxYLimit && this.xPos > this.maxXLimit) {
			this.xDir=-1*this.xDir;
			this.yDir = -1*this.yDir;
			changedDir = true;
		}
		else if (this.yPos > this.maxYLimit) {
			collision = this.reboundBallOffMaxY();
       	}
		else if (this.xPos < this.minXLimit) {
			collision = this.reboundBallOffMinX();
		}
		else if(this.xPos > this.maxXLimit) {
			collision = this.reboundBallOffMaxX();
		}
		else {
			collision = Collisions.none;
		}
	
	}
	return collision;
	
		
	}
	//updates x and y pos
	public void updatePos(double newXPos, double newYPos) {
		
	}
	public void updateDir(double newXDir, double newYDir) {
		
	}
	
	//accelerates and decelerates ball to give challenge based on collision
	public void changeSpeed(Collisions collision) {
		
	}
	//calls 
	public void move() {
		this.xPos = (this.xPos)+(this.speed*this.xDir);
		this.yPos = (this.yPos)+(this.speed*this.yDir);
	
		
		
	}
	public boolean getChangedDir() {
		return this.changedDir;
	}
	public void update(RealPlayer player, ProjectPlayer ai) {
		Collisions collision = this.checkCollisions(player, ai);
		//this.changeSpeed(collision);
		this.move();
		this.changedDir = false;
		
	}
	
	

}
