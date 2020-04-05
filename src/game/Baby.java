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

	public Dragon ageUp() {
		if (this.foodLevel == 5 && this.loveLevel == 5) {
			Adult dragon = new Adult();
			return dragon;
		}
		return this;
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

	/**
	 * assigns appropriate interaction based on where the user clicks
	 */
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

	/**
	 * updates the dragon animation based on the actions of the user
	 */
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
