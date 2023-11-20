module com.project.mazmorrita_project {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.project.mazmorrita_project to javafx.fxml;
    exports com.project.mazmorrita_project;
    exports com.project.mazmorrita_project.apps;
    opens com.project.mazmorrita_project.apps to javafx.fxml;
    exports com.project.mazmorrita_project.controllers;
    opens com.project.mazmorrita_project.controllers to javafx.fxml;
}