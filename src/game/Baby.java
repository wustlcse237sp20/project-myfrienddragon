package game;

import animations.DragonAnimation;

public class Baby implements Dragon, GameEntity {

	public int foodLevel;
	public int loveLevel;
	public int age;

	public Baby() {
		this.foodLevel = 0;
		this.loveLevel = 0;
		this.age = 1;
	}

	public int pet() {
		if (this.loveLevel < 5) {
			this.loveLevel++;
		}
		return this.loveLevel;
	}

	public int feed() {
		if (this.foodLevel < 5) {
			this.foodLevel++;
		}
		return this.foodLevel;
	}
	
	public boolean willAge() {
		if (this.foodLevel == 5 && this.loveLevel == 5) {
			return true;
		
		}
		return false;
	}
	
	public Dragon ageUp() {
			Adult dragon = new Adult();
			return dragon;
	}
	

	public void animateFeed(int frame) {
		DragonAnimation.babyEat(frame);
	}

	public void animatePet(int frame) {
		DragonAnimation.babyPet(frame);
	}

	@Override
	public void animateIdle(int frame) {
		DragonAnimation.babyIdle(frame);
	}
	
	public void animateEvolve(int frame) {
		DragonAnimation.evolve(frame);
	}

	/**
	 * returns an interaction based on where the user clicked
	 */
	@Override
	public Interactions checkInteraction(double mouseX, double mouseY) {
		
		if ((mouseX > 25 && mouseX < 85) && (mouseY > 20 && mouseY < 100)) {
			return Interactions.game;

		}
		if ((mouseX > 175 && mouseX< 250) && (mouseY > 20 && mouseY<100)) {
			return Interactions.feed;
		}
		if ((mouseX >350 && mouseX < 410 ) && (mouseY > 20 && mouseY < 100)) {
			return Interactions.pet;
		}
		else {
			return Interactions.idle;
		}

	}

	/**
	 * displays the proper animation updates the dragon based on user interaction
	 */
	@Override
	public void update(Interactions interactionValue, int frame) {
		if (interactionValue == Interactions.evolve) {
			this.animateEvolve(frame);
		}
		if (interactionValue ==  Interactions.idle) {
			this.animateIdle(frame);
		}
		if (interactionValue == Interactions.feed) {
			this.animateFeed(frame);
			if (frame == 0) {
				this.feed();
			}
		}
		if (interactionValue == Interactions.pet) {
			this.animatePet(frame);
			if (frame == 0) {
				this.pet();
			}
		}	
	}

	
}



