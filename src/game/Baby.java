package game;

import animations.DragonAnimation;
import edu.princeton.cs.introcs.StdDraw;
import game.Dragon;
import game.Interactions;
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
	 * returns an interaction value based on where the user clicks
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
	 * displays the appropriate animation based on the user click
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
		if (interactionValue == Interactions.pet) {
			this.animatePet(frame);
			if (frame == 0) {
				this.pet();
			}
		}	
	}
	
}