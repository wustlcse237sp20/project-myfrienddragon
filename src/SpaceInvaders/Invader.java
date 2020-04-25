package SpaceInvaders;
//class to define single space invader
import java.util.ArrayList;
import java.util.Iterator;

public class Invader implements Sprite {
	double xPos;
	double yPos;
	HitBoxTile SpaceInvaderTile;
	final double invaderWidth = 50;
	final double invaderHeight = 41;
	boolean alive;
	
	public Invader(double x, double y) {
		this.xPos = x;
		this.yPos = y;
		this.alive = true;
		this.SpaceInvaderTile = new HitBoxTile(this.xPos, this.yPos, invaderHeight , invaderWidth);
		

	}
	public void hurt() {
		this.alive = false;
	}
	
	
	public boolean isAlive() {
		return this.alive;
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
	
	public boolean isHit(DragonBulletCollection dragonBullets) {
		Iterator<DragonBullet> bulletIterator = dragonBullets.getBullets().iterator();
        while (bulletIterator.hasNext()) {
        	DragonBullet bullet = bulletIterator.next();
        	HitBoxTile bulletHitBox = bullet.getHitBox();
        	boolean collided = bulletHitBox.isColliding(this.getHitBox());
        		if (collided) {
        			bullet.hurt();
        			return true;	
        		}
        }
        return false;
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
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
