package game;
import animations.DragonAnimation;
import edu.princeton.cs.introcs.StdDraw;

public class Game {
	
	private Dragon dragon;
	
	public Game() {
		dragon = new Baby();
	}
	
	public void setUpScreen() {
		StdDraw.setCanvasSize(400, 400);
		DragonAnimation.redrawUI();
	}
	
	public void drawDragon() {
		dragon.show();
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.setUpScreen();
		game.drawDragon();
		
	}
}
