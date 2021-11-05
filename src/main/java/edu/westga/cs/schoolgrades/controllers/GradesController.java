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
import edu.westga.cs.schoolgrades.views.GradeListView;
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
	private ObservableList<Grade> quizzesGradeList;
	private ObservableList<Grade> homeworksGradeList;
	private ObservableList<Grade> examsGradeList;

	private CompositeGrade quizSubtotal;
	private CompositeGrade homeworkSubtotal;
	private CompositeGrade examSubtotal;

	private CompositeGrade finalGrade;

	/* References to view classes */
	@FXML private Pane quizzesGradeListViewPane;
	private GradeListView quizzesGradeListView;

	@FXML private Pane homeworksGradeListViewPane;
	private GradeListView homeworksGradeListView;

	@FXML private Pane examsGradeListViewPane;
	private GradeListView examsGradeListView;

	@FXML private TextField quizSubtotalTextField;
	@FXML private TextField homeworkSubtotalTextField;
	@FXML private TextField examSubtotalTextField;

	@FXML private TextField finalGradeTextField;

	/**
	 * Initializes the controller's models.
	 */
	public GradesController() {
		this.quizzesGradeList = FXCollections.observableArrayList();
		this.quizzesGradeListView = new GradeListView(this.quizzesGradeList);
		this.quizSubtotal = new CompositeGrade(new SumGradingStrategy());

		this.homeworksGradeList = FXCollections.observableArrayList();
		this.homeworksGradeListView = new GradeListView(this.homeworksGradeList);
		this.homeworksGradeListView.setPrefWidth(150.0);
		this.homeworkSubtotal = new CompositeGrade(
				new DropLowestGradeGradingStrategyDecorator(new MeanGradingStrategy()));

		this.examsGradeList = FXCollections.observableArrayList();
		this.examsGradeListView = new GradeListView(this.examsGradeList);
		this.examsGradeListView.setPrefWidth(150.0);
		this.examSubtotal = new CompositeGrade();
	}

	/**
	 * Binds the controller's models to the view.
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.quizzesGradeListViewPane.getChildren().add(this.quizzesGradeListView);
		this.homeworksGradeListViewPane.getChildren().add(this.homeworksGradeListView);
		this.examsGradeListViewPane.getChildren().add(this.examsGradeListView);

		this.quizzesGradeList.add(new SimpleGrade(20.0));
		this.quizzesGradeList.add(new SimpleGrade(10.0));

		this.homeworksGradeList.add(new SimpleGrade(100.0));
		this.homeworksGradeList.add(new SimpleGrade(80.0));
		this.homeworksGradeList.add(new SimpleGrade(60.0));
		this.homeworksGradeList.add(new SimpleGrade(40.0));
		this.homeworksGradeList.add(new SimpleGrade(20.0));

		this.examsGradeList.add(new SimpleGrade(99.0));
		this.examsGradeList.add(new SimpleGrade(67.0));
		this.examsGradeList.add(new SimpleGrade(73.0));
		this.examsGradeList.add(new SimpleGrade(88.0));
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
		this.handleAddDataMenuItemClicked(this.quizzesGradeList, mouseClickedEvent);
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
		this.handleAddDataMenuItemClicked(this.homeworksGradeList, mouseClickedEvent);
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
		this.handleAddDataMenuItemClicked(this.examsGradeList, mouseClickedEvent);
		System.out.println(": Add Exam");
	}

	/**
	 * Callback executed whenever the click event on the recalculateButton is fired.
	 * 
	 * @param mouseClickedEvent - information regarding the mouse at time of click
	 */
	@FXML
	public void handleRecalculateButtonClicked(MouseEvent mouseClickedEvent) {
		this.quizSubtotal.clearGrades();
		for (Grade curGrade : this.quizzesGradeList) {
			this.quizSubtotal.addGrade(curGrade);
		}
		this.quizSubtotalTextField.textProperty().setValue(Double.toString(this.quizSubtotal.getValue()));

		this.homeworkSubtotal.clearGrades();
		for (Grade curGrade : this.homeworksGradeList) {
			this.homeworkSubtotal.addGrade(curGrade);
		}
		this.homeworkSubtotalTextField.textProperty().setValue(Double.toString(this.homeworkSubtotal.getValue()));

		this.examSubtotal.clearGrades();
		for (Grade curGrade : this.examsGradeList) {
			this.examSubtotal.addGrade(curGrade);
		}
		this.examSubtotalTextField.textProperty().setValue(Double.toString(this.examSubtotal.getValue()));

		this.finalGrade = new CompositeGrade(new SumGradingStrategy());
		this.finalGrade.addGrade(new WeightedGrade(0.2, this.quizSubtotal));
		this.finalGrade.addGrade(new WeightedGrade(0.3, this.homeworkSubtotal));
		this.finalGrade.addGrade(new WeightedGrade(0.5, this.examSubtotal));
		this.finalGradeTextField.textProperty().setValue(Double.toString(this.finalGrade.getValue()));
	}
}
