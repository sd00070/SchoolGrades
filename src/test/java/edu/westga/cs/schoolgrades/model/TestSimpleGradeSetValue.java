package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Provides tests to verify the expected behavior of SimpleGrade's setValue
 * method.
 * 
 * @author Spencer Dent
 * @version 2021-10-18
 */
public class TestSimpleGradeSetValue {

	private SimpleGrade testSimpleGrade;

	/**
	 * Creates a fresh SimpleGrade before each test.
	 */
	@BeforeEach
	public void beforeEachInit() {
		this.testSimpleGrade = new SimpleGrade(100.0);
	}

	/**
	 * Tests to make sure that the method properly sets the value of the grade. This
	 * is the happy-path test.
	 */
	@Test
	public void testShouldSetSimpleGradeValueToGivenValue() {
		this.testSimpleGrade.setValue(89.3);
		assertEquals(89.3, this.testSimpleGrade.getValue());
	}

	/**
	 * SetValue should throw an IllegalArgumentException if passed a negative
	 * number.
	 */
	@Test
	public void testShouldThrowIllegalArgumentExceptionIfArgumentLessThan0() {
		assertThrows(IllegalArgumentException.class, () -> this.testSimpleGrade.setValue(-20.0));
	}
}
