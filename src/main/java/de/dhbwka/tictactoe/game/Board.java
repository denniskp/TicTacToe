package de.dhbwka.tictactoe.game;

import de.dhbwka.tictactoe.game.enums.FieldEnum;
import de.dhbwka.tictactoe.game.enums.PlayerEnum;

import java.util.stream.Stream;

public class Board {
    private final Field[][] board = new Field[3][3];

    public Board() {
        init();
    }

    private void init() {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board.length; y++) {
                board[x][y] = new Field();
            }
        }
    }

    public void clear() {
        Stream.of(board).forEach(it -> Stream.of(it).forEach(Field::reset));
    }

    public void reset(int x, int y) {
        board[x][y].reset();
    }

    public FieldEnum getFieldState(int x, int y) {
        return board[x][y].getState();
    }

    public boolean isEmpty(int x, int y){
        return getFieldState(x, y).equals(FieldEnum.EMPTY);
    }

    public void set(int x, int y) {
        board[x][y].set();
    }

    public void set(int x, int y, PlayerEnum player) {
        board[x][y].set(player);
    }

    public boolean isFull() {
        return Stream.of(board).allMatch(it -> Stream.of(it).noneMatch(Field::isEmpty));
    }

    public boolean hasFullRow(PlayerEnum player) {
        if (getItemsInRow(0, 0, 1, 1, player) == board.length) return true;
        if (getItemsInRow(2, 0, -1, 1, player) == board.length) return true;
        for (int x = 0; x < board.length; x++) {
            if (getItemsInRow(x, 0, 0, 1, player) == board.length) return true;
        }
        for (int y = 0; y < board.length; y++) {
            if (getItemsInRow(0, y, 1, 0, player) == board.length) return true;
        }
        return false;
    }

    private int getItemsInRow(int x, int y, int xOffset, int yOffset, PlayerEnum player) {
        if (x >= board.length || y >= board.length) return 0;
        if (!board[x][y].getState().name().equals(player.name())) return 0;
        return 1 + getItemsInRow(x + xOffset, y + yOffset, xOffset, yOffset, player);
    }
}
