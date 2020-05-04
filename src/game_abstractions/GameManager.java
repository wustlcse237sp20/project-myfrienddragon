package game_abstractions;


import edu.princeton.cs.introcs.StdDraw;
import game.Game;

public class GameManager {
	private GameScene currentScene;
	public void setUpScreen() {
		StdDraw.enableDoubleBuffering();
		StdDraw.setCanvasSize(400, 400);
		StdDraw.setXscale(0,400);
		StdDraw.setYscale(0,400);
	}
	public  void setScene(GameScene s) {
		StdDraw.clear();
		this.currentScene = s;
	}
	public void run() {
	while (currentScene!=null) {
		this.currentScene.update();
		StdDraw.show();
		StdDraw.pause(66);
	}
}
	public static void main(String[] args) {
		GameManager manager = new GameManager();
		manager.setUpScreen();
		GameScene cs = new Game(manager,null);
		manager.setScene(cs);
		manager.run();
	}
	

}
