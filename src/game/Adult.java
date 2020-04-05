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
			if ((mouseX > 25 && mouseX < 75) && (mouseY > 20 && mouseY < 70)) {
				return Interactions.game;
				
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
			this.animateFeed(frame);
			if (frame == 0) {
			this.feed();
			}
		}
		
	}

	public Dragon ageUp() {
		if (this.foodLevel == 5) {
			System.out.println("Dragon is fully grown, congratulations");
			
		}
		return this;
	}
}
