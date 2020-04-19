package SpaceInvaders;
//class that defines invisible set of points. overlapping hitboxes will cause collision
public class HitBoxTile {
	double bottomLeftX;
	double bottomLeftY;
	double bottomRightX;
	double topLeftY;

	public HitBoxTile(double xCoord, double yCoord, double height, double width) {
		bottomLeftX = xCoord - width / 2;
		bottomLeftY = yCoord - height / 2;
		bottomRightX = xCoord + width / 2;
		topLeftY = yCoord + height / 2;

	}

	public double getBottomLeftX() {
		return bottomLeftX;
	}

	public double getBottomLeftY() {
		return bottomLeftY;
	}

	public double getBottomRightX() {
		return bottomRightX;
	}

	public double getTopLeftY() {
		return topLeftY;
	}

//checks if hitbox is colliding with another hitbox
	public boolean isColliding(HitBoxTile comparator) {
		if ((this.getTopLeftY() >= comparator.getBottomLeftY())
				&& (this.getBottomLeftY() <= comparator.getTopLeftY())
				&& (this.getBottomLeftX() >= comparator.getBottomLeftX()) 
				&& (this.getBottomLeftX() <= comparator.getBottomRightX())
				) {
			return true;
		}
		return false;
	}

}

	
