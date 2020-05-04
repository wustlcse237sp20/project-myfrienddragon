package spaceinvaderstests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import SpaceInvaders.DragonBullet;
import SpaceInvaders.Invader;
import SpaceInvaders.DragonBulletCollection;

class InvaderTests {
	private Invader invader;
	
	@BeforeEach
	void setUpTestingObjects() {
		invader = new Invader(200, 200);
	}

	@Test
	void constructionTest() {
		if (invader != null) {
			assertTrue(true, "Invader created");
		}
		
	}
	@Test
	void testInitialVariables() {
		assertEquals(invader.getX(), 200);
		assertEquals(invader.getY(), 200);
		assertEquals(invader.isAlive(), true);
	}
	
	@Test
	void testHurt() {
		invader.hurt();
		assertEquals(invader.isAlive(), false);
	}
	
	@Test
	void testMove() {
		invader.move();
		assertEquals(invader.getY(), 155);
		assertEquals(invader.getHitBox().getBottomLeftX(), 175);
		assertEquals(invader.getHitBox().getTopLeftY(), 175.5);
		
	}
	@Test
	void testCollision() {
		DragonBullet bullet = new DragonBullet(200,200);
		DragonBulletCollection collection = new DragonBulletCollection();
		collection.addBullet(bullet);
		assertTrue(invader.isHit(collection));
	}
	
	@Test
	void testCornerCollision1() {
		DragonBullet bullet = new DragonBullet(190,200);
		DragonBulletCollection collection = new DragonBulletCollection();
		collection.addBullet(bullet);
		assertTrue(invader.isHit(collection));
	}
	
	@Test
	void testCornerCollision2() {
		DragonBullet bullet = new DragonBullet(210,200);
		DragonBulletCollection collection = new DragonBulletCollection();
		collection.addBullet(bullet);
		assertTrue(invader.isHit(collection));
	}
	@Test 
	void testCornerCollision3() {
		DragonBullet bullet = new DragonBullet(190,220);
		DragonBulletCollection collection = new DragonBulletCollection();
		collection.addBullet(bullet);
		assertTrue(invader.isHit(collection));
	}
	
	@Test
	void testMultipleSimultaneousCollisions() {
		DragonBullet bullet1 = new DragonBullet(190,220);
		DragonBullet bullet2 = new DragonBullet(200,205);
		DragonBulletCollection collection = new DragonBulletCollection();
		collection.addBullet(bullet1);
		collection.addBullet(bullet2);
		assertTrue(invader.isHit(collection));
	}
}
