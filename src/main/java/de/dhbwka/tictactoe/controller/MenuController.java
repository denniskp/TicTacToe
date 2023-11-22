package de.dhbwka.tictactoe.controller;

import de.dhbwka.tictactoe.Main;
import de.dhbwka.tictactoe.game.GameManager;
import javafx.fxml.FXML;

public class MenuController {
    @FXML
    private void clickStart() {
        Main.setRoot("board");
    }
}
