package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests CompositeGrade's addGrade method.
 * 
 * @author Spencer Dent
 * @version 2021-10-18
 */
public class TestCompositeGradeAddGrade {

	private CompositeGrade testCompositeGrade;

	/**
	 * Creates a fresh CompositeGrade object before each test.
	 */
	@BeforeEach
	public void initEach() {
		this.testCompositeGrade = new CompositeGrade();
	}

	/**
	 * Tests to make sure that addGrade properly adds a SimpleGrade to an empty
	 * CompositeGrade.
	 */
	@Test
	public void testAddingSimpleGradeToEmptyCompositeGrade() {
		Grade testSimpleGrade = new SimpleGrade(100.0);

		this.testCompositeGrade.addGrade(testSimpleGrade);

		List<Grade> expectedList = new ArrayList<Grade>();
		expectedList.add(testSimpleGrade);

		assertEquals(expectedList, this.testCompositeGrade.getGrades());
	}

	/**
	 * Tests to make sure that addGrade properly adds an empty CompositeGrade to an
	 * empty CompositeGrade.
	 */
	@Test
	public void testAddingEmptyCompositeGradeToEmptyCompositeGrade() {
		Grade testInteralCompositeGrade = new CompositeGrade();

		this.testCompositeGrade.addGrade(testInteralCompositeGrade);

		List<Grade> expectedList = new ArrayList<Grade>();
		expectedList.add(testInteralCompositeGrade);

		assertEquals(expectedList, this.testCompositeGrade.getGrades());
	}

	/**
	 * Tests to make sure that addGrade properly adds multiple SimpleGrades.
	 */
	@Test
	public void testAddingMulitpleSimpleGrades() {
		Grade g0 = new SimpleGrade(0.0);
		Grade g1 = new SimpleGrade(28.4);
		Grade g2 = new SimpleGrade(100.0);

		this.testCompositeGrade.addGrade(g0);
		this.testCompositeGrade.addGrade(g1);
		this.testCompositeGrade.addGrade(g2);

		List<Grade> expectedList = new ArrayList<Grade>();
		expectedList.add(g0);
		expectedList.add(g1);
		expectedList.add(g2);

		assertEquals(expectedList, this.testCompositeGrade.getGrades());
	}

	/**
	 * Tests to make sure that addGrade properly adds CompositeGrades with grades in
	 * them to the CompositeGrade.
	 */
	@Test
	public void testAddingContentfulCompositeGrades() {
		CompositeGrade contentfulTestCompositeGrade = new CompositeGrade();
		contentfulTestCompositeGrade.addGrade(new SimpleGrade(100.0));
		contentfulTestCompositeGrade.addGrade(new SimpleGrade(85.0));
		
		this.testCompositeGrade.addGrade(contentfulTestCompositeGrade);
		
		List<Grade> expectedList = new ArrayList<Grade>();
		expectedList.add(contentfulTestCompositeGrade);
		
		assertEquals(expectedList, this.testCompositeGrade.getGrades());
	}
}
