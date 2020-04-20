package SpaceInvaders;

public interface Sprite {
	public void move();
	public void updateHitBoxPos();
	public void destroy();
	public void hurt();
	public double getX();
	public double getY();
	public double getHitBoxBottomLeftX();
	public double getHitBoxBottomLeftY();
	public double getHitBoxBottomRightX();
	public double getHitBoxTopLeftY();
	
	
	

	

}
