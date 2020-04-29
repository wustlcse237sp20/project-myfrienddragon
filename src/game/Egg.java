package game;

import animations.DragonAnimation;

public class Egg implements Dragon, GameEntity {

	public int foodLevel;
	public int loveLevel;
	public int age;

	public Egg() {
		this.foodLevel = 0;
		this.loveLevel = 0;
	}

	public int getFoodLevel() {
		return this.foodLevel;
	}

	public int getLoveLevel() {
		return this.loveLevel;
	}

	public int pet() {
		if (this.loveLevel < 100) {
			this.loveLevel += 5;
		}
		return this.loveLevel;
	}

	public int feed() {
		if (this.foodLevel < 100) {
			this.foodLevel += 5;
		}
		return this.foodLevel;
	}

	public Dragon ageUp() {
		Baby dragon = new Baby();
		return dragon;
	}
	
	public boolean willAge() {
		if (this.foodLevel == 100 && this.loveLevel == 100) {
			return true;
		}
		return false;
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

	public void animateEvolve(int frame) {
		DragonAnimation.evolve(frame);
	}
	

	/**
	 * returns an interaction based on where the user clicked
	 */
	@Override
	public Interactions checkInteraction(double mouseX, double mouseY) {
		if (this.willAge()) {
			return Interactions.evolve;
		}
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
	 */	@Override
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
		 if (interactionValue == Interactions.game) {
			 GameMenu gameMenu = new GameMenu();
			 gameMenu.drawGameMenu(frame);
		 }
	 }

}
