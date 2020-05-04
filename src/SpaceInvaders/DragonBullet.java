package SpaceInvaders;

//Class for bullet fired by dragon
public class DragonBullet implements Sprite {
	
	double xPos;
	double yPos;
	HitBoxTile DragonBulletHitBox;
	boolean onScreen;
	final double bulletHeight = 32;
	final double bulletWidth = 16;

	public DragonBullet(double xPos, double yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.DragonBulletHitBox = new HitBoxTile(xPos, yPos, bulletHeight, bulletWidth);
		this.onScreen=true;
	}

	//move bullet upscreen 25 pixels per frame
	@Override	
	public void move() {
		this.yPos+=25;
	}

	@Override
	public double getX() {
		return this.xPos;
	}

	@Override
	public double getY() {
		return this.yPos;
	}
	public boolean getOnScreen() {
		return this.onScreen;
	}

	@Override
	public void updateHitBoxPos() {
		this.DragonBulletHitBox = new HitBoxTile(xPos, yPos, bulletHeight, bulletWidth);			

	}
	
	//if bullet is on screen, move and update hitbox, else we set it to off screen
	public void update() {
		this.move();
		if (this.xPos > 400 && this.yPos > 400) {
			this.hurt();
		}
		this.updateHitBoxPos();
	}

	@Override
	public void hurt() {
		this.onScreen=false;
	}

	@Override
	public double getHitBoxBottomLeftX() {
		return this.DragonBulletHitBox.bottomLeftX;
	}

	@Override
	public double getHitBoxBottomLeftY() {
		return this.DragonBulletHitBox.bottomLeftY;
	}

	@Override
	public double getHitBoxBottomRightX() {
		return this.DragonBulletHitBox.bottomRightX;
	}

	@Override
	public double getHitBoxTopLeftY() {
		return this.DragonBulletHitBox.topLeftY;
	}

	public HitBoxTile getHitBox() {
		return this.DragonBulletHitBox;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}	

}
