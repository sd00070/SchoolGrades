package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests CompositeGrade's getValue method and its various GradingStrategies.
 * 
 * @author Spencer Dent
 * @version 2021-10-18
 */
public class TestCompositeGradeGetValue {

	private CompositeGrade testCompositeGrade;

	/**
	 * Creates a fresh CompositeGrade before each test.
	 */
	@BeforeEach
	public void beforeEachInit() {
		this.testCompositeGrade = new CompositeGrade();
	}

	/**
	 * No matter the GradingStrategy, if the CompositeGrade contains no Grades, its
	 * value should be 0.0
	 */
	@Test
	public void testShouldReturn0WhenNoGradesInCompositeGrade() {
		assertEquals(0.0, this.testCompositeGrade.getValue());

		this.testCompositeGrade = new CompositeGrade(new SumGradingStrategy());
		assertEquals(0.0, this.testCompositeGrade.getValue());
	}

	/**
	 * Tests CompositeGrade's getValue method when it's currently using the mean
	 * (average) strategy to obtain a single value.
	 */
	@Test
	public void testGetValueUsingAveragingStrategy() {
		this.testCompositeGrade.addGrade(new SimpleGrade(100.0));
		this.testCompositeGrade.addGrade(new SimpleGrade(90.0));
		this.testCompositeGrade.addGrade(new SimpleGrade(80.0));
		this.testCompositeGrade.addGrade(new SimpleGrade(70.0));

		assertEquals(85.0, this.testCompositeGrade.getValue());
	}

	/**
	 * Tests CompositeGrade's getValue method when it's currently using the sum
	 * strategy to obtain a single value.
	 */
	@Test
	public void testGetValueUsingAdditiveStrategy() {
		this.testCompositeGrade.setGradingStrategy(new SumGradingStrategy());
		
		this.testCompositeGrade.addGrade(new SimpleGrade(100.0));
		this.testCompositeGrade.addGrade(new SimpleGrade(90.0));
		this.testCompositeGrade.addGrade(new SimpleGrade(80.0));
		this.testCompositeGrade.addGrade(new SimpleGrade(70.0));

		assertEquals(340.0, this.testCompositeGrade.getValue());
	}

}
