package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class TestCompositeGradeConstructor {

	
	
	@Test
	public void shouldNotAllowNullStrategy() {
		assertThrows(IllegalArgumentException.class, () ->{ 
			new CompositeGrade(null);
		});
	}
	
	@Test
	public void shouldHaveNoGradesWhenCreated() {
		CompositeGrade grade = new CompositeGrade(mock(GradeCalculationStrategy.class));
		assertTrue(grade.getGrades().isEmpty());
	}

}
