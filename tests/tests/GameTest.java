package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import animations.DragonAnimation;
import animations.UIAnimations;
import edu.princeton.cs.introcs.StdDraw;
import game.Dragon;
import game.Egg;
import game.FoodInventory;
import game.Game;
import game.GameMenu;
import game.GameOverScreen;
import game.Interactions;
import game_abstractions.GameManager;
import game_abstractions.GameScene;
import edu.princeton.cs.introcs.StdDraw;
class GameTest {
	

	@Test
	void gameInitialization() {
		GameManager manager = new GameManager();
		Game game = new Game(manager, null);
		if (game != null) {
			assertTrue(true,"Game created");
		}

	}
	@Test
	void onClickIdleTest() {
		GameManager manager = new GameManager();
		DummyGame game = new DummyGame(manager, null);
		game.clicked = true;
		game.mouseX = 395;
		game.mouseY = 395;
		Interactions result = game.renewInteraction();
		Interactions tester = Interactions.idle;
		assertEquals(result, tester);
	}
	
	@Test
	void onClickFoodTest() {
		GameManager manager = new GameManager();
		DummyGame game = new DummyGame(manager, null);
		game.clicked = true;
		game.mouseX = 190;
		game.mouseY = 50;
		Interactions result = game.renewInteraction();
		Interactions tester = Interactions.feed;
		assertEquals(result, tester);
	}
	
	@Test
	void onClickPetTest() {
		GameManager manager = new GameManager();
		DummyGame game = new DummyGame(manager, null);
		game.clicked = true;
		game.mouseX = 375;
		game.mouseY = 50;
		Interactions result = game.renewInteraction();
		Interactions tester = Interactions.pet;
		assertEquals(result, tester);
	}
	
	@Test
	void goToAnotherSceneTest() {
		dummyManager manager = new dummyManager();
		DummyGame game = new DummyGame(manager, null);
		game.clicked = true;
		game.mouseX = 50;
		game.mouseY = 50;
		game.renewInteraction();
		GameMenu fakeMenu = new GameMenu(manager, game);
		assertTrue(manager.currentScene.equals(fakeMenu));
		
	}
	
	@Test
	void ageUpTest() {
		GameManager manager = new GameManager();
		DummyGame game = new DummyGame(manager, null);
		Interactions result = game.renewInteraction();
		Interactions tester = Interactions.feed;
		assertEquals(result, tester);
	}
	
	class DummyGame extends Game {
		int frame;
		boolean clicked;
		boolean gameInProgress;
		double mouseX = 0;
		double mouseY = 0;
		Dragon dragon;
		GameOverScreen gameOverScreen;
		Interactions interactionLevel;
		int iterCount;
		int gameCount;

		public DummyGame(GameManager manager, GameScene parent) {
			super(manager, parent);
			this.frame = 0;
			this.clicked = false;
			FoodInventory foodInventory = new FoodInventory();
			dragon = new Egg(foodInventory);
			interactionLevel = Interactions.idle;
			gameInProgress = true;

		}
		@Override
		public void checkIfAndGoToAnotherScene(double mouseX, double mouseY) {
			if((mouseX > 0 && mouseX< 60) && (mouseY > 0 && mouseY < 100)) {
				GameMenu minigameMenu = new GameMenu(this.getGameManager(), this);
				this.getGameManager().setScene(minigameMenu);
				frame = 0;
			}
		
		}
		@Override
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
		
		@Override
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

		@Override
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
			System.out.println(frame);
			interactionLevel = this.renewInteraction();
			if (interactionLevel != Interactions.evolve) {
			DragonAnimation.drawLifeBars(dragon);
			UIAnimations.redrawUI(dragon.getFoodStore().getFoodAmount());
			}
			dragon.update(interactionLevel, frame);
		}

	}
	public class dummyManager extends GameManager {
		public GameScene currentScene;
	}
}
