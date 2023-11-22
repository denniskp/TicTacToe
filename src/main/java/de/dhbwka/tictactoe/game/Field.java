package de.dhbwka.tictactoe.game;

import de.dhbwka.tictactoe.game.enums.FieldEnum;
import de.dhbwka.tictactoe.game.enums.PlayerEnum;

public class Field {
    private FieldEnum state;

    public Field() {
        reset();
    }

    public void reset() {
        state = FieldEnum.EMPTY;
    }

    public FieldEnum getState() {
        return state;
    }

    public void set() {
        state = FieldEnum.valueOf(GameManager.getInstance().getPlayerManager().getPlayer().name());
    }

    public void set(PlayerEnum playerEnum) {
        state = FieldEnum.valueOf(playerEnum.name());
    }

    public boolean isEmpty() {
        return state == FieldEnum.EMPTY;
    }
}
