package game;

import SpaceInvaders.Player;
import animations.DragonAnimation;
import edu.princeton.cs.introcs.StdDraw;

public class Game {
	int frame;
	boolean clicked;
	double mouseX = 0;
	double mouseY = 0;
	Dragon dragon;
	Interactions interactionLevel;
	
	public void setUpScreen() {
		StdDraw.setCanvasSize(400, 400);
		StdDraw.setXscale(0,400);
		StdDraw.setYscale(0,400);
		StdDraw.enableDoubleBuffering();
	}
	
	//checks possible click interactions every frame
	public Interactions onClick() {
		if (dragon.willAge()) {
			frame = 0;
			interactionLevel = Interactions.evolve;
			dragon = dragon.ageUp();
		}
		if (StdDraw.isMousePressed()) {
			 clicked = true;
			 mouseX = StdDraw.mouseX();
			 mouseY = StdDraw.mouseY();
		}
		if (clicked == true && !StdDraw.isMousePressed()) {
				clicked = false;
				 interactionLevel = dragon.checkInteraction(mouseX, mouseY);
				if (interactionLevel != Interactions.idle) {
					frame = 0;
				}
			}
		return interactionLevel;
	}
	
	public boolean isMousePressed() {
		return StdDraw.isMousePressed();
	}
	//updates frames, checks interactions
	public void playGame() {
		clicked = false;
		dragon = new Egg();
		interactionLevel = Interactions.idle;
		while (true){
			if (frame == 30) { // resetting the frame counter each time it reaches 30 and idling the dragon
				interactionLevel = Interactions.idle;
				frame = 0;
				StdDraw.clear();
			}
			frame++;
			interactionLevel = this.onClick();
			DragonAnimation.redrawUI();
			dragon.update(interactionLevel,frame);
			StdDraw.show();
			StdDraw.pause(66);
		}
	}

	public static void main(String[] args) { 
		Game game = new Game();
		game.setUpScreen();
		game.playGame();
	}
}	


