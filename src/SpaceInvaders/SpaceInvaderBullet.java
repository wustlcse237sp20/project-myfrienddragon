package SpaceInvaders;
import edu.princeton.cs.introcs.StdDraw;
//class for bullet shot by space invaders
public class SpaceInvaderBullet implements Sprite {
	final double bulletWidth = 26;
	final double bulletHeight = 22;
	double xPos;
	double yPos;
	HitBoxTile invaderBulletHitBox;
	boolean onScreen;
	
	public SpaceInvaderBullet(double xPos, double yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		invaderBulletHitBox = new HitBoxTile(xPos, yPos, bulletHeight, bulletWidth);
		this.onScreen=true;
	}
	//if bullet is off screen, turn it to off screen. else, update it by moving it and its associated hitbox.
	public void update() {
		if (this.yPos < 0) {
			this.hurt();
		}
		this.move();
		this.updateHitBoxPos();
			
	}
		
	@Override	
	public void move() {
		this.yPos-=25;
	}

	public boolean getOnScreen() {
		return this.onScreen;
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
		invaderBulletHitBox = new HitBoxTile(xPos, yPos, bulletWidth, bulletHeight);
		
	}

	@Override
	public void hurt() {
		this.onScreen = false;
		
	}


	@Override
	public double getHitBoxBottomLeftX() {
		// TODO Auto-generated method stub
		return this.invaderBulletHitBox.getBottomLeftX();
	}


	@Override
	public double getHitBoxBottomLeftY() {
		return this.invaderBulletHitBox.getBottomLeftY();
	}


	@Override
	public double getHitBoxBottomRightX() {
		return this.invaderBulletHitBox.getBottomRightX();
	}


	@Override
	public double getHitBoxTopLeftY() {
		return this.invaderBulletHitBox.getTopLeftY();
	}
	
	public HitBoxTile getHitBox() {
		return this.invaderBulletHitBox;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	

}