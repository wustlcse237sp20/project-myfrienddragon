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

	public int pet() {
		if (this.loveLevel < 5) {
			this.loveLevel++;
		}
		return this.loveLevel;
	}

	public int feed() {
		if (this.foodLevel < 5) {
			this.foodLevel++;
			System.out.println("Current food level: " + this.foodLevel);
		}
		return this.foodLevel;
	}

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

	/**
	 * assigns appropriate interaction based on where the user clicks
	 */
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

	/**
	 * updates the dragon animation based on the actions of the user
	 */
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
