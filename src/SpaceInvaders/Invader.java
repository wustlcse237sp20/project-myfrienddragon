package SpaceInvaders;

public class Invader implements Sprite {
	double xPos;
	double yPos;
	int health;
	HitBoxTile SpaceInvaderTile;
	final double invaderWidth = 127;
	final double invaderHeight = 95;
	
	public Invader(double x, double y) {
		this.xPos = x;
		this.yPos = y;
		this.health = 2;
		this.SpaceInvaderTile = new HitBoxTile(this.xPos, this.yPos, invaderHeight , invaderWidth);
		

	}
	
	public void hurt(int damage) {
		health = health - damage;
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
	
	private void destroy() {
		// run animation
	}
	
	public int getHealth() {
		return health;
	}

	@Override
	public void move() {
		
		
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void collision() {
		// TODO Auto-generated method stub
		
	}
	
}
