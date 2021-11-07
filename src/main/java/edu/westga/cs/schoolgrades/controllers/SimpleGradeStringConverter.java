package edu.westga.cs.schoolgrades.controllers;

import edu.westga.cs.schoolgrades.model.SimpleGrade;
import javafx.scene.control.ListCell;
import javafx.util.StringConverter;

/**
 * Isomorphic function object wrapper class to convert a SimpleGrade to String
 * and vice versa.
 * 
 * Very closely following the StringConverter pattern found on
 * stackoverflow.com/questions/36436358/javafx-listview-edit-textfieldlistcell
 * 
 * @author Spencer Dent
 * @version 2021-11-07
 */
public class SimpleGradeStringConverter extends StringConverter<SimpleGrade> {

	private final ListCell<SimpleGrade> gradeCell;

	/**
	 * 
	 * @param gradeCell
	 */
	public SimpleGradeStringConverter(ListCell<SimpleGrade> gradeCell) {
		this.gradeCell = gradeCell;
	}

	@Override
	public SimpleGrade fromString(String stringValue) {
		SimpleGrade grade = this.gradeCell.getItem();
		grade.setValue(Double.parseDouble(stringValue));
		return grade;
	}

	@Override
	public String toString(SimpleGrade grade) {
		return Double.toString(grade.getValue());
	}
}
