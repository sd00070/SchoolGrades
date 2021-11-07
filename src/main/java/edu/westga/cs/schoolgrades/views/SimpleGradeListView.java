package edu.westga.cs.schoolgrades.views;

import edu.westga.cs.schoolgrades.controllers.SimpleGradeStringConverter;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;

/**
 * Extends ListView to make working with lists of Grades easier.
 * 
 * @author Spencer Dent
 * @version 2021-11-05
 */
public class SimpleGradeListView extends ListView<SimpleGrade> {

	/**
	 * Creates the GradeListView and sets-up its CellFactory
	 * 
	 * @param gradeList - the observable list of Grades
	 */
	public SimpleGradeListView(ObservableList<SimpleGrade> gradeList) {
		super(gradeList);

		this.setPrefHeight(200.0);
		this.setPrefWidth(100.0);

		this.setEditable(true);

		this.setCellFactory(listView -> {
			TextFieldListCell<SimpleGrade> gradeCell = new TextFieldListCell<SimpleGrade>();
			gradeCell.setConverter(new SimpleGradeStringConverter(gradeCell));
			return gradeCell;
		});
	}
}
