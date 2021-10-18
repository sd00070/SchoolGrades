package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Provides unit tests to verify the expected behavior of the WeightedGrade
 * constructor.
 * 
 * @author Spencer Dent
 * @version 2021-10-18
 */
public class TestWeightedGradeConstructor {

	/**
	 * Constructor should set passed Grade to be the Grade being decorated.
	 */
	@Test
	public void testShouldSetGradeToGivenGrade() {
		Grade testGrade = new SimpleGrade(100.0);

		WeightedGrade testWeightedGrade = new WeightedGrade(testGrade);

		assertEquals(testGrade, testWeightedGrade.getGrade());
	}

	/**
	 * Constructor should throw an IllegalArgumentException if passed null instead
	 * of a Grade.
	 */
	@Test
	public void testShouldThrowIllegalArgumentExcpetionWhenPassedNull() {
		assertThrows(IllegalArgumentException.class, () -> new WeightedGrade(null));
	}

	/**
	 * Constructor should initialize weight to be 1.0
	 */
	@Test
	public void testShouldInitializeWeightToBe1() {
		assertEquals(1.0, new WeightedGrade(new SimpleGrade(1.0)).getWeight());
	}
}
