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

	/**
	 * Creates a CompositeGrade using the MeanGradingStrategy to produce a single
	 * value.
	 */
	public CompositeGrade() {
		// this(new MeanGradingStrategy());
	}

	/**
	 * Creates a CompositeGrade using the given GradingStrategy to produce a single
	 * value.
	 * 
	 * @param selectedGradingStrategy - the GradingStrategy for the CompositeGrade
	 *                                to use
	 */
	public CompositeGrade(GradingStrategy selectedGradingStrategy) {
		if (selectedGradingStrategy == null) {
			throw new IllegalArgumentException("Must pass in a valid GradingStrategy");
		}
		
		this.grades = new ArrayList<Grade>();
		
		// TODO: attach GradingStrategy to CompositeGrade
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
		// TODO Auto-generated method stub
		return 0;
	}

}
