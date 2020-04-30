package game;

import animations.UIAnimations;

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
	

}
