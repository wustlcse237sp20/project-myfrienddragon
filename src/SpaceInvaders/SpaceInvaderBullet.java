package SpaceInvaders;

import edu.princeton.cs.introcs.StdDraw;

<<<<<<< Updated upstream
public class SpaceInvaderBullet {
=======
public class SpaceInvaderBullet implements Sprite {
	final double bulletWidth = 77;
	final double bulletHeight = 66;
>>>>>>> Stashed changes
	double xPos;
	double yPos;
	HitBoxTile SpaceInvaderHitBox;
	boolean onScreen;
	
	public SpaceInvaderBullet(double xPos, double yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		StdDraw.picture(xPos, yPos, "src/space_invaders_resources/invader_shot.png");
		SpaceInvaderHitBox = new HitBoxTile(xPos, yPos, bulletHeight, bulletWidth);
		this.onScreen=true;
	}
	
<<<<<<< Updated upstream
	public void updateBullet() {
		
=======
	public void move() {
		this.yPos-=25;
		StdDraw.picture(this.xPos, this.yPos, "src/space_invaders_resources/invader_shot.png");
		this.updateHitBoxPos();	
	}


	@Override
	public void destroy() {
		this.onScreen = false;
		
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
		SpaceInvaderHitBox = new HitBoxTile(xPos, yPos, bulletWidth, bulletHeight);			
		
	}

	@Override
	public void hurt() {
		//don't need for space invader bullet
		
	}

	@Override
	public void collision() {
		// TODO Auto-generated method stub
>>>>>>> Stashed changes
		
	}

}
