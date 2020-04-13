package SpaceInvaders;

public class Invader {
	private int x;
	private int y;
	private int health;
	
	public Invader(int x, int y) {
		this.x = x;
		this.y = y;
		this.health = 500;
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
	
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getHealth() {
		return health;
	}
	
}
