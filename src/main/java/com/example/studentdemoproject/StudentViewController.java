package com.example.studentdemoproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class StudentViewController {

    @FXML
    private TextArea averageCGPAArea;

    @FXML
    private TableColumn<Student, String> cgpaTableColumn;

    @FXML
    private TextField cgpaTextField;

    @FXML
    private DatePicker dateBox;

    @FXML
    private TableColumn<Student, String> dateTableColumn;

    @FXML
    private RadioButton femaleRadioButton;

    @FXML
    private TableColumn<Student, String> genderTableColumn;

    @FXML
    private TableColumn<Student, String> idTableColumn;

    @FXML
    private TextField idTextFiield;

    @FXML
    private CheckBox javaCheckBox;

    @FXML
    private ComboBox<String> majorComboBox;

    @FXML
    private TableColumn<Student, String> majorTableColumn;

    @FXML
    private RadioButton maleRadioButton;

    @FXML
    private TableColumn<Student, String> nameTableColumn;

    @FXML
    private TextField nameTextField;

    @FXML
    private CheckBox pythonCheckBox;

    @FXML
    private TableColumn<Student, String> skillsTableColumn;

    @FXML
    private TableView<Student> studentInfoTable;

    @FXML
    private Label warningBox;

    ArrayList<Student>studentList;

    @FXML
    void addCalculateCGPAButtonAction(ActionEvent event) {

    }

    @FXML
    void addStudentActionButton(ActionEvent event) {

    }

    @FXML
    void showMaleAction(ActionEvent event) {

    }

    @FXML
    void initialize(){

    }

}
