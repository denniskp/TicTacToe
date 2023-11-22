package de.dhbwka.tictactoe.game.enums;

public enum GameStateEnum {
    AI_WIN("Bot wins!", 1),
    PLAYER_WIN("Player wins!", -1),
    TIE("Tie!", 0),
    UNFINISHED("", 0);

    private final String message;
    private final int score;

    GameStateEnum(String s, int i) {
        this.message = s;
        this.score = i;
    }

    public String getMessage() {
        return message;
    }

    public int getScore() {
        return score;
    }
}
