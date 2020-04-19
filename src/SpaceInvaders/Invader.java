package SpaceInvaders;
//class to define single space invader
import java.util.ArrayList;
import java.util.Iterator;

public class Invader implements Sprite {
	double xPos;
	double yPos;
	int health;
	HitBoxTile SpaceInvaderTile;
	final double invaderWidth = 50;
	final double invaderHeight = 41;
	boolean onScreen;
	
	public Invader(double x, double y) {
		this.xPos = x;
		this.yPos = y;
		this.health = 1;
		this.onScreen = true;
		this.SpaceInvaderTile = new HitBoxTile(this.xPos, this.yPos, invaderHeight , invaderWidth);
		

	}
	public void hurt() {
		this.onScreen = false;
	}
	
	
	public boolean getOnScreen() {
		return this.onScreen;
	} 
	
	public int getHealth() {
		return health;
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


	@Override
	public void hurt() {
		// TODO Auto-generated method stub
		
	}
<<<<<<< Updated upstream
=======
	
	public HitBoxTile getHitBox() {
		return this.SpaceInvaderTile;
	}
	
	//checks collision with dragon bullets. if collision is detected, the invader is taken off screen, and so is the bullet
	//in question
	public void checkCollision(DragonBulletCollection dragonBullets) {
		Iterator<DragonBullet> it = dragonBullets.getBullets().iterator();
        while (it.hasNext()) {
        	DragonBullet element = it.next();
        HitBoxTile elementHitBox = element.getHitBox();
        	boolean collided = elementHitBox.isColliding(this.getHitBox());
        		if (collided) {
						this.hurt();
						element.hurt();
						
			}
        }
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}	
>>>>>>> Stashed changes
	
}
