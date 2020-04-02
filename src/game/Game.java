package game;

import animations.DragonAnimation;
import edu.princeton.cs.introcs.StdDraw;

public class Game {
	
	public void setUpScreen() {
		StdDraw.setCanvasSize(400, 400);
		StdDraw.setXscale(0,400);
		StdDraw.setYscale(0,400);
		StdDraw.enableDoubleBuffering();
	}
	public void playGame() {
		boolean clicked = false;
		Dragon dragon = new Egg();
		double mouseX = 0;
		double mouseY = 0;
		int frame = 0;
		Interactions interactionLevel = Interactions.idle;
		while (true){
			if (frame == 30) {
				interactionLevel = Interactions.idle;
				frame = 0;
				dragon = dragon.ageUp();
				StdDraw.clear();
			}
			frame++;
			if (StdDraw.mousePressed()) {
				 clicked = true;
				 System.out.println("Mouse pressed");
				 mouseX = StdDraw.mouseX();
				 mouseY = StdDraw.mouseY();
			}
			if (clicked == true && !StdDraw.mousePressed()) {
					clicked = false;
					System.out.println("Mouse released");
					interactionLevel = dragon.checkInteraction(mouseX, mouseY);
					if (interactionLevel != Interactions.idle) {
						frame = 0;
					}
				}
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
	