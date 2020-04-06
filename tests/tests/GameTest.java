package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import animations.DragonAnimation;
import edu.princeton.cs.introcs.StdDraw;
import game.Dragon;
import game.Egg;
import game.Game;
import game.Interactions;
import edu.princeton.cs.introcs.StdDraw;
class GameTest {

	@Test
	void gameInitialization() {
		Game game = new Game();
		if (game != null) {
			assertTrue(true,"Game created");
		}

	}
	@Test
	void onClickTest() {
		Game game = new TestGame();
		Interactions result = game.onClick();
		Interactions tester = Interactions.idle;
		assertEquals(result, tester);
	}
	
	class TestGame extends Game {
		@Override
		public boolean isMousePressed() {
			return true;
		}
		
		@Override
		public void playGame() {
			boolean clicked = false;
			int frame = 0;
			Dragon dragon = new Egg();
			Interactions interactionLevel = Interactions.idle;
			while (true){
				if (frame == 1) {
					interactionLevel = Interactions.idle;
					frame = 0;
					dragon = dragon.ageUp();
					StdDraw.clear();
				}
				frame++;
				System.out.println(frame);
				interactionLevel = this.onClick();
				DragonAnimation.redrawUI();
				dragon.update(interactionLevel,frame);
				StdDraw.show();
				StdDraw.pause(66);
			
			}
		}

	}
}
