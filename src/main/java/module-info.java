module ru.dponyashov.fxcalculator {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens ru.dponyashov.fxcalculator to javafx.fxml;
    exports ru.dponyashov.fxcalculator;
    exports ru.dponyashov.fxcalculator.calculator;
    opens ru.dponyashov.fxcalculator.calculator to javafx.fxml;
    exports ru.dponyashov.fxcalculator.fxcontroller;
    opens ru.dponyashov.fxcalculator.fxcontroller to javafx.fxml;
}