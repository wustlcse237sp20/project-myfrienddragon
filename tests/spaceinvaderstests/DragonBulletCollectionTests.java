package spaceinvaderstests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import SpaceInvaders.DragonBullet;
import SpaceInvaders.DragonBulletCollection;

class DragonBulletCollectionTests {

	@Test
	void constructionTest() {
		DragonBulletCollection collection = new DragonBulletCollection();
		if (collection != null) {
			assertTrue(true, "Dragon bullet collection created");
		}
	}
	
	@Test
	void testInitialVariables() {
		DragonBulletCollection collection = new DragonBulletCollection();
		assertEquals(collection.getBullets().size(), 0);
	}
	
	@Test
	void testAddBullet() {
		DragonBulletCollection collection = new DragonBulletCollection();
		DragonBullet adder = new DragonBullet(200,200);
		collection.addBullet(adder);
		assertEquals(collection.getBullets().size(),1);
		
	}
	
	@Test
	void testRemoveBullet() {
		DragonBulletCollection collection = new DragonBulletCollection();
		DragonBullet adder = new DragonBullet(200,200);
		collection.addBullet(adder);
		collection.removeBullet(adder);
		assertEquals(collection.getBullets().size(),0);
		
	}
	
	@Test
	void testUpdate1() {
		DragonBulletCollection collection = new DragonBulletCollection();
		DragonBullet adder = new DragonBullet(200,200);
		collection.addBullet(adder);
		collection.update();
		assertEquals(collection.getBullets().size(),1);
		
	}
	
	@Test
	void testUpdate2() {
		DragonBulletCollection collection = new DragonBulletCollection();
		DragonBullet adder = new DragonBullet(200,200);
		collection.addBullet(adder);
		adder.hurt();
		collection.update();
		assertEquals(collection.getBullets().size(),0);
		
	}

}

