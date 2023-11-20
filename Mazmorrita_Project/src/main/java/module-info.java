module com.project.mazmorrita_project {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.project.mazmorrita_project.controllers to javafx.fxml;
    exports com.project.mazmorrita_project.controllers;
    exports com.project.mazmorrita_project;
    opens com.project.mazmorrita_project to javafx.fxml;

}