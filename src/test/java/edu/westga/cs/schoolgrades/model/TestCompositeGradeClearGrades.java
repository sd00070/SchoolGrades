package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Provides unit tests to verify the expected behavior of CompositeGrade's
 * clearGrades method.
 * 
 * @author Spencer Dent
 * @version 2021-11-05
 */
public class TestCompositeGradeClearGrades {

	private CompositeGrade testCompositeGrade;

	/**
	 * Creates a fresh CompositeGrade before each test.
	 */
	@BeforeEach
	public void initBeforeEach() {
		this.testCompositeGrade = new CompositeGrade();
	}

	/**
	 * Tests to make sure calling it on an empty CompositeGrade does not cuase
	 * issues.
	 */
	@Test
	public void testRemovesAllGradesOfEmptyCompositeGrade() {
		this.testCompositeGrade.clearGrades();

		assertTrue(this.testCompositeGrade.getGrades().isEmpty());
	}

	/**
	 * Tests that it properly clears a CompositeGrade with only one Grade.
	 */
	@Test
	public void testRemovesAllGradesFromCompositeGradeOfOneGrade() {
		this.testCompositeGrade.addGrade(new SimpleGrade(100.0));

		this.testCompositeGrade.clearGrades();

		assertTrue(this.testCompositeGrade.getGrades().isEmpty());
	}

	/**
	 * Tests that it properly empties a CompositeGrade containing multiple Grades.
	 */
	@Test
	public void testRemovesAllGradesFromCompositeGradeWithMultipleGrades() {
		this.testCompositeGrade.addGrade(new SimpleGrade(100.0));
		this.testCompositeGrade.addGrade(new SimpleGrade(90.0));
		this.testCompositeGrade.addGrade(new SimpleGrade(80.0));

		this.testCompositeGrade.clearGrades();

		assertTrue(this.testCompositeGrade.getGrades().isEmpty());
	}
}
