package de.dhbwka.tictactoe.game.enums;

import java.util.concurrent.ThreadLocalRandom;

public enum PlayerEnum {
    AI,
    PLAYER;

    public PlayerEnum getRandom() {
        return values()[ThreadLocalRandom.current().nextInt(values().length)];
    }

    public PlayerEnum next() {
        return values()[(this.ordinal() + 1) % values().length];
    }
}
