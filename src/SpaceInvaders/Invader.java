package SpaceInvaders;

public class Invader {
	private int x;
	private int y;
	private int health;
	
	public Invader(int x, int y) {
		this.x = x;
		this.y = y;
		this.health = 2;
	}
	
	public void hurt( ) {
		health = health - 1;
		if(health < 0) {
			health = 0;
		}
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
