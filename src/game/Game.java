package game;

import com.sun.xml.internal.stream.Entity;

import SpaceInvaders.Player;
import animations.DragonAnimation;
import animations.UIAnimations;
import edu.princeton.cs.introcs.StdDraw;

public class Game {
	int frame;
	boolean clicked;
	double mouseX = 0;
	double mouseY = 0;
	Dragon dragon;
	GameMenu gameMenu;
	GameEntity entity;
	Interactions interactionLevel;
	GameMenuInteractions menuInteractionLevel;
	
	public void setUpScreen() {
		StdDraw.setCanvasSize(400, 400);
		StdDraw.setXscale(0,400);
		StdDraw.setYscale(0,400);
		StdDraw.enableDoubleBuffering();
	}
	
	public void checkEntity() {
		if (interactionLevel == Interactions.game) {
			entity = gameMenu;
		}
		if (interactionLevel == Interactions.back) {
			entity = (GameEntity) dragon;
		}
	}
	
	//checks possible click interactions every frame
	public Interactions onClick() {
		if (entity == dragon) {
			if (dragon.willAge()) {
				frame = 0;
				interactionLevel = Interactions.evolve;
				dragon = dragon.ageUp();
			}
		}
			if (StdDraw.isMousePressed()) {
				 clicked = true;
				 mouseX = StdDraw.mouseX();
				 mouseY = StdDraw.mouseY();
			}
			if (clicked == true && !StdDraw.isMousePressed()) {
					clicked = false;
					 interactionLevel = entity.checkInteraction(mouseX, mouseY);
					if (interactionLevel != Interactions.idle || interactionLevel != Interactions.wait) {
						frame = 0;
					}
					this.checkEntity();
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
		gameMenu = new GameMenu();
		entity = (GameEntity) dragon;
		interactionLevel = Interactions.idle;
		while (true){
			if (frame == 30) {
				if (entity == dragon) {// resetting the frame counter each time it reaches 30 and idling the dragon
				interactionLevel = Interactions.idle;
				}
				else {
					interactionLevel = Interactions.wait;
				}
				frame = 0;
				StdDraw.clear();
			}
			frame++;
			interactionLevel = this.onClick();
			UIAnimations.redrawUI();
			entity.update(interactionLevel,frame);
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


