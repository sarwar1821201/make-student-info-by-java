package com.example.studentdemoproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

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
    private TextArea warningBox;

    ArrayList<Student>studentList;
    ToggleGroup tg;

    @FXML
    void addCalculateCGPAButtonAction(ActionEvent event) {

    }

    @FXML
    void addStudentActionButton(ActionEvent event) {
        boolean digitFound=false;
        for(int i=0; i<nameTextField.getText().length(); i++){
            if(nameTextField.getText().charAt(i) >='0' && nameTextField.getText().charAt(i) <='9'){
                digitFound=true;
            }
        }

        if(idTextFiield.getText().isEmpty() ||
                nameTextField.getText().isEmpty() ||
                cgpaTextField.getText().isEmpty() ||
                dateBox.getValue().isAfter(LocalDate.now()) ||
                digitFound
        ){
            warningBox.setText("fill up properly");


        }

        else{
            warningBox.setText("Student add successfully");
            String gender="";

            if(maleRadioButton.isSelected())
                gender="Male";
            else if (femaleRadioButton.isSelected())
                gender="Female";

            ArrayList<String> skillSet=  new ArrayList<String>();
            if(javaCheckBox.isSelected() && pythonCheckBox.isSelected() ){
                skillSet.add("Java");
                skillSet.add("Python");
            }
            else if (javaCheckBox.isSelected())
                skillSet.add("Java");
            else if (pythonCheckBox.isSelected())
                skillSet.add("Python");

            Student studentToBeAdded=new Student (
                    Integer.parseInt(idTextFiield.getText()),
                    nameTextField.getText(),
                    majorComboBox.getValue(),
                    gender,
                    Arrays.toString(skillSet.toArray()),
                    Float.parseFloat(cgpaTextField.getText()),
                    dateBox.getValue()
            );
            studentInfoTable.getItems().add(studentToBeAdded);
            studentList.add(studentToBeAdded);
        }


    }

    @FXML
    void showMaleAction(ActionEvent event) {
        studentInfoTable.getItems().clear();
        for(Student s: studentList){
            if(s.getGender().equals("Male"))
                studentInfoTable.getItems().add(s);
        }

    }

    @FXML
    void showFeMaleAction(ActionEvent event) {

    }

    @FXML
    void initialize(){
        studentList=new ArrayList<>();
        tg= new ToggleGroup();
        maleRadioButton.setToggleGroup(tg);
        femaleRadioButton.setToggleGroup(tg);
        dateBox.setValue(LocalDate.now());

        majorComboBox.getItems().addAll("CSE","EEE","BBA","CIVIL");

        idTableColumn.setCellValueFactory(new PropertyValueFactory<Student,String>("id"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
        majorTableColumn.setCellValueFactory(new PropertyValueFactory<Student,String>("major"));
        genderTableColumn.setCellValueFactory(new PropertyValueFactory<Student,String>("gender"));
        skillsTableColumn.setCellValueFactory(new PropertyValueFactory<Student,String>("skills"));
        cgpaTableColumn.setCellValueFactory(new PropertyValueFactory<Student,String>("cgpa"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<Student,String>("DOB"));

    }

}
