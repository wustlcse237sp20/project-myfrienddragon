package SpaceInvaders;

public class Invader implements Sprite {
<<<<<<< HEAD
	private double xPos;
	private double yPos;
	private int health;
	private HitBoxTile SpaceInvaderTile;
	private final double invaderWidth = 127;
	private final double invaderHeight = 95;
	
=======
	double xPos;
	double yPos;
	int health;
	HitBoxTile SpaceInvaderTile;
	final int startingHealth = 2;
	final double invaderWidth = 50;
	final double invaderHeight = 41;
	final double invaderHitBoxWidth = 32;
	final double invaderHitBoxHeight = 23;
>>>>>>> 28f64e819b9cc170b9ea3f36e4ae781ba87e9d7b
	
	public Invader(double x, double y) {
		this.xPos = x;
		this.yPos = y;
<<<<<<< HEAD
		this.health = 2;
		this.SpaceInvaderTile = new HitBoxTile(this.xPos, this.yPos, invaderHeight , invaderWidth);
=======
		this.health = startingHealth;
		this.health = 2;
		this.SpaceInvaderTile = new HitBoxTile(this.xPos, this.yPos, invaderHitBoxHeight , invaderHitBoxWidth);
		

>>>>>>> 28f64e819b9cc170b9ea3f36e4ae781ba87e9d7b
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
		this.SpaceInvaderTile = new HitBoxTile(this.xPos, this.yPos, invaderHitBoxHeight , invaderHitBoxWidth);
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
	public void hurt() {
		// TODO Auto-generated method stub
		
	}
	
}
