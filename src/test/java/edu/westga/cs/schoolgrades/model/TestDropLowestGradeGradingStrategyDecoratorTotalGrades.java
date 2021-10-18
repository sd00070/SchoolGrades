package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Provides unit tests to verify the expected behavior of
 * DropLowestGradeGradingStrategyDecorator's totalGrades method.
 * 
 * @author Spencer Dent
 * @version 2021-10-18
 */
public class TestDropLowestGradeGradingStrategyDecoratorTotalGrades {

	/**
	 * If the list of Grades is null, it should return 0.0
	 */
	@Test
	public void testShouldReturn0IfGradesListIsNull() {
		assertEquals(0.0, new DropLowestGradeGradingStrategyDecorator(new SumGradingStrategy()).totalGrades(null));
		assertEquals(0.0, new DropLowestGradeGradingStrategyDecorator(new MeanGradingStrategy()).totalGrades(null));
	}

	/**
	 * If the Decorated Decorated CompositeGrade is empty, it should return 0.0
	 */
	@Test
	public void testShouldReturn0IfCompositeGradeIsEmpty() {
		assertEquals(0.0,
				new CompositeGrade(new DropLowestGradeGradingStrategyDecorator(new SumGradingStrategy())).getValue());
		assertEquals(0.0,
				new CompositeGrade(new DropLowestGradeGradingStrategyDecorator(new MeanGradingStrategy())).getValue());
	}

	/**
	 * It should drop the lowest grade before calculating the Grade total.
	 */
	@Test
	public void testShouldDropLowestGradeBeforeTotalingGradeValues() {
		CompositeGrade testCompositeGrade = new CompositeGrade();
		testCompositeGrade.addGrade(new SimpleGrade(100.0));
		testCompositeGrade.addGrade(new SimpleGrade(90.0));
		testCompositeGrade.addGrade(new SimpleGrade(80.0));
		
		testCompositeGrade.setGradingStrategy(new DropLowestGradeGradingStrategyDecorator(new SumGradingStrategy()));
		assertEquals(190.0, testCompositeGrade.getValue());
		
		testCompositeGrade.setGradingStrategy(new DropLowestGradeGradingStrategyDecorator(new MeanGradingStrategy()));
		assertEquals(95.0, testCompositeGrade.getValue());
	}
}
