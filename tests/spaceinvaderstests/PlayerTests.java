package spaceinvaderstests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.KeyEvent;

import org.junit.jupiter.api.Test;

import SpaceInvaders.Fleet;
import SpaceInvaders.HitBoxTile;
import SpaceInvaders.Player;
import SpaceInvaders.SpaceInvaderBullet;
import SpaceInvaders.DragonBulletCollection;
import edu.princeton.cs.introcs.StdDraw;
import game.Egg;

class PlayerTests {
	
	class dummyPlayer extends Player {
		private double x;
		private double y;
		private int score;
		private int health;
		final double hitBoxWidth = 46;
		final double hitBoxHeight = 50;
		final double playerWidth = 46;
		final double playerHeight = 33;
		private HitBoxTile dragonHitBox;
		long prevTime = 0;
		int animationTrackerFrame;
		String image;
		boolean collided;
		boolean alive = true;
		public dummyPlayer() {
			this.x = 200;
			this.y = 70;
			this.score = 0;
			this.health = 100;
			this.image = "space_invaders_resources/flying_dragon-red-RGB.png";
			this.dragonHitBox = new HitBoxTile(this.x, this.y, hitBoxHeight, hitBoxWidth);
			this.animationTrackerFrame=0;
			this.collided =false;
			this.alive = true;
		}
		
		private void movePlayer(int dist) {
			if (checkInBounds(dist)) {
				this.x += dist;
			}
		}

		//ensures player cannot move off screen
		private boolean checkInBounds(int difference) {
			return (this.x + difference) <= 400 && (this.x + difference) >= 0;
		}

		
	public void interpretDummyMovement(DragonBulletCollection bullets, int keyCode) {
		if (keyCode==(KeyEvent.VK_LEFT)) {
			this.movePlayer(-10);
		}
		if (keyCode ==(KeyEvent.VK_RIGHT)) {
			this.movePlayer(10);
		}
		if (keyCode == (KeyEvent.VK_SPACE)) {
			long curr = System.currentTimeMillis();
			if (curr >= (prevTime + 700)) {
				this.shootBullet(bullets);
				prevTime = curr;
			}
		}
	}
		public void updateDummyPlayer(DragonBulletCollection bullets, int keyCode) {
			this.interpretDummyMovement(bullets, keyCode);
		}
	}


	@Test
	void creationTest() {
		Player p = new Player();
		if (p != null) {
			assertTrue(true,"Player created");
		}
	}
	
	@Test
	void testInitialVariables() {
		Player p = new Player();
		assertEquals(p.getScore(), 0);
		assertEquals(p.getX(), 200);
		assertEquals(p.getY(), 20);
		assertEquals(p.getHealth(), 100);
	}
	
	
	@Test
	void testMoveLeft() {
		dummyPlayer p = new dummyPlayer();
		DragonBulletCollection collection = new DragonBulletCollection();
		p.interpretDummyMovement(collection, KeyEvent.VK_LEFT);
		assertEquals(p.x, 190);
		
	}
	@Test
	void testMoveRight() {
		dummyPlayer p = new dummyPlayer();
		DragonBulletCollection collection = new DragonBulletCollection();
		p.interpretDummyMovement(collection, KeyEvent.VK_RIGHT);
		assertEquals(p.x, 210);
		
	}
	
	@Test
	void testDragonCantGoRightOffBoard() {
		dummyPlayer p = new dummyPlayer();
		DragonBulletCollection collection = new DragonBulletCollection();
		for (int i = 0; i < 22; i++) {
			p.interpretDummyMovement(collection, KeyEvent.VK_RIGHT);
		}
		assertEquals(400, p.x);
	}
	
	@Test
	void testDragonCantGoLeftOffBoard() {
		dummyPlayer p = new dummyPlayer();
		DragonBulletCollection collection = new DragonBulletCollection();
		for (int i = 0; i < 22; i++) {
			p.interpretDummyMovement(collection, KeyEvent.VK_LEFT);
		}
		assertEquals(0, p.x);
	}
	
	@Test
	void testShootInControls() {
		Player p = new Player();
		DragonBulletCollection collection = new DragonBulletCollection();
		p.shootBullet(collection);
		assertEquals(collection.getBullets().size(), 1);
		
	}
	
	@Test
	void testShootInShootFunction() {
		Player p = new Player();
		DragonBulletCollection collection = new DragonBulletCollection();
		p.shootBullet(collection);
		assertEquals(collection.getBullets().size(), 1);
		
	}
	
	@Test
	void testCollision1() {
		Player p = new Player();
		Fleet fleet = new Fleet();
		SpaceInvaderBullet collider = new SpaceInvaderBullet(200, 75);
		fleet.getBullets().add(collider);
		int returner = p.invaderBulletCollisionChecker(fleet);
		assertEquals(1, returner);
			
	}
	
	@Test
	void testCornerCollision1() {
		Player p = new Player();
		Fleet fleet = new Fleet();
		SpaceInvaderBullet collider = new SpaceInvaderBullet(225,70);
		fleet.getBullets().add(collider);
		int returner = p.invaderBulletCollisionChecker(fleet);
		assertEquals(1, returner);
			
	}
	
	@Test
	void testCornerCollision2() {
		Player p = new Player();
		Fleet fleet = new Fleet();
		SpaceInvaderBullet collider = new SpaceInvaderBullet(190 , 70 );
		fleet.getBullets().add(collider);
		int returner = p.invaderBulletCollisionChecker(fleet);
		assertEquals(1, returner);
			
	}
	@Test 
	void testCornerCollision3() {
		Player p = new Player();
		Fleet fleet = new Fleet();
		SpaceInvaderBullet collider = new SpaceInvaderBullet(190, 50);
		fleet.getBullets().add(collider);
		int returner = p.invaderBulletCollisionChecker(fleet);
		assertEquals(1, returner);	
	}
	
	@Test
	void testCornerCollision4() {
		Player p = new Player();
		Fleet fleet = new Fleet();
		SpaceInvaderBullet collider = new SpaceInvaderBullet(225,50);
		fleet.getBullets().add(collider);
		int returner = p.invaderBulletCollisionChecker(fleet);
		assertEquals(1, returner);
			
	}
	
	
	@Test
	void testMultipleSimultaneousCollisions() {
		Player p = new Player();
		Fleet fleet = new Fleet();
		SpaceInvaderBullet collider = new SpaceInvaderBullet(200,70);
		SpaceInvaderBullet collider2 = new SpaceInvaderBullet(205, 70);
		fleet.getBullets().add(collider);
		fleet.getBullets().add(collider2);
		int returner = p.invaderBulletCollisionChecker(fleet);
		assertEquals(2, returner);
		
	}
	
	@Test
	void testScoreIncreaseWhenShootInvader() {
		Player p = new Player();
		p.didHitInvader();
		assertEquals(20, p.getScore());
	}
	
	@Test
	void testHealthDecreaseWhenHit() {
		Player p = new Player();
		p.isHit(1);
		assertEquals(80, p.getHealth());
	}

}