package spaceinvaderstests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import SpaceInvaders.DragonBullet;

class DragonBulletTests {

	@Test
	void constructionTest() {
		DragonBullet bullet = new DragonBullet(200,200);
		if (bullet !=null) {
			assertTrue(true, "Dragon bullet created");
		}
		
	}
	@Test
	void testInitialVars() {
		DragonBullet bullet = new DragonBullet(200,200);
		assertEquals(bullet.getOnScreen(), true);
		assertEquals(bullet.getX(), 200);
		assertEquals(bullet.getY(),200);
		
	}
	
	@Test
	void testMove() {
		DragonBullet bullet = new DragonBullet(200,200);
		bullet.move();
		assertEquals(bullet.getY(), 225);
	}
	@Test
	void testUpdate1() {
		DragonBullet bullet = new DragonBullet(410,410);
		bullet.update();
		assertEquals(bullet.getOnScreen(), false);
	}
	
	@Test
	void testUpdate2() {
		DragonBullet bullet = new DragonBullet(200,200);
		bullet.update();
		assertEquals(bullet.getOnScreen(),true);
		assertEquals(bullet.getY(), 225);
	}
	
	@Test
	void testHurt() {
		DragonBullet bullet = new DragonBullet(200,200);
		bullet.hurt();
		assertEquals(bullet.getOnScreen(), false);
	}

}
