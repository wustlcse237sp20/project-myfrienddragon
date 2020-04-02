package game;

import animations.DragonAnimation;

public class Baby implements Dragon {

	public int foodLevel;
	public int loveLevel;
	public int age;
	
	public Baby() {
		this.foodLevel = 0;
		this.loveLevel = 0;
		this.age = 1;
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
	
	// increases the age of the dragon by 1 and animates the dragon at its new age
	public void ageUp() {
		this.age++;
		DragonAnimation.adultIdle();
	}
	
	// displays the proper animation for feeding the dragon
	public void animateFeed() {
		DragonAnimation.babyEat();
	}
	
	// displays the proper animation for petting the dragon
	public void animatePet() {
		DragonAnimation.babyPet();
	}
	
}
