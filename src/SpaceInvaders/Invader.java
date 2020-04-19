package SpaceInvaders;

public class Invader implements Sprite {
	private double xPos;
	private double yPos;
	private int health;
	private HitBoxTile SpaceInvaderTile;
	private final double invaderWidth = 127;
	private final double invaderHeight = 95;
	
	
	public Invader(double x, double y) {
		this.xPos = x;
		this.yPos = y;
		this.health = 2;
		this.SpaceInvaderTile = new HitBoxTile(this.xPos, this.yPos, invaderHeight , invaderWidth);
	}
	
	public void hurt() {
		health = health - 1;
		if(health < 0) {
			health = 0;
		}
		if(isDead()) {
			destroy();
		}
	}
	
	public boolean isDead() {
		if (health == 0) {
			return true;
		}
		else {
			return false;
		}
	} 

	@Override
	public void move() {
		yPos += invaderHeight;	
	}

	@Override
	public void updateHitBoxPos() {
		this.SpaceInvaderTile = new HitBoxTile(this.xPos, this.yPos, invaderHeight , invaderWidth);
	}

	@Override
	public void destroy() {
		if (health == 0) {
			
		}
		
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
	public void collision() {
		// TODO Auto-generated method stub
		
	}
	
}
