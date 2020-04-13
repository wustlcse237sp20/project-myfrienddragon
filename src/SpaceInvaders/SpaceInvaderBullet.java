package SpaceInvaders;

import edu.princeton.cs.introcs.StdDraw;

public class SpaceInvaderBullet {
	double xPos;
	double yPos;
	
	public SpaceInvaderBullet(double xPos, double yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		StdDraw.picture(xPos, yPos, "src/space_invaders_resources/invader_shot.png");
	}
	
	public void updateBullet() {
		
		
	}

}
