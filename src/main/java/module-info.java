module kth.se.lab3b {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens kth.se.lab3b to javafx.fxml;
    exports kth.se.lab3b;
}