package game;

// ASSUMING FOOD AND LOVE METERS GO UP TO 5
// ASSUMING DRAGON HAS 3 STAGES OF LIFE
// feel free to change it if i'm wrong!!

public class Dragon {

	public int foodLevel;
	public int loveLevel;
	public int age;
	
	public Dragon() { // a new dragon has unfilled needs and is at the initial stage of life
		this.foodLevel = 0;
		this.loveLevel = 0;
		this.age = 0;
	}
	
	// increments the love level of the dragon if it is not already maxed out and returns the current love level
	public int pet() {
		if (this.loveLevel < 5 && this.loveLevel >= 0) {
			this.loveLevel++;
			this.animatePet();
		}
		return this.loveLevel;
	}
	
	// increments the food level of the dragon if it is not already maxed out and returns the current food level
	public int feed() {
		if (this.foodLevel < 5 && this.foodLevel >= 0) {
			this.foodLevel++;
			this.animateFeed();
		}
		return this.foodLevel;
	}
	
	// increases the age of the dragon by 1 if it is not already at it's final form
	public int ageUp() {
		if (this.age < 3) {
			this.age++;
		}
		return this.age;
	}
	
	// displays the proper animation for feeding the dragon based on its age
	private void animateFeed() {
		if (this.age == 0) {
			DragonAnimation.eggEat();
		}
		else if (this.age == 1) {
			DragonAnimation.babyEat();
		}
		else {
			DragonAnimation.adultEat();
		}
	}
	
	// displays the proper animation for petting the dragon based on its age
	private void animatePet() {
		if (this.age == 0) {
			DragonAnimation.eggPet();
		}
		else if (this.age == 1) {
			DragonAnimation.babyPet();
		}
		else {
			DragonAnimation.adultPet();
		}
	}
	
}
