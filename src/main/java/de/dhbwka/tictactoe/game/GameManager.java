package de.dhbwka.tictactoe.game;

import de.dhbwka.tictactoe.game.enums.GameStateEnum;
import de.dhbwka.tictactoe.game.enums.PlayerEnum;
import de.dhbwka.tictactoe.Main;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Random;

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
            turn(x, y);
        }
    }

    public void aiTurn() {
        int[] bestMove = minimax(PlayerEnum.AI);
        turn(bestMove[0], bestMove[1]);
    }

    private int[] minimax(PlayerEnum player) {
        // Initialize variables
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        int bestX = -1;
        int bestY = -1;

        // Return score if the game (minimax) is finished
        if (getGameState() != GameStateEnum.UNFINISHED) {
            return new int[]{ bestX, bestY, getGameState().getScore() };
        }

        // Loop through board
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                // Check if field is empty
                if (board.isEmpty(x, y)) {
                    if (player == PlayerEnum.AI) {
                        // Maximizing
                        board.set(x, y, PlayerEnum.AI);
                        int score = minimax(PlayerEnum.PLAYER)[2];

                        if (score > min) {
                            min = score;
                            bestX = x;
                            bestY = y;
                        }
                    } else {
                        // Minimizing
                        board.set(x, y, PlayerEnum.PLAYER);
                        int score = minimax(PlayerEnum.AI)[2];

                        if (score < max) {
                            max = score;
                            bestX = x;
                            bestY = y;
                        }
                    }
                    // Reset board
                    board.reset(x, y);
                }
            }
        }

        // Return result
        return new int[]{ bestX, bestY, player.equals(PlayerEnum.AI) ? min : max };
    }

    private void turn(int x, int y) {
        board.set(x, y);
        String symbol = playerManager.getSymbol();
        Platform.runLater(() -> {
            Button pressedField = (Button) Main.getRoot().lookup("#" + x + y);
            pressedField.setText(symbol);
        });

        playerManager.next();
        if (!getGameState().equals(GameStateEnum.UNFINISHED)) {
            String message = getGameState().getMessage();
            Platform.runLater(() -> {
                Main.setRoot("menu");
                Label resultLabel = (Label) Main.getRoot().lookup("#result");
                resultLabel.setText(message);
            });
            board.clear();
            playerManager.random();
        } else {
            if (playerManager.isAI()) {
                Main.getRoot().lookupAll("#").forEach(n -> n.setDisable(true));
                new Thread(() -> {
                    try {
                        Thread.sleep(new Random().nextInt(500) + 500);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                    aiTurn();
                    Main.getRoot().lookupAll("#").forEach(n -> n.setDisable(false));
                }).start();
            }
        }
    }

    private GameStateEnum getGameState() {
        if (board.hasFullRow(PlayerEnum.PLAYER)) return GameStateEnum.PLAYER_WIN;
        if (board.hasFullRow(PlayerEnum.AI)) return GameStateEnum.AI_WIN;
        if (board.isFull()) return GameStateEnum.TIE;
        return GameStateEnum.UNFINISHED;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }

    public static GameManager getInstance() {
        return instance;
    }
}
