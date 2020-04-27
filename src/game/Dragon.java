package game;

public interface Dragon {

	// functions that modify the dragon
	public int pet();
	public int feed();
	public Dragon ageUp();
	public Interactions checkInteraction(double mouseX, double mouseY);

	// functions that animate the dragon based on the frame rate
	public void animatePet(int frame);
	public void animateFeed(int frame);
	public void animateIdle(int frame);
	public void animateEvolve(int frame);
	
	// functions that check the user interaction and manipulate the dragon appropriately
	public boolean willAge();
	
}
