package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Provides tests to verify the expected behavior of CompositeGrade's
 * setGradingStrategy method.
 * 
 * @author Spencer Dent
 * @version 2021-10-18
 */
public class TestCompositeGradeSetGradingStrategy {

	private CompositeGrade testCompositeGrade;

	/**
	 * Creates a fresh CompositeGrade to work with for each test.
	 */
	@BeforeEach
	public void beforeEachInit() {
		this.testCompositeGrade = new CompositeGrade();
	}

	/**
	 * Tests the happy path, making sure that it sets the GradingStrategy to the
	 * correct Strategy.
	 */
	@Test
	public void testShouldSetSelectedGradingStrategyToGivenGradingStrategy() {
		this.testCompositeGrade.setGradingStrategy(new SumGradingStrategy());
		assertEquals(SumGradingStrategy.class, this.testCompositeGrade.getGradingStrategy().getClass());

		this.testCompositeGrade.setGradingStrategy(new MeanGradingStrategy());
		assertEquals(MeanGradingStrategy.class, this.testCompositeGrade.getGradingStrategy().getClass());
	}

	/**
	 * SetGradingStrategy should throw an IllegalArgumentException if passed null.
	 */
	@Test
	public void testShouldThrowIllegalArgumentExceptionIfPassedNull() {
		assertThrows(IllegalArgumentException.class, () -> this.testCompositeGrade.setGradingStrategy(null));
	}
}
