package edu.westga.cs.schoolgrades.model;

import java.util.List;

/**
 * Used to calculate the average (mean) of the list of grades (reducing the list
 * to a single value).
 * 
 * @author Spencer Dent
 * @version 2021-10-18
 */
public class MeanGradingStrategy implements GradingStrategy {

	@Override
	public double totalGrades(List<Grade> grades) {
		return (new SumGradingStrategy()).totalGrades(grades) / (double) grades.size();
	}
}
