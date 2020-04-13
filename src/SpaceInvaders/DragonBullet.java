package SpaceInvaders;

import edu.princeton.cs.introcs.StdDraw;

public class DragonBullet {
	double xPos;
	double yPos;
		
		public DragonBullet(double xPos, double yPos) {
			this.xPos = xPos;
			this.yPos = yPos;
			StdDraw.picture(xPos, yPos, "src/space_invaders_resources/dragon_shot.png");
			
		
	}
		
	
	

}
