package game;



import SpaceInvaders.Player;
import animations.DragonAnimation;
import animations.UIAnimations;
import edu.princeton.cs.introcs.StdDraw;
import game_abstractions.GameManager;
import game_abstractions.GameScene;


public class Game extends GameScene {
	int frame;
	boolean clicked;
	static boolean gameInProgress;
	double mouseX = 0;
	double mouseY = 0;
	public static Dragon dragon;
	GameOverScreen gameOverScreen;
	Interactions interactionLevel;
	int iterCount;
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

	public Interactions checkAge() {
		if (dragon.willAge() && dragon.getAge() != 2) {
			interactionLevel = Interactions.evolve;
		}
		if (dragon.willAge() && dragon.getAge()==2) {
			interactionLevel = Interactions.gameover;
		}
	
		return interactionLevel;
	}
	
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
			return interactionLevel;
		}

	public boolean isMousePressed() {
		return StdDraw.isMousePressed();
	}

	// updates frames, checks interactions
	@Override
	public void update() {
		if (frame == 30) {
			interactionLevel = Interactions.idle;
			frame = 0;
			StdDraw.clear();
		}
		frame++;
		interactionLevel = this.renewInteraction();
		if (interactionLevel != Interactions.evolve) {
		DragonAnimation.drawLifeBars(dragon);
		UIAnimations.redrawUI(dragon.getFoodStore().getFoodAmount());
		}
		dragon.update(interactionLevel, frame);
	}
}
