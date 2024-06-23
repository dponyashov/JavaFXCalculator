package ru.dponyashov.fxcalculator.fxcontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MessageFXController {
    private Stage messageStage;

    @FXML
    private Label messageText;

    @FXML
    protected void onButtonClick() {
        messageStage.close();
    }

    public void setDialogStage(Stage messageStage) {
        this.messageStage = messageStage;
    }

    public void setMessageText(String text) {
        messageText.setText(text);
    }
}