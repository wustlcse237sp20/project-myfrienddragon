package SpaceInvaders;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;

import edu.princeton.cs.introcs.StdDraw;
//player class for space invaders

public class Player implements Sprite {
	
	private double x;
	private double y;
	private int score;
	private int health;
	final double hitBoxWidth = 46;
	final double hitBoxHeight = 50;
	final double playerWidth = 46;
	final double playerHeight = 33;
	private HitBoxTile dragonHitBox;

	public Player() {
		this.x = 200;
		this.y = 20;
		this.score = 0;
		this.health = 100;
		this.dragonHitBox = new HitBoxTile(this.x, this.y, hitBoxHeight, hitBoxWidth);
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public int getScore() {
		return this.score;
	}
	
	public int getHealth() {
		return this.health;
	}

	public void isHit(int collisionNumber) {
		this.health -= (10*collisionNumber);
	}

	public void didHitInvader() {
		this.score += 20;
	}
	
	public HitBoxTile getHitBox() {
		return this.dragonHitBox;
	}

	public void interpretKeyPressed(char keyPressed, DragonBulletCollection bullets) {
		if (keyPressed == 'a' || keyPressed == 'd') {
			if (keyPressed == 'a') {
				this.movePlayer('x', -10);
			}
			else {
				this.movePlayer('x', 10);
			}

	}
		if (keyPressed == 'x') {
			this.shootBullet(bullets);
			
		}
}
	
	//moves player based on input
	private void movePlayer(char axis, int dist) {
		if (checkInBounds(axis, dist)) {
			if (axis == 'y') {
				this.y += dist;
			}
			else {
				this.x += dist;
			}
		}
	}
	
	//ensures player cannot move off screen
	private boolean checkInBounds(char axis, int difference) {
		if (axis == 'y') {
			return (this.y + difference) <= 400 && (this.y + difference) >= 0;
		}
		if (axis == 'x') {
			return (this.x + difference) <= 400 && (this.x + difference) >= 0;
		}
		return false;
	}
	
	public void shootBullet(DragonBulletCollection bullets) {
		DragonBullet dragonBullet = new DragonBullet(this.x, this.y);
		bullets.addBullet(dragonBullet);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateHitBoxPos() {
		this.dragonHitBox= new HitBoxTile(x, y, hitBoxHeight, hitBoxWidth);
		
	}


	@Override
	public void hurt() {
		// TODO Auto-generated method stub
		
	}
	//checks if player has been hit by a space invader bullet(s). if so, the player is hurt, and the 
	//space invader bullet is taken off screen.
	public int invaderBulletCollisionChecker(Fleet fleet) {
		Iterator<SpaceInvaderBullet> it = fleet.getBullets().iterator();
		int returner = 0;
        while (it.hasNext()) {
        	SpaceInvaderBullet element = it.next();
        HitBoxTile elementHitBox = element.getHitBox();
        	boolean collided = elementHitBox.isColliding(this.dragonHitBox);
        		if (collided) {
						element.hurt();
						returner=returner+1;
			}
        }
		return returner;
}
	
	//update function aggregates function for checks for collision, new keyboard input, and updating box.
	//allows single function call in gameboard class.
	public void updatePlayer(DragonBulletCollection bullets, Fleet fleet) {
		int returner = this.invaderBulletCollisionChecker(fleet);
		this.isHit(returner);
		if (StdDraw.hasNextKeyTyped()){
			this.interpretKeyPressed(StdDraw.nextKeyTyped(), bullets );
			this.updateHitBoxPos();
		
		}
	}
		

	@Override
	public double getHitBoxBottomLeftX() {
		return this.dragonHitBox.getBottomLeftX();
	}

	@Override
	public double getHitBoxBottomLeftY() {
		return this.dragonHitBox.getBottomLeftY();
	}

	@Override
	public double getHitBoxBottomRightX() {
	return this.dragonHitBox.getBottomRightX();
	}

	@Override
	public double getHitBoxTopLeftY() {
		return this.dragonHitBox.getTopLeftY();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	

}


