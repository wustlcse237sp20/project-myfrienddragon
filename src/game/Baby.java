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
	
//increases the age of the dragon by 1 and animates the dragon at its new age
	// increases the age of the dragon by 1 and animates the dragon at its new age
	public Dragon ageUp() {
		if (this.foodLevel == 5 && this.loveLevel == 5) {
		Adult dragon = new Adult();
		return dragon;
		}
		return this;
	}
	
	// displays the proper animation for feeding the dragon
	public void animateFeed(int frame) {
		DragonAnimation.babyEat(frame);
	}
	
	// displays the proper animation for petting the dragon
	public void animatePet(int frame) {
		DragonAnimation.babyPet(frame);
	}

	@Override
	public void animateIdle(int frame) {
		DragonAnimation.babyIdle(frame);
		
	}
	
	@Override
	public Interactions checkInteraction(double mouseX, double mouseY) {
		if ((mouseX > 25 && mouseX < 75) && (mouseY > 20 && mouseY < 70)) {
			return Interactions.game ;
			
		}
		if ((mouseX > 225 && mouseX< 270) && (mouseY > 40 && mouseY<75)) {
			 return Interactions.feed;
		}
		else {
			return Interactions.idle;
		}
	
	}
	@Override
	public void update(Interactions interactionValue, int frame) {
		if (interactionValue ==  Interactions.idle) {
			this.animateIdle(frame);
		}
		if (interactionValue == Interactions.feed) {
			if (frame == 1) {
			this.feed();
			}
			this.animateFeed(frame);
		}
		
	}
	
}
