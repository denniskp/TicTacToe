package de.dhbwka.tictactoe.game;

import de.dhbwka.tictactoe.game.enums.PlayerEnum;

import java.util.HashMap;
import java.util.Map;

public class PlayerManager {
    private final Map<PlayerEnum, String> players = new HashMap<>();
    private PlayerEnum currentPlayer;

    public PlayerEnum getCurrentPlayer() {
        return currentPlayer;
    }

    public PlayerManager() {
        reset();
        players.put(currentPlayer, "⨉");
        players.put(currentPlayer.next(), "⭕");
    }

    public void next() {
        currentPlayer = currentPlayer.next();
    }

    public String getSymbol() {
        return players.get(currentPlayer);
    }

    public void reset() {
        currentPlayer = PlayerEnum.PLAYER1;
    }
}
