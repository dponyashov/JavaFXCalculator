package ru.dponyashov.fxcalculator.fxcontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import ru.dponyashov.fxcalculator.CalculatorApplication;
import ru.dponyashov.fxcalculator.calculator.CalculatorImpl;
import ru.dponyashov.fxcalculator.exception.CalculatorException;

import java.io.IOException;

public class MainFXController {

    private final CalculatorController controller = new CalculatorController(new CalculatorImpl());

    @FXML
    private Button bAC;

    @FXML
    private Button bAddition;

    @FXML
    private Button bDivision;

    @FXML
    private Button bEight;

    @FXML
    private Button bEquals;

    @FXML
    private Button bExp;

    @FXML
    private Button bFive;

    @FXML
    private Button bFour;

    @FXML
    private Button bMultiplication;

    @FXML
    private Button bNine;

    @FXML
    private Button bOne;

    @FXML
    private Button bPercent;

    @FXML
    private Button bPoint;

    @FXML
    private Button bSeven;

    @FXML
    private Button bSix;

    @FXML
    private Button bSqrt;

    @FXML
    private Button bSubtraction;

    @FXML
    private Button bThree;

    @FXML
    private Button bTwo;

    @FXML
    private Button bZero;

    @FXML
    private TextField tfValue;

    @FXML
    protected void onDigitClick(ActionEvent event) {
        Button button = (Button) event.getTarget();
        tfValue.setText(controller.receiveDigit(button.getText()));
    }

    @FXML
    protected void onOperationClick(ActionEvent event) {
        Button button = (Button) event.getTarget();
        String operation = button.getText();
        try {
            tfValue.setText(controller.receiveOperation(operation));
        } catch (CalculatorException e){
            showMessageWindow(e.getMessage(), ((Node)event.getSource()).getScene().getWindow());
        }
    }

    private void showMessageWindow(String text, Window ownerWindow){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(CalculatorApplication.class.getResource("message-view.fxml"));
            VBox page = loader.load();
            Stage messageStage = new Stage();
            messageStage.setTitle("Сообщение");
            messageStage.initModality(Modality.WINDOW_MODAL);
            messageStage.initOwner(ownerWindow);
            messageStage.setScene(new Scene(page));
            MessageFXController messageController = loader.getController();
            messageController.setDialogStage(messageStage);
            messageController.setMessageText(text);
            messageStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}