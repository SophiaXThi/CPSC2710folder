module edu.au.cpsc.module3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.compiler;


    opens edu.au.cpsc.module3 to javafx.fxml;
    exports edu.au.cpsc.module3;
}