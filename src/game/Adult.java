package game;

import animations.DragonAnimation;
import edu.princeton.cs.introcs.StdDraw;

public class Adult implements Dragon {

	public int foodLevel;
	public int loveLevel;
	public int age;

	public Adult() {
		this.foodLevel = 0;
		this.loveLevel = 0;
		this.age = 2;
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

	@Override
	public void animateFeed(int frame) {
		DragonAnimation.adultEat(frame);
	}

	@Override
	public void animatePet(int frame) {
		DragonAnimation.adultPet(frame);
	}

	@Override
	public void animateIdle(int frame) {
		DragonAnimation.adultIdle(frame);
	}
	
	public void animateEvolve(int frame) {
		DragonAnimation.evolve(frame);
	}
	
	public boolean willAge() {
		if (this.foodLevel == 5 && this.loveLevel == 5) {
			return true;
		
		}
		return false;
	}
	
	
	@Override
	public Dragon ageUp() {
			StdDraw.clear();
			StdDraw.text(200, 200, "Congratulations, you raised your dragon to an adult");
		return this;
	}

	/**
	 * returns an interaction based on where the user clicked
	 */
	@Override
	public Interactions checkInteraction(double mousex, double mousey) {
		if ((mousex > 25 && mousex < 85) && (mousey > 20 && mousey < 100)) {
			return Interactions.game;

		}
		if ((mousex > 175 && mousex< 250) && (mousey > 20 && mousey<100)) {
			return Interactions.feed;
		}
		if ((mousex >350 && mousex < 410 ) && (mousey > 20 && mousey < 100)) {
			return Interactions.pet;
		}
		else {
			return Interactions.idle;
		}
	}

	/**
	 * displays the proper animation updates the dragon based on user interaction
	 */
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
