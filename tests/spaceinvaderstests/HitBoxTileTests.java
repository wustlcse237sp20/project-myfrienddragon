package spaceinvaderstests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import SpaceInvaders.HitBoxTile;

class HitBoxTileTests {

	@Test
	void constructionTest() {
		HitBoxTile hitbox = new HitBoxTile(200,200,20,20);
		if (hitbox !=null) {
			assertTrue(true, "Hitbox created");
		}
		
		
	}
	@Test
	void testInitialVariables() {
		HitBoxTile hitbox = new HitBoxTile(200,200,20,20);
		assertEquals(hitbox.getBottomLeftX(), 190);
		assertEquals(hitbox.getBottomRightX(), 210);
		assertEquals(hitbox.getBottomLeftY(), 190);
		assertEquals(hitbox.getTopLeftY(), 210);
		
	}
	@Test
	void testCollision1() {
		HitBoxTile hitbox = new HitBoxTile(200,200,20,20);
		HitBoxTile hitbox2 = new HitBoxTile(200,200,20,20);
		boolean returner = hitbox.isColliding(hitbox2);
		assertEquals(returner, true);
		
	}
	
	@Test
	void testCorner1Collision() {
		HitBoxTile hitbox = new HitBoxTile(200,200,20,20);
		HitBoxTile hitbox2 = new HitBoxTile(180,200,20,20);
		boolean returner = hitbox.isColliding(hitbox2);
		assertEquals(returner, true);
		
	}
	
	@Test 
	void testCorner2Collision() {
		HitBoxTile hitbox = new HitBoxTile(200,200,20,20);
		HitBoxTile hitbox2 = new HitBoxTile(215,200,20,20);
		boolean returner = hitbox.isColliding(hitbox2);
		assertEquals(returner, true);
	}
	
	@Test
	void testCorner3Collision() {
		HitBoxTile hitbox = new HitBoxTile(200,200,20,20);
		HitBoxTile hitbox2 = new HitBoxTile(190,220,20,20);
		boolean returner = hitbox.isColliding(hitbox2);
		assertEquals(returner, true);
		
	}
	@Test
	void testCorner4Collision() {
		HitBoxTile hitbox = new HitBoxTile(200,200,20,20);
		HitBoxTile hitbox2 = new HitBoxTile(215,215,20,20);
		boolean returner = hitbox.isColliding(hitbox2);
		assertEquals(returner, true);
		
	}
	@Test
	void testMultipleSimultaneousCollisions() {
		HitBoxTile hitbox = new HitBoxTile(200,200,20,20);
		HitBoxTile hitbox2 = new HitBoxTile(190,220,20,20);
		HitBoxTile hitbox3 = new HitBoxTile(220,200,10,10);
		boolean returner = hitbox.isColliding(hitbox2);
		boolean returner2 = hitbox.isColliding(hitbox3);
		assertEquals(returner, true);
		assertEquals(returner2, true);
		
	}

}