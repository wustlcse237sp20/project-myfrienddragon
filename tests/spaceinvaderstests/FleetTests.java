package spaceinvaderstests;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import SpaceInvaders.Fleet;
import SpaceInvaders.Invader;
import SpaceInvaders.SpaceInvaderBullet;
import SpaceInvaders.DragonBulletCollection;

class FleetTests {
	private Fleet fleet;
	private ArrayList<Invader> invaders;
	private ArrayList<SpaceInvaderBullet> bullets;
	
	@BeforeEach
	void setUpTestingObjects() {
		fleet = new Fleet();
		invaders = fleet.getInvaders();
		bullets = fleet.getBullets();
	}
	
	@Test
	void testFleetConstruction() {
		if (fleet != null) {
			assertTrue(true, "Fleet created");
		}
	}
	@Test
	void testInitialVars() {
		assertEquals(bullets.size(), 0);
		assertEquals(bullets.size(), 0);
		
	}
	
	@Test
	void testSpawnInvaders() {
		fleet.spawnInvaders();
		assertEquals(invaders.size(), 8);
		
	}
	
	@Test
	void shootBulletTest() {
		fleet.spawnInvaders();
		fleet.shootBullets();
		assertEquals(bullets.size(),1);
	}
	@Test
	void testInvaderUpdateRemoval() {
		fleet.spawnInvaders();
		int frame = 0;
		Invader invader = fleet.getInvader(0);
		DragonBulletCollection collection = new DragonBulletCollection();
		invader.hurt();
		fleet.update(collection,frame);
		assertEquals(invaders.size(), 8); 
	}
	
	@Test
	void testLivingInvaderUpdate() {
		fleet.spawnInvaders();
		int frame = 0;
		DragonBulletCollection collection = new DragonBulletCollection();
		fleet.update(collection, frame);
		assertEquals(invaders.size(), 9); 
	}
	
	
	@Test
	void testBulletUpdateRemoval() {
		fleet.addRowOfInvaders();
		fleet.shootBullets();
		System.out.println(bullets.size());
		SpaceInvaderBullet bullet = bullets.get(0);
		DragonBulletCollection collection = new DragonBulletCollection();
		bullet.hurt();
		int frame = 0;
		fleet.update(collection, frame);
		assertEquals(bullets.size(), 0); 
	
		
	}
	
	@Test 
	void testLivingBulletUpdate() {
		Fleet fleet = new Fleet();
		fleet.addRowOfInvaders();
		fleet.shootBullets();
		DragonBulletCollection collection = new DragonBulletCollection();
		int frame = 0;
		fleet.update(collection,frame);
		assertEquals(bullets.size(), 1); 
	}
	

	
}