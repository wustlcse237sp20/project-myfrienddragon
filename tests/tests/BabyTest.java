package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.Adult;
import game.Baby;
import game.Dragon;
import game.Egg;
import game.FoodInventory;

class BabyTest {

	@Test
	void creationTest() {
		FoodInventory foodInventory = new FoodInventory();
		Baby baby = new Baby(foodInventory);
		if (baby != null) {
			assertTrue(true,"Baby created");
		}
	}
	@Test
	void creationVariablesTest() {
		FoodInventory foodInventory = new FoodInventory();
		Baby baby = new Baby(foodInventory);
		assertEquals(baby.foodLevel, 0);
		assertEquals(baby.loveLevel, 0);
	}
	
	@Test
	void addOneFoodTest() {
		FoodInventory foodInventory = new FoodInventory();
		Baby baby = new Baby(foodInventory);
		baby.feed();
		assertEquals(baby.foodLevel, 20);
	}
	
	@Test
	void addFiveFoodTest() {
		FoodInventory foodInventory = new FoodInventory();
		Baby baby = new Baby(foodInventory);
		for (int i = 0; i < 5; ++i) {
		baby.feed();
		}
		assertEquals(baby.foodLevel, 100);
	}
	
	@Test
	void addSixFoodTest() {
		FoodInventory foodInventory = new FoodInventory();
		Baby baby = new Baby(foodInventory);
		for (int i = 0; i < 6; ++i) {
		baby.feed();
		}
		assertEquals(baby.foodLevel, 100);
	}
	
	@Test
	void addOneLoveTest() {
		FoodInventory foodInventory = new FoodInventory();
		Baby baby = new Baby(foodInventory);
		baby.pet();
		assertEquals(baby.loveLevel, 20);
	}
	
	@Test
	void addFiveLoveTest() {
		FoodInventory foodInventory = new FoodInventory();
		Baby baby = new Baby(foodInventory);
		for (int i = 0; i < 5; ++i) {
		baby.pet();
		}
		assertEquals(baby.loveLevel, 100);
	}
	@Test
	void addSixLoveTest() {
		FoodInventory foodInventory = new FoodInventory();
		Baby baby = new Baby(foodInventory);
		for (int i = 0; i < 6; ++i) {
		baby.pet();
		}
		assertEquals(baby.loveLevel, 100);
	}
	
	@Test
	void ageUpTest() {
		FoodInventory foodInventory = new FoodInventory();
		Baby baby = new Baby(foodInventory);
		for (int i = 0; i < 6; ++i) {
			baby.pet();
			baby.feed();
		}
		Dragon output = baby.ageUp();
		Dragon tester = new Adult(foodInventory);
		assertEquals(output.equals(tester), true);
		
	}

}
