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
	long prevTime = 0;
	int animationTrackerFrame;
	String image;
	boolean collided;
	boolean alive = true;

	public Player() {
		this.x = 200;
		this.y = 70;
		this.score = 0;
		this.health = 100;
		this.image = "space_invaders_resources/flying_dragon-red-RGB.png";
		this.dragonHitBox = new HitBoxTile(this.x, this.y, hitBoxHeight, hitBoxWidth);
		this.animationTrackerFrame=0;
		this.collided =false;
		this.alive = true;
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
	
	public boolean getCollided() {
		return this.collided;
	}
	
	public boolean getAlive() {
		return this.alive;
	}

	public int getHealth() {
		return this.health;
	}
	
	public int getAnimationTrackerFrame() {
		return this.animationTrackerFrame;
	}
	
	public String getImagePath() {
		return this.image;
	}
	
	public void setPicture(String imagePath) {
		this.image = imagePath;
	}

	public void isHit(int collisionNumber) {
		this.health -= (20*collisionNumber);
	}

	public void didHitInvader() {
		this.score += 20;
	}

	public HitBoxTile getHitBox() {
		return this.dragonHitBox;
	}

	public void interpretMovement(DragonBulletCollection bullets) {
		if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
			this.movePlayer(-10);
		}
		if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
			this.movePlayer(10);
		}
		if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE)) {
			long curr = System.currentTimeMillis();
			if (curr >= (prevTime + 700)) {
				this.shootBullet(bullets);
				prevTime = curr;
			}
		}
	}

	//moves player based on input
	private void movePlayer(int dist) {
		if (checkInBounds(dist)) {
			this.x += dist;
		}
	}

	//ensures player cannot move off screen
	private boolean checkInBounds(int difference) {
		return (this.x + difference) <= 400 && (this.x + difference) >= 0;
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
		this.collided = true;
	}
	
	public void playHurtAnimation() {
		GameAnimations setAnimation = new GameAnimations();
		setAnimation.playerHurt(this);
	}
	
	public void checkDestroy() {
		if (this.getHealth() ==0) {
			this.alive = false;
		}
	}

	//checks if player has been hit by a space invader bullet(s). if so, the player is hurt, and the 
	//space invader bullet is taken off screen.
	public int invaderBulletCollisionChecker(Fleet fleet) {
		Iterator<SpaceInvaderBullet> it = fleet.getBullets().iterator();
		int returner = 0;
		this.animationTrackerFrame+=1;
		if (this.animationTrackerFrame==16 || this.collided == true) {
			this.animationTrackerFrame=0;
			this.collided = false;
		}
		while (it.hasNext()) {
			SpaceInvaderBullet element = it.next();
			HitBoxTile elementHitBox = element.getHitBox();
			boolean collided = elementHitBox.isColliding(this.dragonHitBox);
			if (collided) {
				element.hurt();
				returner=returner+1;
				this.hurt();
			}
		}
		if (this.collided) {
			this.playHurtAnimation();
		}
		this.checkDestroy();
		return returner;
	}

	//update function aggregates function for checks for collision, new keyboard input, and updating box.
	//allows single function call in gameboard class.
	public void updatePlayer(DragonBulletCollection bullets, Fleet fleet) {
		int returner = this.invaderBulletCollisionChecker(fleet);
		this.isHit(returner);
		this.interpretMovement(bullets);
		this.updateHitBoxPos();
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


