package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import SpaceInvaders.Fleet;
import SpaceInvaders.Invader;

class FleetTests {
	private Fleet fleet;
	
	@BeforeEach
	void setUpTestingObjects() {
		fleet = new Fleet();
	}
	
	@Test
	void testInvaderDestroyed() {
		Invader invader = fleet.getInvader(0);
		int initHealth = invader.getHealth();
		int damage = initHealth;
		invader.hurt(damage);
		
		fleet.removeDeadInvaders();
		
		assertEquals(fleet.getInvader(0), null); 
	}	

}
