package de.dhbwka.tictactoe.controller;

import de.dhbwka.tictactoe.game.GameManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class BoardController {
    @FXML
    private void clickField(ActionEvent event) {
        String id = ((Button) event.getSource()).getId();
        int x = Character.getNumericValue(id.charAt(0));
        int y = Character.getNumericValue(id.charAt(1));
        GameManager.getInstance().playerTurn(x, y);
    }
}
