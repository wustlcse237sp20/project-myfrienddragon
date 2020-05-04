package game;

import com.sun.xml.internal.stream.Entity;

import SpaceInvaders.Player;
import animations.DragonAnimation;
import animations.UIAnimations;
import edu.princeton.cs.introcs.StdDraw;
import game_abstractions.GameEntity;
import game_abstractions.GameManager;
import game_abstractions.GameScene;

<<<<<<< HEAD

public class Game extends GameScene {
=======
public class Game {
	
>>>>>>> develop
	int frame;
	boolean clicked;
	static boolean gameInProgress;
	double mouseX = 0;
	double mouseY = 0;
	public static Dragon dragon;
	GameOverScreen gameOverScreen;
	Interactions interactionLevel;
	int iterCount;
<<<<<<< HEAD
	int gameCount;

	public Game(GameManager manager, GameScene parent) {
		super(manager, parent);
		this.frame = 0;
		this.clicked = false;
		FoodInventory foodInventory = new FoodInventory();
		dragon = new Egg(foodInventory);
		interactionLevel = Interactions.idle;
		gameInProgress = true;

	}
	
	public void ageDragonAutomatically() {
		if (interactionLevel == Interactions.evolve) {
			if (frame == 1) {
				dragon = dragon.ageUp();
				System.out.println("Current dragon: " + dragon);
			}
			if (frame > 1 && frame < 30) {
				dragon.animateEvolve(frame);
			}
		}
	}
	public void goToGameOver() {
		GameScene gameOverMenu = new GameOverScreen(this.getGameManager(), this);
		this.getGameManager().setScene(gameOverMenu);
	}
=======
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
>>>>>>> develop

	public Interactions checkAge() {
		if (dragon.willAge() && dragon.getAge() != 2) {
			interactionLevel = Interactions.evolve;
		}
		if (dragon.willAge() && dragon.getAge()==2) {
			interactionLevel = Interactions.gameover;
		}
	
		return interactionLevel;
	}
<<<<<<< HEAD
	
	public void checkIfAndGoToAnotherScene(double mouseX, double mouseY) {
		if((mouseX > 0 && mouseX< 60) && (mouseY > 0 && mouseY < 100)) {
			GameMenu minigameMenu = new GameMenu(this.getGameManager(), this);
			this.getGameManager().setScene(minigameMenu);
			frame = 0;
		}
	
	}
	public Interactions checkSceneInteraction(double mouseX, double mouseY) {
		if ((mouseX > 175 && mouseX< 250) && (mouseY > 20 && mouseY<100)) {
			return Interactions.feed;
		}
		if ((mouseX >350 && mouseX < 410 ) && (mouseY > 20 && mouseY < 100)) {
			return Interactions.pet;
		}
		else {
			return Interactions.idle;
		}
	}

	// checks possible click interactions every frame
	public Interactions renewInteraction() {
		    interactionLevel = this.checkAge();
		    if (interactionLevel == Interactions.evolve) {
		    this.ageDragonAutomatically();
		    return interactionLevel;  
		    }
		    if (interactionLevel == Interactions.gameover) {
		    		this.goToGameOver();
		    }
			if (StdDraw.isMousePressed()) {
				 clicked = true;
				 mouseX = StdDraw.mouseX();
				 mouseY = StdDraw.mouseY();
			}
			if (clicked == true && !StdDraw.isMousePressed()) {
					clicked = false;
					this.checkIfAndGoToAnotherScene(mouseX, mouseY);
					 interactionLevel = this.checkSceneInteraction(mouseX, mouseY);
					if (interactionLevel != Interactions.idle) {
						frame = 0;
					}
					
				}
			System.out.println("Interaction level : " + interactionLevel);
			return interactionLevel;
		}
=======

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
		System.out.println("Interaction level: " + interactionLevel);
		System.out.println("Current entity in renewInteractions: " + entity.toString());
		return interactionLevel;
	}
>>>>>>> develop

	public boolean isMousePressed() {
		return StdDraw.isMousePressed();
	}
<<<<<<< HEAD
=======
	
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
				System.out.println("Current entity: " + this.entity.toString());
				frame = 0;
				iterCount+=1;
				StdDraw.clear();
			}
			frame++;
			System.out.println("current dragon: " + dragon.toString());
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
>>>>>>> develop

	// updates frames, checks interactions
	@Override
	public void update() {
		if (frame == 30) {
			interactionLevel = Interactions.idle;
			frame = 0;
			StdDraw.clear();
		}
		frame++;
		System.out.println(frame);
		interactionLevel = this.renewInteraction();
		if (interactionLevel != Interactions.evolve) {
		DragonAnimation.drawLifeBars(dragon);
		UIAnimations.redrawUI(dragon.getFoodStore().getFoodAmount());
		}
		dragon.update(interactionLevel, frame);
	}
<<<<<<< HEAD
}
=======
	
}	

>>>>>>> develop
