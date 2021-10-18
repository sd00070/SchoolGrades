package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Tests SimpleGrade's constructor.
 * 
 * @author Spencer Dent
 * @version 2021-10-17
 */
public class TestSimpleGradeConstructor {

	/**
	 * Tests the happy path of the constructor
	 */
	@Test
	public void testShouldCreateGradeWithGivenValue() {
		Grade testSimpleGrade = new SimpleGrade(84.0);
		assertEquals(84.0, testSimpleGrade.getValue());
		
		testSimpleGrade = new SimpleGrade(100.0);
		assertEquals(100.0, testSimpleGrade.getValue());
		
		testSimpleGrade = new SimpleGrade(93.0);
		assertEquals(93.0, testSimpleGrade.getValue());
		
		testSimpleGrade = new SimpleGrade(77.0);
		assertEquals(77.0, testSimpleGrade.getValue());
	}

	/**
	 * Tests to make sure the constructor throws the right error if given a value
	 * less than 0.0
	 */
	@Test
	public void testShouldThrowErrorIfGivenValueIsLessThan0() {
		assertThrows(IllegalArgumentException.class, () -> new SimpleGrade(-2.0));
		
		assertThrows(IllegalArgumentException.class, () -> new SimpleGrade(-100.0));
		
		assertThrows(IllegalArgumentException.class, () -> new SimpleGrade(-76.0));
	}
}
