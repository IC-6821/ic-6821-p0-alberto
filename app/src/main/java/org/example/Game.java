package org.example;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class Game {
    public static final int gameBoardSize = 3;
    private Board gameBoard;

    private static final List<String> validMoves = Arrays.asList(
            "arriba izquierda", "arriba centro", "arriba derecha",
            "medio izquierda", "medio centro", "medio derecha",
            "abajo izquierda", "abajo centro", "abajo derecha"
    );

    public Game() {
        gameBoard = new Board();
    }

    public boolean checkWin(char[][] gameBoard) {
        if (checkDraw(gameBoard)){
            return false;
        }
        return checkRows(gameBoard) || checkColumns(gameBoard) || checkDiagonals(gameBoard);
    }

    private boolean checkRows(char[][] gameBoard) {
        for (int boardRow = 0; boardRow < gameBoardSize; boardRow++) {
            if (gameBoard[boardRow][0] == gameBoard[boardRow][1] && gameBoard[boardRow][1] == gameBoard[boardRow][2] && gameBoard[boardRow][0] != ' ') {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns(char[][] gameBoard) {
        for (int boardColumn = 0; boardColumn < gameBoardSize; boardColumn++) {
            if (gameBoard[0][boardColumn] == gameBoard[1][boardColumn] && gameBoard[1][boardColumn] == gameBoard[2][boardColumn] && gameBoard[0][boardColumn] != ' ') {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals(char[][] gameBoard) {
        return (gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2] && gameBoard[0][0] != ' ')
                || (gameBoard[0][2] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][0] && gameBoard[0][2] != ' ');
    }

    public boolean checkDraw(char[][] gameBoard) {
        for (int boardRow = 0; boardRow < gameBoardSize; boardRow++) {
            for (int boardColumn = 0; boardColumn < gameBoardSize; boardColumn++) {
                if (gameBoard[boardRow][boardColumn] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private int[] convertUserInputToPosition(String playerInput) {
        final String[] words = playerInput.split(" ");

        final int placeInColumn, placeInRow;

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
                throw new IllegalArgumentException("Invalid column placement: " + words[0]);
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

    public boolean isValidPlayerMove(char[][] gameBoard, String playerInput) {
        final int[] pairRowColumn = convertUserInputToPosition(playerInput);
        final int boardRow = pairRowColumn[1];
        final int boardColumn = pairRowColumn[0];

        return gameBoard[boardRow][boardColumn] == ' ';
    }

    public void playerMove(String userInput, char[][] gameBoard) {
        char playerSymbol = 'X';
        if (isValidPlayerMove(gameBoard, userInput)) {
            int[] pairRowColumn = convertUserInputToPosition(userInput);
            gameBoard[pairRowColumn[0]][pairRowColumn[1]] = playerSymbol;
        } else {
            System.out.println("Invalid move. Try again.");
        }
    }

    public void computerMove(char[][] gameBoard) {
        char computerSymbol = 'O';
        Random assignRandomMove = new Random();
        int boardRow, boardColumn;

        do {
            boardRow = assignRandomMove.nextInt(gameBoardSize);
            boardColumn = assignRandomMove.nextInt(gameBoardSize);
        } while (gameBoard[boardRow][boardColumn] != ' ');

        gameBoard[boardRow][boardColumn] = computerSymbol;
    }

    public boolean isValidCharacter (String input){
        return validMoves.contains(input);
    }
}


