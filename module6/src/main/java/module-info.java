module edu.au.cpsc.module6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.au.cpsc.module6 to javafx.fxml;
    exports edu.au.cpsc.module6;

    exports edu.au.cpsc.part1;
    opens edu.au.cpsc.part1 to javafx.fxml;
    exports edu.au.cpsc.model;
    opens edu.au.cpsc.model to javafx.fxml;
}