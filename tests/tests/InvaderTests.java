package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import SpaceInvaders.Invader;

class InvaderTests {
	private Invader invader; 
	
	@BeforeEach 
	void setUpTestingObjects() {
		invader = new Invader(200, 200);
	}
	
	@Test
	void testInitialization() {
		assertEquals(invader.getX(), 200);
		assertEquals(invader.getY(), 200);
	}

	@Test
	void testDamage() {
		int initHealth = invader.getHealth();
		int damage = 300;
		
		invader.hurt(damage);
		
		assertEquals(invader.getHealth(), initHealth - damage);
	}
	
	@Test
	void testDamageEqualToHealth() {
		int initHealth = invader.getHealth();
		int damage = initHealth;
		
		invader.hurt(damage);
		
		assertEquals(invader.getHealth(), 0);
	}
	
	@Test 
	void testDamageGreaterThanHealth() {
		int initHealth = invader.getHealth();
		int damage = 1 + initHealth;
		
		invader.hurt(damage);
		
		assertEquals(invader.getHealth(), 0);
	}
}
