package edu.westga.cs.schoolgrades.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import edu.westga.cs.schoolgrades.model.CompositeGrade;
import edu.westga.cs.schoolgrades.model.DropLowestGradeGradingStrategyDecorator;
import edu.westga.cs.schoolgrades.model.Grade;
import edu.westga.cs.schoolgrades.model.MeanGradingStrategy;
import edu.westga.cs.schoolgrades.model.SumGradingStrategy;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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
	private ObservableList<Grade> quizGradeList;
	private ObservableList<Grade> homeworkGradeList;
	private ObservableList<Grade> examGradeList;

	private CompositeGrade quizSubtotal;
	private CompositeGrade homeworkSubtotal;
	private CompositeGrade examSubtotal;

	private CompositeGrade finalGrade;

	/* References to view classes */
	@FXML
	private ListView<Grade> quizzesListView;
	@FXML
	private ListView<Grade> homeworksListView;
	@FXML
	private ListView<Grade> examsListView;

	@FXML
	private TextField quizSubtotalTextField;
	@FXML
	private TextField homeworkSubtotalTextField;
	@FXML
	private TextField examSubtotalTextField;

	@FXML
	private TextField finalGradeTextField;

	/**
	 * Initializes the controller's models.
	 */
	public GradesController() {
		this.quizGradeList = FXCollections.observableArrayList();
		this.homeworkGradeList = FXCollections.observableArrayList();
		this.examGradeList = FXCollections.observableArrayList();

		this.quizSubtotal = new CompositeGrade(new SumGradingStrategy());
		this.homeworkSubtotal = new CompositeGrade(
				new DropLowestGradeGradingStrategyDecorator(new MeanGradingStrategy()));
		this.examSubtotal = new CompositeGrade();

		this.finalGrade = new CompositeGrade(new SumGradingStrategy());
	}

	/**
	 * Binds the controller's models to the view.
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.quizzesListView.setItems(this.quizGradeList);
		this.homeworksListView.setItems(this.homeworkGradeList);
		this.examsListView.setItems(this.examGradeList);
	}

	private void handleAddDataMenuItemClicked(ObservableList<Grade> gradeList, ActionEvent mouseClickedEvent) {
		System.out.print("MenuItem clicked");
	}

	/**
	 * Callback executed whenever the click event is fired on the "Add quiz"
	 * MenuItem.
	 * 
	 * @param mouseClickedEvent - contains all event info at time of click
	 */
	@FXML
	public void handleAddQuizMenuItemClicked(ActionEvent mouseClickedEvent) {
		this.handleAddDataMenuItemClicked(this.quizGradeList, mouseClickedEvent);
		System.out.println(": Add Quiz");
	}

	/**
	 * Callback executed whenever the click event is fired on the "Add homework"
	 * MenuItem.
	 * 
	 * @param mouseClickedEvent - contains all event info at time of click
	 */
	@FXML
	public void handleAddHomeworkMenuItemClicked(ActionEvent mouseClickedEvent) {
		this.handleAddDataMenuItemClicked(this.homeworkGradeList, mouseClickedEvent);
		System.out.println(": Add Homework");
	}

	/**
	 * Callback executed whenever the click event is fired on the "Add exam"
	 * MenuItem.
	 * 
	 * @param mouseClickedEvent - contains all event info at time of click
	 */
	@FXML
	public void handleAddExamMenuItemClicked(ActionEvent mouseClickedEvent) {
		this.handleAddDataMenuItemClicked(this.examGradeList, mouseClickedEvent);
		System.out.println(": Add Exam");
	}

	/**
	 * Callback executed whenever the click event on the recalculateButton is fired.
	 * 
	 * @param mouseClickedEvent - information regarding the mouse at time of click
	 */
	@FXML
	public void handleRecalculateButtonClicked(MouseEvent mouseClickedEvent) {
		System.out.println("Recalculate Button has been clicked.");
	}
}
