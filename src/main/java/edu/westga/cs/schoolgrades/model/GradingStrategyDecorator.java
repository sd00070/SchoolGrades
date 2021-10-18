package edu.westga.cs.schoolgrades.model;

import java.util.List;

/**
 * Serves as the basis for all GradingStrategyDecorators. Provides the most
 * basic functionality common between GradingStrategyDecorator classes.
 * 
 * @author Spencer Dent
 * @version 2021-10-18
 */
public abstract class GradingStrategyDecorator implements GradingStrategy {

	private GradingStrategy gradingStrategy;

	/**
	 * Constructor basis used by all GradingStrategyDecorator classes.
	 * 
	 * @param decoratedGradingStrategy - the GradingStrategy to be decorated
	 * @precondition decoratedGradingStrategy != null
	 * @throws IllegalArgumentException if decoratedGradingStrategy == null
	 */
	public GradingStrategyDecorator(GradingStrategy decoratedGradingStrategy) {
		if (decoratedGradingStrategy == null) {
			throw new IllegalArgumentException("GradingStrategy to be decorated cannot be null");
		}

		this.gradingStrategy = decoratedGradingStrategy;
	}

	/**
	 * Returns the GradingStrategy being decorated.
	 * 
	 * @return the Decorator's subject
	 */
	public GradingStrategy getGradingStrategy() {
		return this.gradingStrategy;
	}

	@Override
	public double totalGrades(List<Grade> grades) {
		return this.gradingStrategy.totalGrades(grades);
	}

}
