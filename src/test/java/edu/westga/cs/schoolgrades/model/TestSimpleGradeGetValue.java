package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Tests SimpleGrade's getValue method.
 * 
 * @author Spencer Dent
 * @version 2021-10-17
 */
public class TestSimpleGradeGetValue {

	/**
	 * Tests that the getValue method on the SimpleGrade objects returns the correct
	 * values.
	 */
	@Test
	public void testShouldReturnGradeStoredValue() {
		assertEquals(100.0, new SimpleGrade(100.0).getValue());
		
		assertEquals(85.0, new SimpleGrade(85.0).getValue());
		
		assertEquals(92.0, new SimpleGrade(92.0).getValue());
		
		assertEquals(87.0, new SimpleGrade(87.0).getValue());
	}

}
