package org.example;
import java.util.Map;

public final class TicTacToeBoard implements Board {
    private static final int BOARD_SIZE = 3;
    private final Token[][] board;

    // Constructor
    public TicTacToeBoard() {
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
    public boolean checkWin() {
        if (checkDraw()) {
            return false;
        }
        return checkRows() || checkColumns() || checkDiagonals();
    }

    @Override
    public boolean checkDraw() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                if (board[row][column] == null) {
                    return false; // Hay al menos una celda vacía
                }
            }
        }
        return true;
    }

    private boolean checkRows() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            if (board[row][0] != null && board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int column = 0; column < BOARD_SIZE; column++) {
            if (board[0][column] != null && board[0][column] == board[1][column] && board[1][column] == board[2][column]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        if (board[0][0] != null && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[0][2] != null && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        return false;
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
                "medio", Column.MIDDLE,
                "derecha", Column.RIGHT
        );
    }

    @Override
    public void setCell(Coordinate coord, Token playerSymbol) {
        if (isPositionAvailable(coord)) {
            board[coord.row()][coord.column()] = playerSymbol;
        } else {
            throw new IllegalArgumentException("Position is already occupied");
        }
    }

    @Override
    public boolean isPositionAvailable(Coordinate coord) {
        return board[coord.row()][coord.column()] == null;
    }

    @Override
    public boolean makeMove(Coordinate coord, Token symbol) {
        if (board[coord.row()][coord.column()] == null) {
            setCell(coord, symbol);
            return true;
        } else {
            return false;
        }
    }

}
