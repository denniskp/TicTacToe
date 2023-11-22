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

    public void set(PlayerEnum player) {
        state = FieldEnum.valueOf(player.name());
    }

    public boolean isEmpty() {
        return state == FieldEnum.EMPTY;
    }
}
