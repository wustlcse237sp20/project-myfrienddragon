package SpaceInvaders;
//class to define single space invader
import java.util.ArrayList;
import java.util.Iterator;

public class Invader implements Sprite {
	double xPos;
	double yPos;
	int animationTrackerFrame;
	String image;
	HitBoxTile SpaceInvaderTile;
	final double invaderWidth = 50;
	final double invaderHeight = 41;
	boolean alive;
	boolean collided;
	
	
	public Invader(double x, double y) {
		this.xPos = x;
		this.yPos = y;
		this.alive = true;
		this.collided = false;
		this.SpaceInvaderTile = new HitBoxTile(this.xPos, this.yPos, invaderHeight , invaderWidth);
		this.image = "space_invaders_resources/space_invader_ship.png";
		this.animationTrackerFrame=0;
		

	}
	public void setPicture(String imagePath) {
		this.image = imagePath;
	}
	public String getImage( ) {
		return this.image;
	}
	public void hurt() {
		this.collided = true;
		
	}
	public void destroy() {
	if (this.collided) {
		GameAnimations setAnimation = new GameAnimations();
		setAnimation.spaceInvaderExplode(this);
		if (this.animationTrackerFrame==15) {
			this.alive = false;
			}
		}
		
	}
	
	
	public boolean isAlive() {
		return this.alive;
	} 
	public boolean getCollided() {
		return this.collided;
	}
	

	@Override
	public void move() {
		this.yPos=this.yPos-45;
		this.updateHitBoxPos();
		
	}

	@Override
	public void updateHitBoxPos() {
		this.SpaceInvaderTile = new HitBoxTile(this.xPos, this.yPos, invaderHeight , invaderWidth);
	}


	@Override
	public double getX() {
		return xPos;
	}

	@Override
	public double getY() {
		return yPos;
	}

	public HitBoxTile getHitBox() {
		return this.SpaceInvaderTile;
	}
	
	public void update(DragonBulletCollection dragonBullets) {
		Iterator<DragonBullet> bulletIterator = dragonBullets.getBullets().iterator();
		this.animationTrackerFrame+=1;
		if (this.animationTrackerFrame==16) {
			this.animationTrackerFrame=0;
		}
        while (bulletIterator.hasNext()) {
        	DragonBullet bullet = bulletIterator.next();
        	HitBoxTile bulletHitBox = bullet.getHitBox();
        	boolean collided = bulletHitBox.isColliding(this.getHitBox());
        		if (collided) {
        			bullet.hurt();
        			this.hurt();
        			animationTrackerFrame = 0;
        		}		
        }
        this.destroy();
	}

	@Override
	public double getHitBoxBottomLeftX() {
		return this.getHitBox().getBottomLeftX();
	}
	@Override
	public double getHitBoxBottomLeftY() {
		// TODO Auto-generated method stub
		return this.getHitBox().getBottomLeftY();
	}
	@Override
	public double getHitBoxBottomRightX() {
		return this.getHitBox().getBottomRightX();
	}
	@Override
	public double getHitBoxTopLeftY() {
		return this.getHitBox().getTopLeftY();
	}

	
}
