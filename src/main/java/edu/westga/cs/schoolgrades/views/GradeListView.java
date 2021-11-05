package edu.westga.cs.schoolgrades.views;

import edu.westga.cs.schoolgrades.model.Grade;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

/**
 * Extends ListView to make working with lists of Grades easier.
 * 
 * @author Spencer Dent
 * @version 2021-11-05
 */
public class GradeListView extends ListView<Grade> {

	/**
	 * Creates the GradeListView and sets-up its CellFactory
	 * 
	 * @param gradeList - the observable list of Grades
	 */
	public GradeListView(ObservableList<Grade> gradeList) {
		super(gradeList);

		this.setPrefHeight(200.0);
		this.setPrefWidth(100.0);

		this.setCellFactory(new Callback<ListView<Grade>, ListCell<Grade>>() {
			@Override
			public ListCell<Grade> call(ListView<Grade> arg0) {
				return new GradeCell();
			}
		});
	}

	private class GradeCell extends ListCell<Grade> {
		@Override
		public void updateItem(Grade newGrade, boolean empty) {
			super.updateItem(newGrade, empty);
			if (newGrade != null) {
				this.setText(Double.toString(newGrade.getValue()));
			}
		}
	}
}
