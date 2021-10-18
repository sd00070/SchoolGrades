package edu.westga.cs.schoolgrades.model;

/**
 * Serves as the basis for all GradeDecorators. Provides the most basic
 * functionality common between GradeDecorator classes.
 * 
 * @author Spencer Dent
 * @version 2021-10-18
 */
public abstract class GradeDecorator implements Grade {

	private Grade grade;

	/**
	 * Constructor basis used by all GradeDecorator classes.
	 * 
	 * @param wrappedGrade - the Grade being decorated
	 */
	public GradeDecorator(Grade wrappedGrade) {
		this.grade = wrappedGrade;
	}

	/**
	 * Returns the Grade object being decorated.
	 * 
	 * @return the decorated Grade object
	 */
	public Grade getGrade() {
		return this.grade;
	}

	@Override
	public double getValue() {
		return this.grade.getValue();
	}
}
