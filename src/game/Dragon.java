package game;

public interface Dragon {

	public int pet();
	public int feed();
	public void animatePet(int frame);
	public void animateFeed(int frame);
	public void animateIdle(int frame);
	public Interactions checkInteraction(double mouseX, double mouseY);
	public void update(Interactions interactionLevel, int frame);
	public Dragon ageUp();
	
	
}
