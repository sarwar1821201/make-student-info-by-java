package com.example.studentdemoproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
    ToggleGroup tg;

    @FXML
    void addCalculateCGPAButtonAction(ActionEvent event) {

    }

    @FXML
    void addStudentActionButton(ActionEvent event) {
     String gender="";

     if(maleRadioButton.isSelected())
         gender="Male";
     else if (femaleRadioButton.isSelected())
         gender="Female";

     ArrayList<String> skillSet=  new ArrayList<String>();
     if(javaCheckBox.isSelected() && pythonCheckBox.isSelected() ){
         skillSet.add("Java");
         skillSet.add("Python");
     } else if (javaCheckBox.isSelected()) {
         skillSet.add("Java");
     } else if (pythonCheckBox.isSelected()) {
         skillSet.add("Python");

     }

    }

    @FXML
    void showMaleAction(ActionEvent event) {

    }

    @FXML
    void initialize(){

    }

}
