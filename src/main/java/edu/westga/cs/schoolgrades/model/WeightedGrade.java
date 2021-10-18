package edu.westga.cs.schoolgrades.model;

/**
 * WeightedGrade decorates another grade object with a given weight.
 * 
 * @author Spencer Dent
 * @version 2021-10-18
 */
public class WeightedGrade extends GradeDecorator {

	private double weight;

	/**
	 * Creates a WeightedGrade Decorator on a Grade object, initially weighting the
	 * Grade 100% (not affecting the Grade until changed)
	 * 
	 * @param decoratedGrade - the Grade object to be weighted
	 */
	public WeightedGrade(Grade decoratedGrade) {
		super(decoratedGrade);

		this.weight = 1.0;
	}

	/**
	 * Returns the current weight applied to the Grade
	 * 
	 * @return the weight of the Decorator
	 */
	public double getWeight() {
		return this.weight;
	}

	/**
	 * Sets the weight of the Decorator. The value has been normalized (0.0 -> 0%,
	 * 1.0 -> 100% ...)
	 * 
	 * @param newWeight - the weight to affect the Grade
	 */
	public void setWeight(double newWeight) {
		this.weight = newWeight;
	}

	/**
	 * Returns the modified value after being affected by the weight.
	 * 
	 * @return the new value after being weighted
	 */
	public double getValue() {
		// TODO: implement weighting
		return 0.0;
	}
}
