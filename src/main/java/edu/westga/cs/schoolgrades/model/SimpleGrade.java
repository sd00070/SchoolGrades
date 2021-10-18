package edu.westga.cs.schoolgrades.model;

/**
 * This Grade only contains the value.
 * 
 * @author Spencer Dent
 * @version 2021-10-17
 */
public class SimpleGrade implements Grade {

	private double value;

	/**
	 * Creates a new SimpleGrade with the given value.
	 * 
	 * @param newValue - the value to assign to the Grade
	 */
	public SimpleGrade(double newValue) {
		this.setValue(newValue);
	}

	@Override
	public double getValue() {
		return this.value;
	}

	/**
	 * Sets the SimpleGrade's value.
	 * 
	 * @param newValue - the new value for the SimpleGrade
	 * @precondition newValue >= 0
	 * @throws IllegalArgumentException if newValue < 0
	 */
	public void setValue(double newValue) {
		if (newValue < 0.0) {
			throw new IllegalArgumentException("Grade value must be greater than or equal to 0.0");
		}

		/*
		 * I was going to create a case to prevent scores greater than 100, but extra
		 * credit is a thing.
		 */

		this.value = newValue;
	}
}
