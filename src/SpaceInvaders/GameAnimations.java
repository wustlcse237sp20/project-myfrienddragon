package SpaceInvaders;

import edu.princeton.cs.introcs.StdDraw;

public class GameAnimations {
	
	public void spaceInvaderExplode(Invader invader) {
		int frame = invader.animationTrackerFrame;
		if (frame > 0 && frame < 2) {
			invader.setPicture("space_invaders_resources/explosion-frame-1.png");
		}
		if (frame > 2 && frame < 4) {
			invader.setPicture("space_invaders_resources/explosion-frame-2.jpg");
		}
		if (frame > 4 && frame < 6) {
			invader.setPicture("space_invaders_resources/explosion-frame-3.png");
		}
		if (frame > 6 && frame < 8) {
			invader.setPicture("space_invaders_resources/explosion-frame-4.png");
		}
		if (frame > 8 && frame < 10) {
			invader.setPicture("space_invaders_resources/explosion-frame-5.png");
		}
		if (frame > 10 && frame < 12) {
			invader.setPicture("space_invaders_resources/explosion-frame-6.png");
		}
		if (frame > 12 && frame < 15) {
			invader.setPicture("space_invaders_resources/explosion-frame-7.jpg");
		}
	}
	
	public void playerHurt(Player player) {
		int frame = player.getAnimationTrackerFrame();
		if (frame > 0 && frame < 2) {
			player.setPicture("space_invaders_resources/hurt-dragon.png");
		}
		if (frame > 2 && frame < 5) {
			player.setPicture("space_invaders_resources/flying_dragon-red-RGB.png");
		}
		if (frame > 5 && frame < 8) {
			player.setPicture("space_invaders_resources/hurt-dragon.png");
		}
		if (frame > 8 && frame < 11) {
			player.setPicture("space_invaders_resources/flying_dragon-red-RGB.png");
		}
	}

}
