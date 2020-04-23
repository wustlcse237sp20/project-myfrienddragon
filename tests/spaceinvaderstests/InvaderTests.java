package spaceinvaderstests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import SpaceInvaders.DragonBullet;
import SpaceInvaders.Fleet;
import SpaceInvaders.Invader;
import SpaceInvaders.Player;
import SpaceInvaders.SpaceInvaderBullet;
import SpaceInvaders.DragonBulletCollection;

class InvaderTests {

	@Test
	void constructionTest() {
		Invader ship = new Invader(200,200);
		if (ship!=null) {
			assertTrue(true, "Invader created");
		}
		
	}
	@Test
	void testInitialVariables() {
		Invader ship = new Invader(200,200);
		assertEquals(ship.getHealth(),1);
		assertEquals(ship.getX(), 200);
		assertEquals(ship.getY(), 200);
		assertEquals(ship.isAlive(), true);
	}
	
	@Test
	void testHurt() {
		Invader ship = new Invader(200,200);
		ship.hurt();
		assertEquals(ship.isAlive(), false);
	}
	
	@Test
	void testMove() {
		Invader ship = new Invader(200,200);
		ship.move();
		assertEquals(ship.getY(), 155);
		assertEquals(ship.getHitBox().getBottomLeftX(), 175);
		assertEquals(ship.getHitBox().getTopLeftY(), 175.5);
		
	}
	@Test
	void testCollision1() {
		Invader p = new Invader(200,200);
		Fleet fleet = new Fleet();
		fleet.invaders.add(p);
		DragonBullet collider = new DragonBullet(200,200);
		DragonBulletCollection collection = new DragonBulletCollection();
		collection.addBullet(collider);
		p.checkCollision(collection);
		assertEquals(p.isAlive(),false);
			
	}
	
	@Test
	void testCornerCollision1() {
		Invader p = new Invader(200,200);
		Fleet fleet = new Fleet();
		fleet.invaders.add(p);
		DragonBullet collider = new DragonBullet(190,200);
		DragonBulletCollection collection = new DragonBulletCollection();
		collection.addBullet(collider);
		p.checkCollision(collection);
		assertEquals(p.isAlive(),false);
			
	}
	
	@Test
	void testCornerCollision2() {
		Invader p = new Invader(200,200);
		Fleet fleet = new Fleet();
		fleet.invaders.add(p);
		DragonBullet collider = new DragonBullet(210,200);
		DragonBulletCollection collection = new DragonBulletCollection();
		collection.addBullet(collider);
		p.checkCollision(collection);
		assertEquals(p.isAlive(),false);
			
	}
	@Test 
	void testCornerCollision3() {
		Invader p = new Invader(200,200);
		Fleet fleet = new Fleet();
		fleet.invaders.add(p);
		DragonBullet collider = new DragonBullet(190,220);
		DragonBulletCollection collection = new DragonBulletCollection();
		collection.addBullet(collider);
		p.checkCollision(collection);
		assertEquals(p.isAlive(),false);
	}
	
	@Test
	void testMultipleSimultaneousCollisions() {
		Invader p = new Invader(200,200);
		Fleet fleet = new Fleet();
		fleet.invaders.add(p);
		DragonBullet collider = new DragonBullet(190,220);
		DragonBullet collider2 = new DragonBullet(200,205);
		DragonBulletCollection collection = new DragonBulletCollection();
		collection.addBullet(collider);
		collection.addBullet(collider2);
		p.checkCollision(collection);
		assertEquals(p.isAlive(),false);
		
	}
}
