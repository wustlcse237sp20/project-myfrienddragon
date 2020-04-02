package game;
import animations.DragonAnimation;
import edu.princeton.cs.introcs.StdDraw;

public class Game {
	
	private Dragon dragon;
	
	public Game() {
		dragon = new Dragon();
	}
	
	public void setUpScreen() {
		StdDraw.setCanvasSize(400, 400);
		DragonAnimation.redrawUI();
		drawDragon();
	}
	
	private void drawDragon() {
		if(dragon.age == 0) {
			DragonAnimation.eggIdle();
		}
		if(dragon.age == 1) {
			DragonAnimation.babyIdle();
		}
		if(dragon.age == 2) {
			DragonAnimation.adultIdle();
		}
			
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.setUpScreen();
	}
}
