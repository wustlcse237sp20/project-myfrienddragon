package game;

import com.sun.xml.internal.stream.Entity;

import SpaceInvaders.Player;
import animations.DragonAnimation;
import animations.UIAnimations;
import edu.princeton.cs.introcs.StdDraw;

public class Game {
	int frame;
	boolean clicked;
	static boolean gameInProgress;
	double mouseX = 0;
	double mouseY = 0;
	Dragon dragon;
	GameMenu gameMenu;
	GameEntity entity;
	GameOverScreen gameOverScreen;
	Interactions interactionLevel;
	int iterCount;
	GameMenuInteractions menuInteractionLevel;
	
	public void setUpScreen() {
		StdDraw.setCanvasSize(400, 400);
		StdDraw.setXscale(0,400);
		StdDraw.setYscale(0,400);
		StdDraw.enableDoubleBuffering();
	}

		
	
	public void switchEntity() {
	if (interactionLevel == Interactions.evolve && entity == dragon) {
		if (frame == 1) {
			dragon = dragon.ageUp();
			entity = (GameEntity) dragon;
			System.out.println("Current dragon: " + dragon);
		}
	}
		else if (interactionLevel == Interactions.game) {
			entity = gameMenu;

		}
		else if (interactionLevel == Interactions.back) {
			StdDraw.clear();
			frame = 30;
			entity = (GameEntity) dragon;
		}
		else if (interactionLevel == Interactions.gameover) {
			frame = 30;
			entity = gameOverScreen;
		}
		else if (interactionLevel == Interactions.restart) {
			resetGame();	
		}
	}
	
	public void checkBaseInteraction() {
		if (entity == dragon) {// resetting the frame counter each time it reaches 30 and idling the dragon
			interactionLevel = Interactions.idle;
		}
		else {
			interactionLevel = Interactions.wait;
	}
}
	
	public Interactions checkAge() {
if (entity == dragon) {
	if (dragon.willAge() && dragon.getAge()!=2) {
			interactionLevel = Interactions.evolve;
	}
	if (dragon.willAge() && dragon.getAge() == 2) {
		interactionLevel = Interactions.gameover;	
	}
}
	System.out.println("Interaction in check age: " +  interactionLevel.toString());
		return interactionLevel;
}
	

	
	//checks possible click interactions every frame
	public Interactions renewInteraction() {
		    this.checkAge();
		    this.switchEntity();
			if (StdDraw.isMousePressed()) {
				 clicked = true;
				 mouseX = StdDraw.mouseX();
				 mouseY = StdDraw.mouseY();
			}
			if (clicked == true && !StdDraw.isMousePressed()) {
					clicked = false;
					 interactionLevel = entity.checkInteraction(mouseX, mouseY);
					if (interactionLevel != Interactions.idle && interactionLevel != Interactions.wait) {
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
		FoodInventory foodInventory = new FoodInventory();
		dragon = new Egg(foodInventory);
		gameMenu = new GameMenu();
		gameOverScreen = new GameOverScreen();
		entity = (GameEntity) dragon;
		interactionLevel = Interactions.idle;
		iterCount = 0;
		gameInProgress = true;
		while (gameInProgress){
			if (frame == 30) {
				this.checkBaseInteraction();
				frame = 0;
				iterCount+=1;
				StdDraw.clear();
			}
			frame++;
			interactionLevel = this.renewInteraction();
		    if (entity == dragon) {
			DragonAnimation.drawLifeBars(dragon);
			UIAnimations.redrawUI(foodInventory.getFoodAmount());
			}
			entity.update(interactionLevel,frame);
			StdDraw.show();
			StdDraw.pause(66);
		}
	}
	
	
	public static void resetGame() {
		System.out.println("In reset game");
		Game game = new Game();
		game.setUpScreen();
		game.playGame();
	}

	public static void main(String[] args) { 
		resetGame();
	}
}	


