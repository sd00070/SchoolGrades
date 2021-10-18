package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Provides unit tests to verify the expected behavior of WeightedGrade's
 * setWeight method.
 * 
 * @author Spencer Dent
 * @version 2021-10-18
 */
public class TestWeightedGradeSetWeight {

	private WeightedGrade testWeightedGrade;

	/**
	 * Initializes a fresh WeightedGrade object for each test.
	 */
	@BeforeEach
	public void beforeEachInit() {
		this.testWeightedGrade = new WeightedGrade(new SimpleGrade(100.0));
	}

	/**
	 * Tests the happy-path. Should set the WeightedGrade's weight to the value
	 * passed in.
	 */
	@Test
	public void testShouldSetWeightToGivenValue() {
		this.testWeightedGrade.setWeight(0.5);
		assertEquals(0.5, this.testWeightedGrade.getWeight());
	}

	/**
	 * SetWeigh should throw an IllegalArgumentException if given a number less than
	 * 0.
	 */
	@Test
	public void testShouldThrowIllegalArgumentExceptionIfArgumentIsNegative() {
		assertThrows(IllegalArgumentException.class, () -> this.testWeightedGrade.setWeight(-0.3));
	}
}
