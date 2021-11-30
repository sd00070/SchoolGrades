package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDropLowestStrategyCalculate {

	private DropLowestStrategy dropLowestStrategy;
	private GradeCalculationStrategy childStrategy;

	private Grade grade0;
	private Grade grade1;
	private Grade grade2;

	private List<Grade> grades;

	@BeforeEach
	public void setUp() throws Exception {
		grade0 = mock(Grade.class);
		when(grade0.getValue()).thenReturn(10.0);

		grade1 = mock(Grade.class);
		when(grade1.getValue()).thenReturn(20.0);

		grade2 = mock(Grade.class);
		when(grade2.getValue()).thenReturn(30.0);

		grades = new ArrayList<Grade>();

		childStrategy = mock(GradeCalculationStrategy.class);
		dropLowestStrategy = new DropLowestStrategy(childStrategy);
	}

	@Test
	public void shouldNotAllowNullGradesList() {
		assertThrows(IllegalArgumentException.class, () -> {
			dropLowestStrategy.calculate(null);
		});
	}

	@Test
	public void shouldNotDropLowestIfGradesListIsEmpty() {
		dropLowestStrategy.calculate(grades);
		verify(childStrategy).calculate(grades);
	}

	@Test
	public void shouldNotDropLowestIfGradesListHasOneElement() {
		grades.add(grade0);

		dropLowestStrategy.calculate(grades);

		verify(childStrategy).calculate(grades);
	}

	@Test
	public void canDropWhenLowestIsFirst() {
		grades.add(grade0);
		grades.add(grade1);
		grades.add(grade2);

		dropLowestStrategy.calculate(grades);

		grades.clear();
		grades.add(grade1);
		grades.add(grade2);

		verify(childStrategy).calculate(grades);
	}

	@Test
	public void canDropWhenLowestIsLast() {
		grades.add(grade1);
		grades.add(grade2);
		grades.add(grade0);

		dropLowestStrategy.calculate(grades);

		grades.clear();
		grades.add(grade1);
		grades.add(grade2);

		verify(childStrategy).calculate(grades);
	}

	@Test
	public void canDropWhenLowestIsInMiddle() {
		grades.add(grade1);
		grades.add(grade0);
		grades.add(grade2);

		dropLowestStrategy.calculate(grades);

		grades.clear();
		grades.add(grade1);
		grades.add(grade2);

		verify(childStrategy).calculate(grades);
	}

	@Test
	public void dropsOnlyOneIfThereAreMultipleLowestGrades() {
		grades.add(grade1);
		grades.add(grade0);
		grades.add(grade2);
		grades.add(grade0);

		dropLowestStrategy.calculate(grades);

		grades.clear();
		grades.add(grade1);
		grades.add(grade2);
		grades.add(grade0);

		verify(childStrategy).calculate(grades);
	}
}
