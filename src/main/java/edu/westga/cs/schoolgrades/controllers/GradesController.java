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
import javafx.fxml.Initializable;

/**
 * Serves as the controller for the School Grades Application.
 * 
 * Communicates information between the grading models and application views.
 * 
 * @author Spencer Dent
 * @version 2021-11-04
 */
public class GradesController implements Initializable {

	private ObservableList<Grade> quizGradeList;
	private ObservableList<Grade> homeworkdGradeList;
	private ObservableList<Grade> examGradeList;

	private CompositeGrade quizSubtotal;
	private CompositeGrade homeworkSubtotal;
	private CompositeGrade examSubtotal;

	private CompositeGrade finalGrade;

	/**
	 * Initializes the controller's models.
	 */
	public GradesController() {
		this.quizGradeList = FXCollections.observableArrayList();
		this.homeworkdGradeList = FXCollections.observableArrayList();
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

	}

}
