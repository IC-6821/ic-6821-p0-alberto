package org.example;
import java.util.Arrays;
import java.util.List;

public final class Game {
    public static final int gameBoardSize = 3;
    public TicTacToeBoard board;

    private static final List<String> validMoves = Arrays.asList(
            "arriba izquierda", "arriba centro", "arriba derecha",
            "medio izquierda", "medio centro", "medio derecha",
            "abajo izquierda", "abajo centro", "abajo derecha"
    );

    public Game() {
        board = new TicTacToeBoard();
    }

    public boolean checkWin(char[][] gameBoard) {
        if (checkDraw(gameBoard)){
            return false;
        }
        return checkRows(gameBoard) || checkColumns(gameBoard)
                || checkDiagonals(gameBoard);
    }

    private boolean checkRows(char[][] gameBoard) {
        for (int boardRow = 0; boardRow < gameBoardSize; boardRow++) {
            if ((gameBoard[boardRow][0] == gameBoard[boardRow][1])
                    && (gameBoard[boardRow][1] == gameBoard[boardRow][2])
                    && (gameBoard[boardRow][0] != ' ')) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns(char[][] gameBoard) {
        for (int boardColumn = 0; boardColumn < gameBoardSize; boardColumn++) {
            if ((gameBoard[0][boardColumn] == gameBoard[1][boardColumn])
                    && (gameBoard[1][boardColumn] == gameBoard[2][boardColumn])
                    && (gameBoard[0][boardColumn] != ' ')) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals(char[][] gameBoard) {
        if (((gameBoard[0][0] == gameBoard[1][1])
                && (gameBoard[1][1] == gameBoard[2][2])
                && (gameBoard[0][0] != ' '))
                || ((gameBoard[0][2] == gameBoard[1][1])
                && (gameBoard[1][1] == gameBoard[2][0])
                && (gameBoard[0][2] != ' '))) {
            return true;
        }
        return false;
    }

    public boolean checkDraw(char[][] gameBoard) {
        for (int BoardRow = 0; BoardRow < gameBoardSize; BoardRow++) {
            for (int boardColumn = 0; boardColumn < gameBoardSize; boardColumn++) {
                if (gameBoard[BoardRow][boardColumn] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static int[] convertUserInputToPosition(String userInput) {
        final String[] words = userInput.split(" ");

        final int placeInColumn;
        final int placeInRow;

        switch (words[0]) {
            case "arriba":
                placeInColumn = 0;
                break;
            case "medio":
                placeInColumn = 1;
                break;
            case "abajo":
                placeInColumn = 2;
                break;
            default:
                throw new IllegalArgumentException("Invalid column placement: "
                        + words[0]);
        }

        switch (words[1]) {
            case "izquierda":
                placeInRow = 0;
                break;
            case "centro":
                placeInRow = 1;
                break;
            case "derecha":
                placeInRow = 2;
                break;
            default:
                throw new IllegalArgumentException("Invalid row placement: " + words[1]);
        }

        return new int[]{placeInColumn, placeInRow};
    }

    public static boolean isValidPosition(int boardRow, int boardColumn,
                                          char[][] gameBoard) {
        return gameBoard[boardRow][boardColumn] == ' ';
    }
    
    public boolean isValidUserInput(String input){
        return validMoves.contains(input);
    }
}

