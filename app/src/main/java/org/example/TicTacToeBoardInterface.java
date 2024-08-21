package org.example;

import java.util.Map;

public final class TicTacToeBoardInterface implements BoardInterface {
    public static final int BOARD_SIZE = 3;
    private final Token[][] board;

    public TicTacToeBoardInterface() {
        board = new Token[BOARD_SIZE][BOARD_SIZE];
        initializeBoard();
    }

    @Override
    public void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = null;
            }
        }
    }

    @Override
    public Token getCellValue(Coordinate cord) {
        return board[cord.row()][cord.column()];
    }

    @Override
    public boolean checkWin(Token symbol) {
        return checkRows(symbol) || checkColumns(symbol) || checkDiagonals(symbol);
    }

    @Override
    public boolean checkDraw() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                if (board[row][column] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkRows(Token symbol) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            if (board[row][0] == symbol && board[row][1] == symbol && board[row][2] == symbol) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns(Token symbol) {
        for (int column = 0; column < BOARD_SIZE; column++) {
            if (board[0][column] == symbol && board[1][column] == symbol && board[2][column] == symbol) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals(Token symbol) {
        return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)
                || (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    @Override
    public Map<String, Row> getRowMapping() {
        return Map.of(
                "arriba", Row.TOP,
                "medio", Row.MIDDLE,
                "abajo", Row.BOTTOM
        );
    }

    @Override
    public Map<String, Column> getColumnMapping() {
        return Map.of(
                "izquierda", Column.LEFT,
                "centro", Column.MIDDLE,
                "derecha", Column.RIGHT
        );
    }

    @Override
    public void setCell(Coordinate coordinate, Token playerSymbol) {
        if (isPositionAvailable(coordinate)) {
            board[coordinate.row()][coordinate.column()] = playerSymbol;
        } else {
            throw new IllegalArgumentException("Position is already occupied");
        }
    }

    @Override
    public boolean isPositionAvailable(Coordinate coordinate) {
        return board[coordinate.row()][coordinate.column()] == null;
    }

    @Override
    public boolean makeMove(Coordinate coordinate, Token symbol) {
        if (board[coordinate.row()][coordinate.column()] == null) {
            setCell(coordinate, symbol);
            return true;
        } else {
            return false;
        }
    }

}
