package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.princeton.cs.introcs.StdDraw;
import game.Baby;
import game.Dragon;
import game.Egg;

class EggTest {

	@Test
	void creationTest() {
		Egg egg = new Egg();
		if (egg != null) {
			assertTrue(true,"Egg created");
		}
	}
	@Test
	void creationVariablesTest() {
		Egg egg = new Egg();
		assertEquals(egg.foodLevel, 0);
		assertEquals(egg.loveLevel, 0);
	}
	
	@Test
	void addOneFoodTest() {
		Egg egg = new Egg();
		egg.feed();
		assertEquals(egg.foodLevel, 1);
	}
	
	@Test
	void addFiveFoodTest() {
		Egg egg = new Egg();
		for (int i = 0; i < 5; ++i) {
		egg.feed();
		}
		assertEquals(egg.foodLevel, 5);
	}
	
	@Test
	void addSixFoodTest() {
		Egg egg = new Egg();
		for (int i = 0; i < 6; ++i) {
		egg.feed();
		}
		assertEquals(egg.foodLevel, 5);
	}
	
	@Test
	void addOneLoveTest() {
		Egg egg = new Egg();
		egg.pet();
		assertEquals(egg.loveLevel, 1);
	}
	
	@Test
	void addFiveLoveTest() {
		Egg egg = new Egg();
		for (int i = 0; i < 5; ++i) {
		egg.pet();
		}
		assertEquals(egg.loveLevel, 5);
	}
	@Test
	void addSixLoveTest() {
		Egg egg = new Egg();
		for (int i = 0; i < 6; ++i) {
		egg.pet();
		}
		assertEquals(egg.loveLevel, 5);
	}
	
	@Test
	void ageUpTest() {
		Egg egg = new Egg();
		for (int i = 0; i < 6; ++i) {
			egg.pet();
			egg.feed();
		}
		Dragon output = egg.ageUp();
		Dragon tester = new Baby();
		assertEquals(output, tester);
		
	}
	

	

}
