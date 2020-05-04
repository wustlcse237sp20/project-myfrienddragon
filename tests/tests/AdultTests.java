package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.Adult;
import game.Baby;
import game.Dragon;
import game.FoodInventory;

class AdultTests {

	@Test
	void creationTest() {
		FoodInventory foodInventory = new FoodInventory();
		Adult adult = new Adult(foodInventory);
		if (adult != null) {
			assertTrue(true,"Adult created");
		}
	}
	@Test
	void creationVariablesTest() {
		FoodInventory foodInventory = new FoodInventory();
		Adult adult = new Adult(foodInventory);
		assertEquals(adult.foodLevel, 0);
		assertEquals(adult.loveLevel, 0);
	}
	
	@Test
	void addOneFoodTest() {
		FoodInventory foodInventory = new FoodInventory();
		Adult adult = new Adult(foodInventory);
		adult.feed();
		assertEquals(adult.foodLevel, 20);
	}
	
	@Test
	void addFiveFoodTest() {
		FoodInventory foodInventory = new FoodInventory();
		Adult adult = new Adult(foodInventory);
		for (int i = 0; i < 5; ++i) {
		adult.feed();
		}
		assertEquals(adult.foodLevel, 100);
	}
	
	@Test
	void addSixFoodTest() {
		FoodInventory foodInventory = new FoodInventory();
		Adult adult = new Adult(foodInventory);
		for (int i = 0; i < 6; ++i) {
		adult.feed();
		}
		assertEquals(adult.foodLevel, 100);
	}
	
	@Test
	void addOneLoveTest() {
		FoodInventory foodInventory = new FoodInventory();
		Adult adult = new Adult(foodInventory);
		adult.pet();
		assertEquals(adult.loveLevel, 20);
	}
	
	@Test
	void addFiveLoveTest() {
		FoodInventory foodInventory = new FoodInventory();
		Adult adult = new Adult(foodInventory);
		for (int i = 0; i < 5; ++i) {
		adult.pet();
		}
		assertEquals(adult.loveLevel, 100);
	}
	@Test
	void addSixLoveTest() {
		FoodInventory foodInventory = new FoodInventory();
		Adult adult = new Adult(foodInventory);
		for (int i = 0; i < 6; ++i) {
		adult.pet();
		}
		assertEquals(adult.loveLevel, 100);
	}
	
	@Test
	void ageUpTest() {
		FoodInventory foodInventory = new FoodInventory();
		Adult adult = new Adult(foodInventory);
		for (int i = 0; i < 6; ++i) {
			adult.pet();
			adult.feed();
		}
		Dragon output = adult.ageUp();
		Dragon tester = new Adult(foodInventory);
		assertEquals(output, null);
		
	}

}
