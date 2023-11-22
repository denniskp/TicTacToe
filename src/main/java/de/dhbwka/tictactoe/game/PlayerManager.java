package de.dhbwka.tictactoe.game;

import de.dhbwka.tictactoe.game.enums.PlayerEnum;

import java.util.HashMap;
import java.util.Map;

public class PlayerManager {
    private final Map<PlayerEnum, String> map = new HashMap<>();
    private PlayerEnum player;

    public PlayerEnum getPlayer() {
        return player;
    }

    public PlayerManager() {
        player = PlayerEnum.PLAYER;
        random();
    }

    public void random() {
        player = player.getRandom();
        map.put(player, "⨉");
        map.put(player.next(), "⭕");
    }

    public void next() {
        player = player.next();
    }

    public boolean isAI() {
        return player == PlayerEnum.AI;
    }

    public String getSymbol() {
        return map.get(player);
    }
}
