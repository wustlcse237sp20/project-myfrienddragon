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
	double maxXLimit;
	
	public Ball() {
		//initialize initial ball coordinates at center of screen, but at random y pos and direction
		//initialize random speed
		//initialize radius in pixels
	}
	//note: collision functions only move ball and return collision enum, do not check conditions of
	//collision...that is done in checkCollision

	public Collisions reboundBallOffMinY() {
		//update ball pos/speed
		//return collision enum based on collision with bottom wall
		//
		
	}
	public Collisions reboundBallOffMaxY() {
		//update ball pos/speed
		//return collision enum based on collision with top wall
		
	}
	public Collisions reboundBallOffMinX() {
		//update ball pos/speed
		//return collision enum based on collision with left wall
		
	}
	public Collisions reboundBallOffMaxX() {
		//update ball pos/speed
		//return collision enum based on collision with right wall
		
	}
	public Collisions PaddleCollision(RealPlayer player, ProjectPlayer ai) {
		//update ball pos/speed
		//return collision enum based on collision with right wall
		
	}
	
	public Collisions checkCollisions() {
		//aggregate checker function that checks collision conditions and calls rebound functions accordingly
		
	}
	//updates x and y pos
	public void updatePos(double newXPos, double newYPos) {
		this.xPos += 
		
	}
	public void updateDir(double newXDir, double newYDir) {
		
	}
	
	//accelerates and decelerates ball to give challenge based on collision
	public void changeSpeed(Collisions collision) {
		
	}
	//calls 
	public void move() {
		
	}
	public void update() {
		Collision collision = this.checkCollisions();
		this.changeSpeed(collision);
		this.move();
		
	}
	
	

}
