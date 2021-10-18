package edu.westga.cs.schoolgrades.model;

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
}
