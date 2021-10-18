package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Provides unit tests to verify the expected behavior of
 * DropLowestGradeGradingStrategyDecorator's constructor.
 * 
 * @author Spencer Dent
 * @version 2021-10-18
 */
public class TestDropLowestGradeGradingStrategyDecoratorConstructor {

	/**
	 * Happy path test - makes sure that the constructor properly sets the
	 * GradingStrategy to the one that was passed in.
	 */
	@Test
	public void testShouldSetGradingStrategyToGivenGradingStrategy() {
		GradingStrategy testGradingStrategy = new SumGradingStrategy();
		DropLowestGradeGradingStrategyDecorator testDecorator = new DropLowestGradeGradingStrategyDecorator(
				testGradingStrategy);
		assertEquals(testGradingStrategy, testDecorator.getGradingStrategy());

		testGradingStrategy = new MeanGradingStrategy();
		testDecorator = new DropLowestGradeGradingStrategyDecorator(testGradingStrategy);
		assertEquals(testGradingStrategy, testDecorator.getGradingStrategy());
	}

	/**
	 * Should throw an IllegalArgumentException if passed null instead of a
	 * GradingStrategy.
	 */
	@Test
	public void testShouldThrowIllegalArgumentExceptionWhenGradingStrategyIsNull() {
		assertThrows(IllegalArgumentException.class, () -> new DropLowestGradeGradingStrategyDecorator(null));
	}
}
