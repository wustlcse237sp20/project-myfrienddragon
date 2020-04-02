package game;

import animations.DragonAnimation;

public class Adult implements Dragon {

	public int foodLevel;
	public int loveLevel;
	public int age;
	
	public Adult() {
		this.foodLevel = 0;
		this.loveLevel = 0;
		this.age = 2;
	}
	
	// increments the love level of the dragon if it is not already maxed out and returns the current love level
	public int pet() {
		if (this.loveLevel < 5) {
			this.loveLevel++;
		}
		return this.loveLevel;
	}
	
	// increments the food level of the dragon if it is not already maxed out and returns the current food level
	public int feed() {
		if (this.foodLevel < 5) {
			this.foodLevel++;
		}
		return this.foodLevel;
	}
	
	// displays the proper animation for feeding the dragon
	@Override
	public void animateFeed(int frame) {
		DragonAnimation.adultEat(frame);
	}
	
	// displays the proper animation for petting the dragon

	@Override
	public void animatePet(int frame) {
		DragonAnimation.adultPet(frame);
		
	}

	@Override
	public void animateIdle(int frame) {
		DragonAnimation.adultIdle(frame);
		
	}

	@Override
	public Interactions checkInteraction(double mouseX, double mouseY) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Interactions interactionLevel, int frame) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Dragon ageUp() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
