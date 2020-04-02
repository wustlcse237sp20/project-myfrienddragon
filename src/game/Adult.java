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
			this.animatePet();
		}
		return this.loveLevel;
	}
	
	// increments the food level of the dragon if it is not already maxed out and returns the current food level
	public int feed() {
		if (this.foodLevel < 5) {
			this.foodLevel++;
			this.animateFeed();
		}
		return this.foodLevel;
	}
	
	// displays the proper animation for feeding the dragon
	public void animateFeed() {
		DragonAnimation.adultEat();
	}
	
	// displays the proper animation for petting the dragon
	public void animatePet() {
		DragonAnimation.adultPet();
	}
	
}
