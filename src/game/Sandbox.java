package game;

import animations.UIAnimations;
import edu.princeton.cs.introcs.StdDraw;

public class Sandbox {
	
	public static void main(String[] args) {
		StdDraw.setCanvasSize(400, 400);
		StdDraw.setXscale(0,400);
		StdDraw.setYscale(0,400);
		StdDraw.enableDoubleBuffering();
		UIAnimations.drawGameMenu();
		StdDraw.show();
	}

}
