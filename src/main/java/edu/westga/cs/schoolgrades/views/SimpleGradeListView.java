package edu.westga.cs.schoolgrades.views;

import edu.westga.cs.schoolgrades.controllers.SimpleGradeStringConverter;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.TextFieldListCell;

/**
 * Extends ListView to make working with lists of Grades easier.
 * 
 * @author Spencer Dent
 * @version 2021-11-05
 */
public class SimpleGradeListView extends ListView<SimpleGrade> {

	/**
	 * Creates a SimpleGradeListView and sets-up its CellFactory, connecting the
	 * SimpleGradeStringConverter.
	 * 
	 * @param simpleGradeList - the list of SimpleGrades backing the ListView
	 * @param tooltipString   - the String to use as the SimpleGradeList's tooltip
	 * @precondition gradeList != null
	 * @throws IllegalArgumentException if gradeList == null
	 */
	public SimpleGradeListView(ObservableList<SimpleGrade> simpleGradeList, String tooltipString) {
		super(simpleGradeList);

		if (simpleGradeList == null) {
			throw new IllegalArgumentException("SimpleGradeList cannot be null.");
		}

		this.setPrefHeight(200.0);
		this.setPrefWidth(100.0);

		if (tooltipString != null) {
			this.setTooltip(new Tooltip(tooltipString));
		}

		this.setEditable(true);

		this.setCellFactory(listView -> {
			TextFieldListCell<SimpleGrade> gradeCell = new TextFieldListCell<SimpleGrade>();
			gradeCell.setConverter(new SimpleGradeStringConverter(gradeCell));
			return gradeCell;
		});
	}

	/**
	 * Creates a SimpleGradeListView and sets-up its CellFactory, connecting the
	 * SimpleGradeStringConverter.
	 * 
	 * Does not add a tooltip.
	 * 
	 * @param simpleGradeList - the list of SimpleGrades backing the ListView
	 */
	public SimpleGradeListView(ObservableList<SimpleGrade> simpleGradeList) {
		this(simpleGradeList, null);
	}
}
