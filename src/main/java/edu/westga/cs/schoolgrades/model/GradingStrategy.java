package edu.westga.cs.schoolgrades.model;

import java.util.List;

/**
 * Strategy used in CompositeGrades to total the Grades into a single value.
 * 
 * @author Spencer Dent
 * @version 2021-10-18
 */
public interface GradingStrategy {

	/**
	 * Reduces the Grade values into a single value.
	 * 
	 * @param grades - the list of grades in the CompositeGrade
	 * @return - the single value produced by the GradingStrategy
	 */
	double totalGrades(List<Grade> grades);
}
