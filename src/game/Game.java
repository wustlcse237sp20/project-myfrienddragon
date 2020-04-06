package game;

import animations.DragonAnimation;
import edu.princeton.cs.introcs.StdDraw;

public class Game {
<<<<<<< Updated upstream


=======
	int frame;
	boolean clicked;
	double mouseX = 0;
	double mouseY = 0;
	Dragon dragon;
	Interactions interactionLevel;
	
>>>>>>> Stashed changes
	public void setUpScreen() {
		StdDraw.setCanvasSize(400, 400);
		StdDraw.setXscale(0,400);
		StdDraw.setYscale(0,400);
		StdDraw.enableDoubleBuffering();
	}
<<<<<<< Updated upstream
	public void playGame() {
		boolean clicked = false;
		Dragon dragon = new Egg();
		double mouseX = 0;
		double mouseY = 0;
		int frame = 0;
		Interactions interactionLevel = Interactions.idle;
=======
	
	//checks possible click interactions every frame
	public Interactions onClick() {
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
>>>>>>> Stashed changes
		while (true){
			if (frame == 30) {
				interactionLevel = Interactions.idle;
				frame = 0;
				dragon = dragon.ageUp();
				StdDraw.clear();
			}
			frame++;
<<<<<<< Updated upstream
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
=======
			System.out.println(frame);
			interactionLevel = this.onClick();
>>>>>>> Stashed changes
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
	

