module edu.au.cpsc.module {
    requires javafx.controls;
    requires javafx.fxml;

    opens edu.au.cpsc.miscstyle to javafx.fxml;
    exports edu.au.cpsc.miscstyle;

    opens edu.au.cpsc.launcher to javafx.fxml;
    exports edu.au.cpsc.launcher;
}