package SpaceInvaders;

import edu.princeton.cs.introcs.StdDraw;

public class DragonBullet implements Sprite {
	double xPos;
	double yPos;
	HitBoxTile DragonBulletHitBox;
	boolean onScreen;
	final double bulletHeight = 64;
	final double bulletWidth = 32;
	
	public DragonBullet(double xPos, double yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		StdDraw.picture(xPos, yPos, "src/space_invaders_resources/dragon_shot.png");
		this.DragonBulletHitBox = new HitBoxTile(xPos, yPos, bulletHeight, bulletWidth);
		this.onScreen=true;
	}
	
		
	@Override	
	public void move() {
		this.yPos-=25;
		StdDraw.picture(this.xPos, this.yPos, "src/space_invaders_resources/dragon_shot.png");
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
		this.DragonBulletHitBox = new HitBoxTile(xPos, yPos, bulletHeight, bulletWidth);			
		
	}

	@Override
	public void hurt() {
		//don't need for space invader bullet
		
	}
		
	
	

}
