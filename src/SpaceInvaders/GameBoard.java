package SpaceInvaders;

import java.awt.Font;

import java.util.Iterator;


import edu.princeton.cs.introcs.StdDraw;
import game.Dragon;
import game.Game;
import game_abstractions.GameManager;
import game_abstractions.GameScene;

//main game class. aggregates functions from other classes to create game
public class GameBoard extends GameScene {
	int score;
	int frame;
	int spawnCounter;
	Player player;
	Fleet fleet;
	DragonBulletCollection dragonBullets;
	boolean gameOver;
	
	public GameBoard(GameManager manager, GameScene parent) {
		super(manager, parent);
		this.frame = 0;
		this.score = 0;
		this.spawnCounter=0;
		this.player = new Player();
		this.fleet = new Fleet();
		this.dragonBullets=new DragonBulletCollection();
		this.gameOver = false;
		this.setUpSprites();	
		
	}



	@Override
	public void update() {
			//randomly shoot bullets every couple seconds
			if (frame % 20 == 0) {
				fleet.shootBullets();	
			}
			//spawn new row of invaders every 10 seconds
			if (frame== 300) {
				fleet.addRowOfInvaders();
				frame = 0;
			}
			//spawn new row of invaders every 10 seconds
			frame++;
			this.fieldUpdates();
			StdDraw.clear();
			this.drawSprites();
			this.gameOver();
			if (this.gameOver) {
			endGame();
			}
		}
	
	
	private void setUpSprites() {
		this.fleet.spawnInvaders();
	}
	
	private void gameOver() {
		if(fleet.getInvaders().size() == 0 || player.getHealth()==0) {
			this.gameOver=true;
		}
	}
	
	private void endGame() {
		Game.dragon.updateFoodStore((int)this.score/50);
		GameScene GameOverScreen = new GameOverScreen(this.getGameManager(), this);
		this.getGameManager().setScene(GameOverScreen);
	}
	
	private void fieldUpdates() {
		player.updatePlayer(dragonBullets, fleet);
		dragonBullets.update();
		fleet.update(dragonBullets, frame);
		updateScore();
		updateHealthDisplay();
	}
	private String updateHealthDisplay() {
		String healthBarPath = " ";
		if (player.getHealth() == 100) {
			healthBarPath = "space_invaders_resources/health_bar/healthbarfull.png";	
		}
		if (player.getHealth()==80) {
			healthBarPath = "space_invaders_resources/health_bar/healthbar80%.png";	
		}
		if (player.getHealth()==60) {
			healthBarPath = "space_invaders_resources/health_bar/healthbar60%.png";	
		}
		if (player.getHealth()==40) {
			healthBarPath = "space_invaders_resources/health_bar/healthbar40%.png";	
		}
		if (player.getHealth()==20) {
			healthBarPath = "space_invaders_resources/health_bar/healthbar20%.png";	
		}
		if (player.getHealth()==0) {
			healthBarPath = "space_invaders_resources/health_bar/healthbar0%.png";	
		}
		return healthBarPath;
	}
	
	private void updateScore() {
		int invadersDestroyed = fleet.getNumDestroyed();
		score = invadersDestroyed * 20;
	}
	
	public void drawSprites() {
		this.drawScoreBoard();
		this.drawHealthBar();
		this.drawPlayer();
		this.drawFleet();
		this.drawDragonBullets();
		this.drawSpaceInvaderBullets();
	}
	
	private void drawScoreBoard() {
		StdDraw.rectangle(60, 30, 55, 15);
		Font font = new Font("Courier", Font.BOLD, 16);
		StdDraw.setFont(font);
		StdDraw.text(60.0, 30.0, "Score: " + score);
	}
	private void drawHealthBar() {
		StdDraw.picture(300, 30, updateHealthDisplay(), 128,79);
	}
	
	private void drawPlayer() {
		StdDraw.picture(player.getX(), player.getY(), player.getImagePath());
	}
	  
	private void drawFleet() {
		Iterator<Invader> it = fleet.getInvaders().iterator(); 
	    while (it.hasNext()) {
	    	Invader element = it.next();
	       	StdDraw.picture(element.getX(), element.getY(), element.getImage());
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

}
