package org.example;
import java.util.Map;

public class Board {

    public enum Token {
        X, O
    }

    private final Token[][] board;
    private final int BOARD_SIZE = 3;

    public Board() {
        board = new Token[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = null;
            }
        }
    }

    private final Map<String, Row> rowMapping = Map.of(
            "arriba", Row.TOP,
            "medio", Row.MIDDLE,
            "abajo", Row.BOTTOM
    );

    private final Map<String, Column> columnMapping = Map.of(
            "izquierda", Column.LEFT,
            "medio", Column.MIDDLE,
            "derecha", Column.RIGHT
    );

    private enum Row {
        TOP("arriba"), MIDDLE("medio"), BOTTOM("abajo");
        private final String textValue;
        Row(String textValue) {
            this.textValue = textValue;
        }
    }

    private enum Column {
        LEFT("izquierda"), MIDDLE("medio"), RIGHT("derecha");
        private final String textValue;
        Column(String textValue) {
            this.textValue = textValue;
        }
    }

    public Token getCellValue(Coordinate cord) {
        return board[cord.getRow()][cord.getColumn()];
    }

/*
    public void displayBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.print(board[i][j]);
                if (j < boardSize - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < boardSize - 1) {
                System.out.println("-----");
            }
        }
    }
*/

    public boolean checkWin() {
        if (checkDraw()) {
            return false;
        }
        return checkRows() || checkColumns() || checkDiagonals();
    }

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

    // Verificar diagonales
    private boolean checkDiagonals() {
        if (board[0][0] != null && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[0][2] != null && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        return false;
    }
}
