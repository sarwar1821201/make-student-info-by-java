module com.example.studentdemoproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.studentdemoproject to javafx.fxml;
    exports com.example.studentdemoproject;
}