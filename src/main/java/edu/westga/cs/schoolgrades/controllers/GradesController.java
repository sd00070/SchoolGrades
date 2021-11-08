package edu.westga.cs.schoolgrades.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import edu.westga.cs.schoolgrades.model.CompositeGrade;
import edu.westga.cs.schoolgrades.model.DropLowestGradeGradingStrategyDecorator;
import edu.westga.cs.schoolgrades.model.Grade;
import edu.westga.cs.schoolgrades.model.MeanGradingStrategy;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.SumGradingStrategy;
import edu.westga.cs.schoolgrades.model.WeightedGrade;
import edu.westga.cs.schoolgrades.views.SimpleGradeListView;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * Serves as the controller for the School Grades Application.
 * 
 * Communicates information between the grading models and application views.
 * 
 * @author Spencer Dent
 * @version 2021-11-04
 */
public class GradesController implements Initializable {

	/* References to model classes */
	private ObservableList<SimpleGrade> quizzesGradeList;
	private ObservableList<SimpleGrade> homeworksGradeList;
	private ObservableList<SimpleGrade> examsGradeList;

	private CompositeGrade quizzesSubtotal;
	private DoubleProperty quizzesSubtotalProperty;

	private CompositeGrade homeworksSubtotal;
	private DoubleProperty homeworksSubtotalProperty;
	
	private CompositeGrade examsSubtotal;
	private DoubleProperty examsSubtotalProperty;

	private CompositeGrade finalGrade;
	private DoubleProperty finalGradeProperty;

	/* References to view classes */
	@FXML
	private Pane quizzesGradeListViewPane;
	private SimpleGradeListView quizzesGradeListView;

	@FXML
	private Pane homeworksGradeListViewPane;
	private SimpleGradeListView homeworksGradeListView;

	@FXML
	private Pane examsGradeListViewPane;
	private SimpleGradeListView examsGradeListView;

	@FXML
	private TextField quizzesSubtotalTextField;
	@FXML
	private TextField homeworksSubtotalTextField;
	@FXML
	private TextField examsSubtotalTextField;

	@FXML
	private TextField finalGradeTextField;

	/**
	 * Initializes the controller's models.
	 */
	public GradesController() {
		this.quizzesGradeList = FXCollections.observableArrayList();
		this.quizzesGradeListView = new SimpleGradeListView(this.quizzesGradeList, "Column for quiz grades");
		this.quizzesSubtotal = new CompositeGrade(new SumGradingStrategy());
		this.quizzesSubtotalProperty = new SimpleDoubleProperty(this.quizzesSubtotal.getValue());

		this.homeworksGradeList = FXCollections.observableArrayList();
		this.homeworksGradeListView = new SimpleGradeListView(this.homeworksGradeList, "Column for homework grades");
		this.homeworksGradeListView.setPrefWidth(150.0);
		this.homeworksSubtotal = new CompositeGrade(
				new DropLowestGradeGradingStrategyDecorator(new MeanGradingStrategy()));
		this.homeworksSubtotalProperty = new SimpleDoubleProperty(this.homeworksSubtotal.getValue());

		this.examsGradeList = FXCollections.observableArrayList();
		this.examsGradeListView = new SimpleGradeListView(this.examsGradeList, "Column for exam grades");
		this.examsGradeListView.setPrefWidth(150.0);
		this.examsSubtotal = new CompositeGrade();
		this.examsSubtotalProperty = new SimpleDoubleProperty(this.examsSubtotal.getValue());
		
		this.finalGrade = new CompositeGrade(new SumGradingStrategy());
		this.finalGradeProperty = new SimpleDoubleProperty(this.finalGrade.getValue());
	}

	/**
	 * Binds the controller's models to the view.
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.quizzesGradeListViewPane.getChildren().add(this.quizzesGradeListView);
		this.homeworksGradeListViewPane.getChildren().add(this.homeworksGradeListView);
		this.examsGradeListViewPane.getChildren().add(this.examsGradeListView);

		this.quizzesSubtotalTextField.textProperty().bind(this.quizzesSubtotalProperty.asString());
		this.homeworksSubtotalTextField.textProperty().bind(this.homeworksSubtotalProperty.asString());
		this.examsSubtotalTextField.textProperty().bind(this.examsSubtotalProperty.asString());
		this.finalGradeTextField.textProperty().bind(this.finalGradeProperty.asString());

		this.quizzesGradeList.addAll(new SimpleGrade(20.0), new SimpleGrade(10.0));

		this.homeworksGradeList.addAll(new SimpleGrade(100.0), new SimpleGrade(80.0), new SimpleGrade(60.0),
				new SimpleGrade(40.0), new SimpleGrade(20.0));

		this.examsGradeList.addAll(new SimpleGrade(99.0), new SimpleGrade(67.0), new SimpleGrade(73.0),
				new SimpleGrade(88.0));
	}

	private void handleAddDataMenuItemClicked(SimpleGradeListView listView, ObservableList<SimpleGrade> gradeList,
			ActionEvent mouseClickedEvent) {
		SimpleGrade newGrade = new SimpleGrade(0.0);

		gradeList.add(newGrade);

		listView.getSelectionModel().clearAndSelect(gradeList.size() - 1);
		listView.requestFocus();
	}

	/**
	 * Callback executed whenever the click event is fired on the "Add quiz"
	 * MenuItem.
	 * 
	 * @param mouseClickedEvent - contains all event info at time of click
	 */
	@FXML
	public void handleAddQuizMenuItemClicked(ActionEvent mouseClickedEvent) {
		this.handleAddDataMenuItemClicked(this.quizzesGradeListView, this.quizzesGradeList, mouseClickedEvent);
	}

	/**
	 * Callback executed whenever the click event is fired on the "Add homework"
	 * MenuItem.
	 * 
	 * @param mouseClickedEvent - contains all event info at time of click
	 */
	@FXML
	public void handleAddHomeworkMenuItemClicked(ActionEvent mouseClickedEvent) {
		this.handleAddDataMenuItemClicked(this.homeworksGradeListView, this.homeworksGradeList, mouseClickedEvent);
	}

	/**
	 * Callback executed whenever the click event is fired on the "Add exam"
	 * MenuItem.
	 * 
	 * @param mouseClickedEvent - contains all event info at time of click
	 */
	@FXML
	public void handleAddExamMenuItemClicked(ActionEvent mouseClickedEvent) {
		this.handleAddDataMenuItemClicked(this.examsGradeListView, this.examsGradeList, mouseClickedEvent);
	}

	/**
	 * Callback executed whenever the click event on the recalculateButton is fired.
	 * 
	 * @param mouseClickedEvent - information regarding the mouse at time of click
	 */
	@FXML
	public void handleRecalculateButtonClicked(MouseEvent mouseClickedEvent) {
		this.quizzesSubtotal.clearGrades();
		for (Grade curGrade : this.quizzesGradeList) {
			this.quizzesSubtotal.addGrade(curGrade);
		}
		this.quizzesSubtotalProperty.set(this.quizzesSubtotal.getValue());

		this.homeworksSubtotal.clearGrades();
		for (Grade curGrade : this.homeworksGradeList) {
			this.homeworksSubtotal.addGrade(curGrade);
		}
		this.homeworksSubtotalProperty.set(this.homeworksSubtotal.getValue());

		this.examsSubtotal.clearGrades();
		for (Grade curGrade : this.examsGradeList) {
			this.examsSubtotal.addGrade(curGrade);
		}
		this.examsSubtotalProperty.set(this.examsSubtotal.getValue());

		this.finalGrade.clearGrades();
		this.finalGrade.addGrade(new WeightedGrade(0.2, this.quizzesSubtotal));
		this.finalGrade.addGrade(new WeightedGrade(0.3, this.homeworksSubtotal));
		this.finalGrade.addGrade(new WeightedGrade(0.5, this.examsSubtotal));
		this.finalGradeProperty.set(this.finalGrade.getValue());
	}
}
