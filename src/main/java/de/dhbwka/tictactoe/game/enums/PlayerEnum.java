package de.dhbwka.tictactoe.game.enums;

public enum PlayerEnum {
    PLAYER1,
    PLAYER2;

    public PlayerEnum next() {
        return values()[(ordinal() + 1) % values().length];
    }
}
