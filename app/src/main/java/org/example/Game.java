package org.example;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class Game {
    public static final int BOARD_SIZE = 3;
    public Board board;

    private static final List<String> validMoves = Arrays.asList(
            "arriba izquierda", "arriba centro", "arriba derecha",
            "medio izquierda", "medio centro", "medio derecha",
            "abajo izquierda", "abajo centro", "abajo derecha"
    );

    public Game() {
        board = new Board();
    }

    public boolean checkWin(char[][] matrix) {
        if (checkDraw(matrix)){
            return false;
        }
        return checkRows(matrix) || checkColumns(matrix) || checkDiagonals(matrix);
    }

    private boolean checkRows(char[][] matrix) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            if (matrix[row][0] == matrix[row][1] && matrix[row][1] == matrix[row][2] && matrix[row][0] != ' ') {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns(char[][] matrix) {
        for (int column = 0; column < BOARD_SIZE; column++) {
            if (matrix[0][column] == matrix[1][column] && matrix[1][column] == matrix[2][column] && matrix[0][column] != ' ') {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals(char[][] matrix) {
        if ((matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2] && matrix[0][0] != ' ')
                || (matrix[0][2] == matrix[1][1] && matrix[1][1] == matrix[2][0] && matrix[0][2] != ' ')) {
            return true;
        }
        return false;
    }

    public boolean checkDraw(char[][] matrix) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                if (matrix[row][column] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static int[] parseUserInput(String input) {
        final String[] words = input.split(" ");

        final int yCoordinate;
        final int xCoordinate;

        switch (words[0]) {
            case "arriba":
                yCoordinate = 0;
                break;
            case "medio":
                yCoordinate = 1;
                break;
            case "abajo":
                yCoordinate = 2;
                break;
            default:
                throw new IllegalArgumentException("Invalid y-coordinate word: " + words[0]);
        }

        switch (words[1]) {
            case "izquierda":
                xCoordinate = 0;
                break;
            case "centro":
                xCoordinate = 1;
                break;
            case "derecha":
                xCoordinate = 2;
                break;
            default:
                throw new IllegalArgumentException("Invalid x-coordinate word: " + words[1]);
        }

        return new int[]{yCoordinate, xCoordinate};
    }

    public static boolean isValidPosition(int row, int col, char[][] board) {
        return board[row][col] == ' ';
    }
    
    public boolean isValidCharacter (String input){
        return validMoves.contains(input);
    }
}

