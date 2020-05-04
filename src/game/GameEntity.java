package game;

public interface GameEntity {

	public void update(Interactions interactionLevel, int frame);
	public Interactions checkInteraction(double mouseX, double mouseY);

}
