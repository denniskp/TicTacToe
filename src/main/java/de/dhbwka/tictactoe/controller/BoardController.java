package de.dhbwka.tictactoe.controller;

import de.dhbwka.tictactoe.game.GameManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class BoardController {
    @FXML
    private void clickField(ActionEvent event) {
        String id = ((Button) event.getSource()).getId();
        int x = Integer.parseInt(id.substring(0, 1));
        int y = Integer.parseInt(id.substring(1, 2));
        GameManager.getInstance().playerTurn(x, y);
    }
}
