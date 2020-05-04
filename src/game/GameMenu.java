package game;

import SpaceInvaders.GameBoard;
import animations.DragonAnimation;
import animations.UIAnimations;
import edu.princeton.cs.introcs.StdDraw;
import game_abstractions.GameEntity;
import game_abstractions.GameManager;
import game_abstractions.GameScene;
import ponggame.PongGame;

public class GameMenu extends GameScene {
	double mouseX;
	double mouseY;
	boolean clicked;
	GameMenuInteractions interactionLevel;
	int frame;
	
	
	public GameMenu(GameManager manager, GameScene parent) {
		super(manager, parent);
		this.mouseX=0;
		this.mouseY=0;
		clicked = false;
		frame = 0;
		
	}

	public void drawGameMenu() {
		UIAnimations.drawGameMenu();	
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
		if (mouseY > 275 && mouseY < 325) {
			return GameMenuInteractions.invaders;
		}
		if (mouseY > 200 && mouseY< 250) {
			return GameMenuInteractions.pong;
		}
		if ((mouseX > 50 && mouseX < 250) && (mouseY > 0 && mouseY < 50)) {
			return GameMenuInteractions.back;
		}
		return GameMenuInteractions.wait;
	}

	
	public void respondToInteraction(GameMenuInteractions interactionLevel, int frame) {
		
		if (interactionLevel == GameMenuInteractions.invaders) {
			GameScene gameBoard = new GameBoard(this.getGameManager(), this.parent);
			this.getGameManager().setScene(gameBoard);
			
		}
		if (interactionLevel == GameMenuInteractions.pong) {
			GameScene pongGame = new PongGame(this.getGameManager(), this.parent);
			this.getGameManager().setScene(pongGame);	
		}
		if (interactionLevel == GameMenuInteractions.back) {
			this.getGameManager().setScene(this.parent);
			
			
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
	
