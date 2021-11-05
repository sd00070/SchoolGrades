package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Provides unit tests to verify the expected behavior of CompositeGrade's
 * addGrades varargs method.
 * 
 * @author Spencer Dent
 * @version 2021-11-05
 */
public class TestCompositeGradeAddGrades {

	private CompositeGrade testCompositeGrade;

	/**
	 * Creates fresh CompositeGrade before each test.
	 */
	@BeforeEach
	public void initBeforeEach() {
		this.testCompositeGrade = new CompositeGrade();
	}

	/**
	 * Verifies that it can add a single SimpleGrade.
	 */
	@Test
	public void testAppendsSimpleGrade() {
		this.testCompositeGrade.addGrades(new SimpleGrade(100.0));
		assertEquals(1, this.testCompositeGrade.getGrades().size());
	}

	/**
	 * Verifies that it can add a single CompositeGrade.
	 */
	@Test
	public void testAppendsCompositeGrade() {
		this.testCompositeGrade.addGrades(new CompositeGrade());
		assertEquals(1, this.testCompositeGrade.getGrades().size());
	}

	/**
	 * Verifies that it can add multiple SimpleGrades.
	 */
	@Test
	public void testAppendsMultipleSimpleGrades() {
		this.testCompositeGrade.addGrades(new SimpleGrade(100.0), new SimpleGrade(90.0), new SimpleGrade(80.0));
		assertEquals(3, this.testCompositeGrade.getGrades().size());
	}

	/**
	 * Verifies that it can add multiple CompositeGrades.
	 */
	@Test
	public void testAppendMultipleCompositeGrades() {
		this.testCompositeGrade.addGrades(new CompositeGrade(), new CompositeGrade(), new CompositeGrade());
		assertEquals(3, this.testCompositeGrade.getGrades().size());
	}

	/**
	 * Verifies that it can add multiple Grades of different types.
	 */
	@Test
	public void testAppendMultipleGradeTypes() {
		this.testCompositeGrade.addGrades(new SimpleGrade(100.0), new CompositeGrade(), new CompositeGrade(),
				new SimpleGrade(75.0));
		assertEquals(4, this.testCompositeGrade.getGrades().size());
	}

	/**
	 * Verifies that it throws an error if passed null.
	 */
	@Test
	public void testShouldThrowErrorWhenPassedNull() {
		assertThrows(IllegalArgumentException.class,
				() -> this.testCompositeGrade.addGrades(null, new SimpleGrade(100.0), new CompositeGrade()));
	}
}
