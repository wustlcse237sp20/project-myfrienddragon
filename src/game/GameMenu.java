package game;

import SpaceInvaders.GameBoard;
import animations.UIAnimations;
import edu.princeton.cs.introcs.StdDraw;
import ponggame.PongGame;

public class GameMenu implements GameEntity {
	
	public GameMenu() {
	
		
	}
	
	public void drawGameMenu(int frame) {
		UIAnimations.drawGameMenu();	
	}
	
	public void getGame() {
		
	}

	public Interactions checkInteraction(double mouseX, double mouseY) {
		if (mouseY > 275 && mouseY < 325) {
			return Interactions.invaders;
		}
		if (mouseY > 200 && mouseY< 250) {
			return Interactions.pong;
		}
		if ((mouseX > 100 && mouseX < 250) && (mouseY > 0 && mouseY < 50)) {
			return Interactions.back;
		}
		return Interactions.wait;
	}

	@Override
	public void update(Interactions interactionLevel, int frame) {
		if (interactionLevel == Interactions.invaders) {
			GameBoard game = new GameBoard();
			game.setUpGame();
			game.playGame();
			
		}
		if (interactionLevel == Interactions.pong) {
			PongGame game = new PongGame();
			int food = game.playGame();
			interactionLevel = Interactions.wait;
		}
		if (interactionLevel == Interactions.back) {
			
			
		}
		if (interactionLevel == Interactions.wait)
		this.drawGameMenu(frame);
		
	}
	

	
	
	
	

}
