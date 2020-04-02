package game;

import animations.DragonAnimation;

public class Egg implements Dragon {

	public int foodLevel;
	public int loveLevel;
	public int age;
	
	public Egg() {
		this.foodLevel = 0;
		this.loveLevel = 0;
		this.age = 0;
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
		System.out.println("Current food level: " + this.foodLevel);
		if (this.foodLevel < 5) {
			this.foodLevel++;
			System.out.println(this.foodLevel);
		}
		return this.foodLevel;
	}
	
	// increases the age of the dragon by 1 and animates the dragon at its new age
	public Dragon ageUp() {
		if (this.foodLevel == 5) {
			Baby dragon = new Baby();
			System.out.println("Made dragon a baby");
			return dragon;
			
		}
		return this;
	}
	

	@Override
	public void animatePet(int frame) {
		// TODO Auto-generated method stub
		DragonAnimation.eggPet(frame);
	}

	@Override
	public void animateFeed(int frame) {
		DragonAnimation.eggEat(frame);
	}

	@Override
	public void animateIdle(int frame) {
		DragonAnimation.eggIdle(frame);
		
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


	
}
