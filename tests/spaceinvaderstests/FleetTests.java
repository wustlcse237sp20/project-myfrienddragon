package spaceinvaderstests;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.annotation.ElementType;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import SpaceInvaders.Fleet;
import SpaceInvaders.Invader;
import SpaceInvaders.SpaceInvaderBullet;
import SpaceInvaders.DragonBulletCollection;

class FleetTests {
	private Fleet fleet;
	
	@BeforeEach
	void setUpTestingObjects() {
		fleet = new Fleet();
	}
	
	@Test
	void testFleetConstruction() {
		if (fleet != null) {
			assertTrue(true, "Fleet created");
		}
	}
	@Test
	void testInitialVars() {
		assertEquals(fleet.getBullets().size(), 0);
		assertEquals(fleet.getBullets().size(), 0);
		
	}
	
	@Test
	void testSpawnInvaders() {
		fleet.spawnInvaders();
		assertEquals(fleet.getBullets().size(), 9);
		
	}
	
	@Test
	void shootBulletTest() {
		fleet.spawnInvaders();
		fleet.shootBullets();
		assertEquals(fleet.getBullets().size(),1);
	}
	@Test
	void testInvaderUpdateRemoval() {
		fleet.spawnInvaders();
		Invader invader = fleet.getInvader(0);
		DragonBulletCollection collection = new DragonBulletCollection();
		invader.hurt();
		fleet.update(collection);
		assertEquals(fleet.invaders.size(), 8); 
	}
	
	@Test
	void testLivingInvaderUpdate() {
		fleet.spawnInvaders();
		DragonBulletCollection collection = new DragonBulletCollection();
		fleet.update(collection);
		assertEquals(fleet.invaders.size(), 9); 
	}
	
	
	@Test
	void testBulletUpdateRemoval() {
		fleet.shootBullets();
		SpaceInvaderBullet bullet = fleet.bullets.get(0);
		DragonBulletCollection collection = new DragonBulletCollection();
		bullet.hurt();
		fleet.update(collection);
		assertEquals(fleet.bullets.size(), 0); 
	
		
	}
	
	@Test 
	void testLivingBulletUpdate() {
		fleet.shootBullets();
		SpaceInvaderBullet bullet = fleet.bullets.get(0);
		DragonBulletCollection collection = new DragonBulletCollection();
		fleet.update(collection);
		assertEquals(fleet.bullets.size(), 1); 
	}
	

	
}
