package SpaceInvaders;

import java.util.ArrayList;
import java.util.Iterator;

import edu.princeton.cs.introcs.StdDraw;

//main game class. aggregates functions from other classes to create game
public class GameBoard {
	int frameCounter;
	Player player;
	Fleet fleet;
	DragonBulletCollection dragonBullets;
	
	public static void main(String[] args) {
		GameBoard game = new GameBoard();
		game.setUpGame();
		game.playGame();
	}
	
	public void setUpGame() {
		StdDraw.enableDoubleBuffering();
		StdDraw.setCanvasSize(400, 400);
		StdDraw.setXscale(0,400);
		StdDraw.setYscale(0,400);
		frameCounter = 0;
		this.initPlayer();
		this.initAliens();
	}


	public void playGame() {
		while (true){
			//randomly shoot bullets every couple seconds
			if (frameCounter % 20 == 0) {
				fleet.shootBullets();	
			}
			//spawn new row of invaders every 10 seconds
			if (frameCounter == 300) {
				fleet.addRowOfInvaders();
				frameCounter = 0;
			}
			frameCounter++;
			this.fieldUpdates();
			StdDraw.clear();
			this.drawSprites();
			StdDraw.show();
			StdDraw.pause(66);
	}
			
}
	private void fieldUpdates() {
		player.updatePlayer(dragonBullets, fleet);
		dragonBullets.update();
		fleet.update(dragonBullets);
	}
	
	  private void drawPlayer() {
	      StdDraw.picture(player.getX(), player.getY(), "space_invaders_resources/flying_dragon-red-RGB.png");
	    }
	  
	  private void drawFleet() {
		  Iterator<Invader> it = fleet.getInvaders().iterator(); 
	        while (it.hasNext()) {
	        	Invader element = it.next();
	        	StdDraw.picture(element.getX(), element.getY(), "space_invaders_resources/space_invader_ship.png");
	        }
	  }
	  
	private void drawDragonBullets() {
	    Iterator<DragonBullet> it = dragonBullets.getBullets().iterator(); 
        while (it.hasNext()) {
        		DragonBullet element = it.next();
            StdDraw.picture(element.getX(), element.getY(), "space_invaders_resources/dragon_shot.png");
            
		}
	}
	
	private void drawSpaceInvaderBullets() {
		Iterator<SpaceInvaderBullet> it = fleet.getBullets().iterator();
		while(it.hasNext()) {
			SpaceInvaderBullet element = it.next();
			StdDraw.picture(element.getX(), element.getY(), "space_invaders_resources/invader_shot.png");
			
		}
	}
	
	
	public void initPlayer() {
		player = new Player();
		dragonBullets = new DragonBulletCollection();
	}
	
	public void initAliens() {
		fleet = new Fleet();
		fleet.addRowOfInvaders();
	}

	
	public void drawSprites() {
		this.drawPlayer();
		this.drawFleet();
		this.drawDragonBullets();
		this.drawSpaceInvaderBullets();
		
	}
	public void redrawUI() {
		
		
	}


}