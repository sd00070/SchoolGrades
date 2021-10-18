package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * This version of Grade has multiple grades stored inside of it.
 * 
 * @author Spencer Dent
 * @version 2021-10-18
 */
public class CompositeGrade implements Grade {

	private ArrayList<Grade> grades;
	private GradingStrategy gradingStrategy;

	/**
	 * Creates a CompositeGrade using the MeanGradingStrategy to produce a single
	 * value.
	 */
	public CompositeGrade() {
		this(new MeanGradingStrategy());
	}

	/**
	 * Creates a CompositeGrade using the given GradingStrategy to produce a single
	 * value.
	 * 
	 * @param selectedGradingStrategy - the GradingStrategy for the CompositeGrade
	 *                                to use
	 */
	public CompositeGrade(GradingStrategy selectedGradingStrategy) {
		this.setGradingStrategy(selectedGradingStrategy);

		this.grades = new ArrayList<Grade>();
	}

	/**
	 * Sets the GradingStrategy of the CompositeGrade.
	 * 
	 * @param selectedGradingStrategy - the GradingStrategy to use
	 */
	public void setGradingStrategy(GradingStrategy selectedGradingStrategy) {
		if (selectedGradingStrategy == null) {
			throw new IllegalArgumentException("Must pass in a valid GradingStrategy");
		}

		this.gradingStrategy = selectedGradingStrategy;
	}

	/**
	 * Returns the selected GradingStrategy.
	 * 
	 * @return the GradingStrategy currently in use
	 */
	public GradingStrategy getGradingStrategy() {
		return this.gradingStrategy;
	}

	/**
	 * Adds a new Grade to the CompositeGrade list.
	 * 
	 * @param newGrade - the new Grade to add
	 */
	public void addGrade(Grade newGrade) {
		this.grades.add(newGrade);
	}

	/**
	 * Returns the list of Grades in the CompositeGrade.
	 * 
	 * @return the groups of stored Grades
	 */
	public ArrayList<Grade> getGrades() {
		return this.grades;
	}

	@Override
	public double getValue() {
		if (this.grades.isEmpty()) {
			return 0.0;
		}
		
		return this.gradingStrategy.totalGrades(this.grades);
	}

}
