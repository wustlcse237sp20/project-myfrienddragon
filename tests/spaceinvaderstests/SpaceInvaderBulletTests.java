package spaceinvaderstests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import SpaceInvaders.SpaceInvaderBullet;

class SpaceInvaderBulletTests {

	@Test
	void constructionTest() {
		SpaceInvaderBullet bullet = new SpaceInvaderBullet(200,200);
		if (bullet!=null) {
			assertTrue(true, "Space Invader Bullet created");
		}

	}
	@Test
	void testInitialVariables() {
		SpaceInvaderBullet bullet = new SpaceInvaderBullet(200,200);
		assertEquals(bullet.getX(), 200);
		assertEquals(bullet.getY(),200);
		assertEquals(bullet.getOnScreen(), true);
		
	}
	
	@Test
	void testUpdate1() {
		SpaceInvaderBullet bullet = new SpaceInvaderBullet(200,200);
		bullet.update();
		assertEquals(bullet.getY(), 175);
		assertEquals(bullet.getHitBoxBottomLeftX(), 189);
		assertEquals(bullet.getHitBoxTopLeftY(), 188 );
		
	}
	
	@Test
	void testUpdate2() {
		SpaceInvaderBullet bullet = new SpaceInvaderBullet(200,-10);
		bullet.update();
		assertEquals(bullet.getOnScreen(), false);
		
	}
	@Test
	void testMove() {
		SpaceInvaderBullet bullet = new SpaceInvaderBullet(200,200);
		bullet.move();
		assertEquals(bullet.getY(), 175);
		
	}
	
	@Test
	void testHurt() {
		SpaceInvaderBullet bullet = new SpaceInvaderBullet(200,200);
		bullet.hurt();
		assertEquals(bullet.getOnScreen(), false);
	}
	

}