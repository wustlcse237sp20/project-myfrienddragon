package game;

import SpaceInvaders.GameBoard;
import animations.UIAnimations;
import edu.princeton.cs.introcs.StdDraw;
import game_abstractions.GameEntity;
import game_abstractions.GameManager;
import game_abstractions.GameScene;
import ponggame.PongGame;

<<<<<<< HEAD
public class GameOverScreen extends GameScene{
		double mouseX;
		double mouseY;
		boolean clicked;
		GameMenuInteractions interactionLevel;
		int frame;
public GameOverScreen(GameManager manager, GameScene parent) {
			super(manager, parent);
			this.mouseX=0;
			this.mouseY=0;
			clicked = false;
			frame = 0;
		}

		public void drawGameMenu() {
			UIAnimations.drawGameOverScreen();
		}
		
		public GameMenuInteractions renewInteraction() {
			if (StdDraw.isMousePressed()) {
				 clicked = true;
				 mouseX = StdDraw.mouseX();
				 mouseY = StdDraw.mouseY();
			}
			if (clicked == true && !StdDraw.isMousePressed()) {
					clicked = false;
					 interactionLevel = this.checkSceneInteraction(mouseX, mouseY);
					if (interactionLevel != GameMenuInteractions.wait) {
						frame = 0;
					}
					
				}
			System.out.println("Interaction level: " + interactionLevel);
			return interactionLevel;
		}

		public GameMenuInteractions checkSceneInteraction(double mouseX, double mouseY) {
			StdDraw.filledRectangle(200,50,100,50);
			if ((mouseX > 100 && mouseX < 300) && (mouseY > 0 && mouseY < 100)) {
				return GameMenuInteractions.restart;
			}
			return GameMenuInteractions.wait;
		}

		
		public void respondToInteraction(GameMenuInteractions interactionLevel, int frame) {
			
			if (interactionLevel == GameMenuInteractions.restart) {
				GameScene game = new Game(this.getGameManager(), null);
				this.getGameManager().setScene(game);
			}
			
			if (interactionLevel == GameMenuInteractions.wait) {
				this.drawGameMenu();
			}
			
			
		}
		public void update() {
			if (frame == 30) {
				interactionLevel = GameMenuInteractions.wait;
				frame = 0;
				StdDraw.clear();
			}
			frame++;
			System.out.println(frame);
			interactionLevel = this.renewInteraction();
			this.respondToInteraction(interactionLevel, frame);
			}
		}
=======
public class GameOverScreen implements GameEntity{
	
	public void drawGameOverScreen() {
		UIAnimations.drawGameOverScreen();	
	}

	@Override
	public void update(Interactions interactionLevel, int frame) {
		this.drawGameOverScreen();
	}

	@Override
	public Interactions checkInteraction(double mouseX, double mouseY) {
		if ((mouseX > 150 && mouseX < 250) && (mouseY> 0 && mouseY <100)) {
			return Interactions.restart;
		}
		return Interactions.wait;
	}
>>>>>>> develop

