package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Provides tests to verify the expected behavior of the CompositeGrade's
 * Constructor.
 * 
 * @author Spencer Dent
 * @version 2021-10-18
 */
public class TestCompositeGradeConstructor {

	/**
	 * The list of Grades in the CompositeGrade should initialize to an empty list.
	 */
	@Test
	public void testShouldCreateCompositeGradeWithEmptyListOfGrades() {
		assertTrue((new CompositeGrade()).getGrades().isEmpty());
	}

	/**
	 * Constructor should throw an illegal argument exception if null is passed-in
	 * rather than a GradingStrategy.
	 */
	@Test
	public void testShouldThrowErrorIfPassedNull() {
		assertThrows(IllegalArgumentException.class, () -> new CompositeGrade(null));
	}

	/**
	 * Constructing a new CompositeGrade without passing in a GradingStrategy should
	 * default to MeanGradingStrategy.
	 */
	@Test
	public void testShouldUseMeanGradingStrategyIfNoStrategyPassedIn() {
		assertEquals(MeanGradingStrategy.class, new CompositeGrade().getGradingStrategy().getClass());
	}

	/**
	 * Passing in a GradingStrategy should set the CompositeGrade's selected
	 * GradingStrategy.
	 */
	@Test
	public void testShouldSetGradingStrategyToPassedValue() {
		assertEquals(SumGradingStrategy.class, new CompositeGrade(new SumGradingStrategy()).getGradingStrategy().getClass());
		assertEquals(MeanGradingStrategy.class, new CompositeGrade(new MeanGradingStrategy()).getGradingStrategy().getClass());
	}
}
