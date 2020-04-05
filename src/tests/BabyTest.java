package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.Baby;
import game.Dragon;
import game.Egg;

class BabyTest {

	@Test
	void creationTest() {
		Baby baby = new Baby();
		if (baby != null) {
			assertTrue(true,"Baby created");
		}
	}
	@Test
	void creationVariablesTest() {
		Baby baby = new Baby();
		assertEquals(baby.foodLevel, 0);
		assertEquals(baby.loveLevel, 0);
	}
	
	@Test
	void addOneFoodTest() {
		Baby baby = new Baby();
		baby.feed();
		assertEquals(baby.foodLevel, 1);
	}
	
	@Test
	void addFiveFoodTest() {
		Baby baby = new Baby();
		for (int i = 0; i < 5; ++i) {
		baby.feed();
		}
		assertEquals(baby.foodLevel, 5);
	}
	
	@Test
	void addSixFoodTest() {
		Baby baby = new Baby();
		for (int i = 0; i < 6; ++i) {
		baby.feed();
		}
		assertEquals(baby.foodLevel, 5);
	}
	
	@Test
	void addOneLoveTest() {
		Baby baby = new Baby();
		baby.pet();
		assertEquals(baby.loveLevel, 1);
	}
	
	@Test
	void addFiveLoveTest() {
		Baby baby = new Baby();
		for (int i = 0; i < 5; ++i) {
		baby.pet();
		}
		assertEquals(baby.loveLevel, 5);
	}
	@Test
	void addSixLoveTest() {
		Baby baby = new Baby();
		for (int i = 0; i < 6; ++i) {
		baby.pet();
		}
		assertEquals(baby.loveLevel, 5);
	}
	
	@Test
	void ageUpTest() {
		Baby baby = new Baby();
		for (int i = 0; i < 6; ++i) {
			baby.pet();
			baby.feed();
		}
		Dragon output = baby.ageUp();
		Dragon tester = new Adult();
		assertEquals(output, tester);
		
	}

}
