package SpaceInvaders;

import edu.princeton.cs.introcs.StdDraw;

public class SpaceInvaderBullet implements Sprite {
	final double bulletHalfWidth = 38.5;
	final double bulletHalfHeight = 33;
	double xPos;
	double yPos;
	
	public SpaceInvaderBullet(double xPos, double yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		StdDraw.picture(xPos, yPos, "src/space_invaders_resources/invader_shot.png");
	}
	
	public void move() {
		this.yPos+=25;
		this.updateHitBoxPos();
		
	}


	@Override
	public void destroy() {
		
	}
	

	@Override
	public void hurt() {
		
	}

	@Override
	public boolean checkCollision() {
		return false;
	}

	@Override
	public double getX() {
		return this.xPos;
	}

	@Override
	public double getY() {
		return this.yPos;
	}

	@Override
	public void updateHitBoxPos() {
		// TODO Auto-generated method stub
		
	}

}
