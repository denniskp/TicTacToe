package de.dhbwka.tictactoe.game;

import de.dhbwka.tictactoe.game.enums.GameStateEnum;
import de.dhbwka.tictactoe.game.enums.PlayerEnum;
import de.dhbwka.tictactoe.Main;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GameManager {
    private static GameManager instance;

    private final PlayerManager playerManager;
    private final Board board;

    public GameManager() {
        instance = this;

        playerManager = new PlayerManager();
        board = new Board();
    }

    public void playerTurn(int x, int y) {
        if (board.isEmpty(x, y)) {
            turn(x, y, playerManager.getCurrentPlayer());
        }
    }

    private void turn(int x, int y, PlayerEnum player) {
        board.set(x, y, player);
        String symbol = playerManager.getSymbol();
        Platform.runLater(() -> ((Button) Main.getRoot().lookup(String.format("#%d%d", x, y))).setText(symbol));
        playerManager.next();

        if (!getGameState().equals(GameStateEnum.UNFINISHED)) {
            String message = getGameState().getMessage();
            Platform.runLater(() -> {
                Main.setRoot("menu");
                ((Label) Main.getRoot().lookup("#result")).setText(message);
            });

            board.clear();
            playerManager.reset();
        }
    }

    private GameStateEnum getGameState() {
        if (board.hasFullRow(PlayerEnum.PLAYER1)) {
            return GameStateEnum.PLAYER1_WIN;
        }
        else if (board.hasFullRow(PlayerEnum.PLAYER2)) {
            return GameStateEnum.PLAYER2_WIN;
        }
        else if (board.isFull()) {
            return GameStateEnum.TIE;
        }
        return GameStateEnum.UNFINISHED;
    }

    public static GameManager getInstance() {
        return instance;
    }
}
