package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Using this Decorator on CompositeGrade's GradingStrategies drops the lowest
 * Grade in the CompositeGrade before totaling the Grades' values.
 * 
 * @author Spencer Dent
 * @version 2021-10-18
 */
public class DropLowestGradeGradingStrategyDecorator extends GradingStrategyDecorator {

	/**
	 * Creates a Decorator on a GradingStrategy that drops the lowest Grade value in
	 * the CompositeGrade before the Grades are totaled.
	 * 
	 * @param decoratedGradingStrategy - the GradingStrategy to decorate
	 */
	public DropLowestGradeGradingStrategyDecorator(GradingStrategy decoratedGradingStrategy) {
		super(decoratedGradingStrategy);
	}

	/**
	 * Drops the lowest Grade before delegating the work to the GradingStrategy.
	 * 
	 * @param grades - the Grades being totaled
	 * @return the Grade values total after dropping the lowest Grade
	 */
	public double totalGrades(List<Grade> grades) {
		if (grades == null || grades.isEmpty()) {
			return 0.0;
		}

		List<Grade> modifiedList = new ArrayList<Grade>(grades);
		modifiedList.remove(this.findLowestGrade(modifiedList));

		return super.totalGrades(modifiedList);
	}

	/**
	 * Returns the lowest Grade in the
	 * 
	 * @param grades - grades to search through
	 * @return the Grade with the lowest value
	 */
	private Grade findLowestGrade(List<Grade> grades) {
		Grade lowest = grades.get(0);

		for (Grade grade : grades) {
			if (grade.getValue() < lowest.getValue()) {
				lowest = grade;
			}
		}

		return lowest;
	}
}
