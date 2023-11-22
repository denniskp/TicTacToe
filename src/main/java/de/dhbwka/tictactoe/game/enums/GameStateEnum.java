package de.dhbwka.tictactoe.game.enums;

public enum GameStateEnum {
    PLAYER1_WIN("Player 1 wins!"),
    PLAYER2_WIN("Player 2 wins!"),
    TIE("Tie!"),
    UNFINISHED("");

    private final String message;

    GameStateEnum(String s) {
        this.message = s;
    }

    public String getMessage() {
        return message;
    }
}
