package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Provides unit tests to verify the expected behavior of WeightedGrade's
 * getValue method.
 * 
 * To be perfectly honest, I'm not precisely sure what needs to be done to get
 * the weighted value of a Grade. I'm assuming this is correct?
 * 
 * @author Spencer Dent
 * @version 2021-10-18
 */
public class TestWeightedGradeGetValue {

	/**
	 * Tests WeightedGrade when it's decorating a SimpleGrade
	 */
	@Test
	public void testGettingWeightedValueOfSimpleGrade() {
		WeightedGrade testWeightedGrade = new WeightedGrade(new SimpleGrade(100.0));
		testWeightedGrade.setWeight(0.5);

		assertEquals(50.0, testWeightedGrade.getValue());
	}

	/**
	 * Tests WeightedGrade when it's decorating a CompositeGrade with SimpleGrades
	 * in it.
	 */
	@Test
	public void testGettingWeightedValueOfCompositeGradeWithSimpleGrades() {
		CompositeGrade testCompositeGrade = new CompositeGrade();
		testCompositeGrade.addGrade(new SimpleGrade(100.0));
		testCompositeGrade.addGrade(new SimpleGrade(80.0));
		testCompositeGrade.addGrade(new SimpleGrade(60.0));
		
		WeightedGrade testWeightedGrade = new WeightedGrade(testCompositeGrade);
		testWeightedGrade.setWeight(0.25);
		
		assertEquals(20.0, testWeightedGrade.getValue());
	}

	/**
	 * No matter the weight, decorating an empty CompositeGrade should yield a value
	 * of 0.0
	 */
	@Test
	public void testWieghtedEmptyCompositeGradeShouldReturn0() {
		WeightedGrade testWeightedGrade = new WeightedGrade(new CompositeGrade());
		testWeightedGrade.setWeight(100.0);
		
		assertEquals(0.0, testWeightedGrade.getValue());
	}
}
