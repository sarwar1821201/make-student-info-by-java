package com.example.studentdemoproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

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
    private TextField filtercgpaTextField;

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
       float cgpaSum=0;
       for(Student s: studentInfoTable.getItems()){
           cgpaSum=cgpaSum+s.getCgpa();
       }
       float averageCgpa=cgpaSum/studentInfoTable.getItems().size();
       averageCGPAArea.setText("Average CGPA is = "+ averageCgpa);

    }

    @FXML
    void addStudentActionButton(ActionEvent event) {
        boolean digitFound=false;
        for(int i=0; i<nameTextField.getText().length(); i++){
            if(nameTextField.getText().charAt(i) >='0' && nameTextField.getText().charAt(i) <='9'){
                digitFound=true;
            }
        }

        if(
                nameTextField.getText().isEmpty() ||
                cgpaTextField.getText().isEmpty() ||
                dateBox.getValue().isAfter(LocalDate.now()) ||
                digitFound
        ){
            //warningBox.setText("fill up properly");
            Alert errorAlert= new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("fill up the form properly ");
            errorAlert.show();
        }

        else{

            boolean sameNameFound=false;
            for(Student s: studentList){
                if(s.getName().equals(nameTextField.getText())){
                    sameNameFound=true;
                }
            }

            if(sameNameFound){
                warningBox.setText("same name found");
            }

            else{
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

                /// random digit

                Random r=new Random();
              //  int id=r.nextInt(10000);
                String id=String.format("%04d", r.nextInt(10000));
                idTextFiield.setText(id);


                Student studentToBeAdded=new Student (
                        Integer.parseInt(idTextFiield.getText()),
                        nameTextField.getText(),
                        majorComboBox.getValue(),
                        gender,
                        Arrays.toString(skillSet.toArray()),
                        Float.parseFloat(cgpaTextField.getText()),
                        dateBox.getValue()
                );

                Alert confirmAlert=new Alert(Alert.AlertType.CONFIRMATION);
                confirmAlert.setContentText("Are You Sure??");
                confirmAlert.showAndWait().ifPresent(response ->{
                    if(response== ButtonType.OK){
                        studentInfoTable.getItems().add(studentToBeAdded);
                        studentList.add(studentToBeAdded);

                        idTextFiield.clear();
                        nameTextField.clear();
                        cgpaTextField.clear();
                        maleRadioButton.setSelected(false);
                        femaleRadioButton.setSelected(false);
                        javaCheckBox.setSelected(false);
                        pythonCheckBox.setSelected(false);
                        warningBox.setText("Student add successfully");
                        warningBox.setStyle("-fx-border-color: green");

                    }
                });

            }

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
      studentInfoTable.getItems().clear();
      for(Student s: studentList){
          if(s.getGender().equals("Female"))
              studentInfoTable.getItems().add(s);
      }
    }


    @FXML
    void showMostSeniourStudentButton(ActionEvent event) {
     ArrayList<Integer>ageList=new ArrayList<Integer>();
     for(Student s: studentInfoTable.getItems()){
         ageList.add(s.calculateAge());
     }

   int maximumAge=ageList.get(0);
     for(int i=1; i<ageList.size();i++){
         if(maximumAge<ageList.get(i)){
             maximumAge=ageList.get(i);
         }
     }

     String mostSeniorStudent="";
     for(Student s: studentInfoTable.getItems()){
         if(s.calculateAge()==maximumAge){
             mostSeniorStudent=s.getName();
         }
     }

     averageCGPAArea.setText("The age of most senior student is :"+ maximumAge + "\n" +
             "Student Name :" + mostSeniorStudent);

    }

    @FXML
    void filterCGPAButtonOnClick(ActionEvent event) {
        studentInfoTable.getItems().clear();

        for(Student s: studentList){
            if(s.getCgpa()>= Float.parseFloat(filtercgpaTextField.getText())){
                studentInfoTable.getItems().add(s);
            }
        }

    }


    @FXML
    void initialize(){
        studentList=new ArrayList<>();
        idTextFiield.setEditable(false);
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
