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
	 * @precondition selectedGradingStrategy != null
	 * @throws IllegalArgumentException if selectedGradingStrategy == null
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
	 * @precondition newGrade != null
	 * @throws IllegalArgumentException if newGrade == null
	 */
	public void addGrade(Grade newGrade) {
		if (newGrade == null) {
			throw new IllegalArgumentException("New grade cannot be null");
		}

		this.grades.add(newGrade);
	}

	/**
	 * Appends a number of Grades to the CompositeGrade.
	 * 
	 * @param grades - the Grade objects to add
	 */
	public void addGrades(Grade... grades) {
		for (Grade grade : grades) {
			this.addGrade(grade);
		}
	}

	/**
	 * Returns the list of Grades in the CompositeGrade.
	 * 
	 * @return the groups of stored Grades
	 */
	public ArrayList<Grade> getGrades() {
		return this.grades;
	}

	/**
	 * Removes all Grades in the CompositeGrade.
	 */
	public void clearGrades() {
		this.grades.clear();
	}

	@Override
	public double getValue() {
		if (this.grades.isEmpty()) {
			return 0.0;
		}

		return this.gradingStrategy.totalGrades(this.grades);
	}

}
