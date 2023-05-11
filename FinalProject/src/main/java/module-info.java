module com.example.projectf {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projectf to javafx.fxml;
    exports com.example.projectf;
    exports Panes;
    opens Panes to javafx.fxml;
}