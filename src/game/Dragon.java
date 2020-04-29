package game;

public interface Dragon {

	// functions that modify the dragon
	public int pet();
	public int feed();
	public Dragon ageUp();

	// functions that animate the dragon based on the frame rate
	public void animatePet(int frame);
	public void animateFeed(int frame);
	public void animateIdle(int frame);
	public void animateEvolve(int frame);
	
	// functions that check the user interaction and manipulate the dragon appropriately
	public Interactions checkInteraction(double mouseX, double mouseY);
	public void update(Interactions interactionLevel, int frame);
	public boolean willAge();
	
	// getters for dragon status to update food and love meters
	public int getFoodLevel();
	public int getLoveLevel();
	
}
