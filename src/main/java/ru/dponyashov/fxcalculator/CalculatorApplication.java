package ru.dponyashov.fxcalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import ru.dponyashov.fxcalculator.fxcontroller.MessageFXController;

import java.io.IOException;

public class CalculatorApplication extends Application {
//    private Stage mainStage;
//
//    public Stage getMainStage() {
//        return mainStage;
//    }

    @Override
    public void start(Stage stage) throws IOException {
//        this.mainStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(CalculatorApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 440, 580);
        stage.setTitle("Калькулятор!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}