package SpaceInvaders;

import edu.princeton.cs.introcs.StdDraw;

public class GameBoard {
	int frameCounter;
	
	public void setUpGame() {
		StdDraw.enableDoubleBuffering();
		StdDraw.setXscale(0,400);
		StdDraw.setYscale(0,400);
		StdDraw.setCanvasSize(400, 400);
		this.initPlayer();
		this.initAliens();
	}
	
	public void initPlayer() {
		
	}
	
	public void initAliens() {
		
	}
	
	public void updateScreen() {
		
	}
	
	public void drawSprites() {
		
	}
	public void redrawUI() {
		
	}

}
