package spaceinvaderstests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import SpaceInvaders.Fleet;
import SpaceInvaders.Player;
import SpaceInvaders.SpaceInvaderBullet;
import SpaceInvaders.DragonBulletCollection;
import edu.princeton.cs.introcs.StdDraw;
import game.Egg;

class PlayerTests {

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
		Player p = new Player();
		DragonBulletCollection collection = new DragonBulletCollection();
		p.interpretKeyPressed('a', collection);
		assertEquals(p.getX(), 190);
		
	}
	@Test
	void testMoveRight() {
		Player p = new Player();
		DragonBulletCollection collection = new DragonBulletCollection();
		p.interpretKeyPressed('d', collection);
		assertEquals(p.getX(), 210);
		
	}
	
	@Test
	void testDragonCantGoRightOffBoard() {
		Player p = new Player();
		DragonBulletCollection collection = new DragonBulletCollection();
		for (int i = 0; i < 20; i++) {
			p.interpretKeyPressed('a', collection);
		}
		assertEquals(0, p.getX());
	}
	
	@Test
	void testDragonCantGoLeftOffBoard() {
		Player p = new Player();
		DragonBulletCollection collection = new DragonBulletCollection();
		for (int i = 0; i < 20; i++) {
			p.interpretKeyPressed('d', collection);
		}
		assertEquals(400, p.getX());
	}
	
	@Test
	void testShootInControls() {
		Player p = new Player();
		DragonBulletCollection collection = new DragonBulletCollection();
		p.interpretKeyPressed('x', collection);
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
		SpaceInvaderBullet collider = new SpaceInvaderBullet(200,25);
		fleet.getBullets().add(collider);
		int returner = p.invaderBulletCollisionChecker(fleet);
		assertEquals(1, returner);
			
	}
	
	@Test
	void testCornerCollision1() {
		Player p = new Player();
		Fleet fleet = new Fleet();
		SpaceInvaderBullet collider = new SpaceInvaderBullet(190,15);
		fleet.getBullets().add(collider);
		int returner = p.invaderBulletCollisionChecker(fleet);
		assertEquals(1, returner);
			
	}
	
	@Test
	void testCornerCollision2() {
		Player p = new Player();
		Fleet fleet = new Fleet();
		SpaceInvaderBullet collider = new SpaceInvaderBullet(210,20);
		fleet.getBullets().add(collider);
		int returner = p.invaderBulletCollisionChecker(fleet);
		assertEquals(1, returner);
			
	}
	@Test 
	void testCornerCollision3() {
		Player p = new Player();
		Fleet fleet = new Fleet();
		SpaceInvaderBullet collider = new SpaceInvaderBullet(190,50);
		fleet.getBullets().add(collider);
		int returner = p.invaderBulletCollisionChecker(fleet);
		assertEquals(1, returner);	
	}
	
	@Test
	void testMultipleSimultaneousCollisions() {
		Player p = new Player();
		Fleet fleet = new Fleet();
		SpaceInvaderBullet collider = new SpaceInvaderBullet(200,25);
		SpaceInvaderBullet collider2 = new SpaceInvaderBullet(205,25);
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
		assertEquals(90, p.getHealth());
	}

}
