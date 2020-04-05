package game;

public interface Dragon {

	// dragon updates based on user interaction
	public int pet();
	public int feed();
	public Dragon ageUp();

	// displays age-appropriate dragon animation with desired frame count
	public void animatePet(int frame);
	public void animateFeed(int frame);
	public void animateIdle(int frame);
	
	// determines which interaction the user chose and displays the appropriate response
	public Interactions checkInteraction(double mouseX, double mouseY);
	public void update(Interactions interactionLevel, int frame);
	
}