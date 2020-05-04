package game_abstractions;

import game.Interactions;

public interface GameEntity {
	
	public void update(Interactions interactionLevel, int frame);

	public Interactions checkSceneInteraction(double mouseX, double mouseY);

}
