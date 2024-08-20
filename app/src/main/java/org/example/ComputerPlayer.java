package org.example;

import java.util.Random;

public class ComputerPlayer implements Player {
    public static final int BOARD_SIZE = 3;

    public void makeMove(TicTacToeBoard board, TicTacToeBoard.Token playerSymbol) {
        TicTacToeBoard.setCell(generateCoordinatesEasy(board), playerSymbol);
    }

    public Coordinate generateCoordinatesEasy(TicTacToeBoard board) {
        Random random = new Random();
        boolean foundAvailablePosition = false;
        while (!foundAvailablePosition) {
            int row = random.nextInt(BOARD_SIZE);
            int col = random.nextInt(BOARD_SIZE);

            Coordinate coord = new Coordinate(row, col);
            foundAvailablePosition = TicTacToeBoard.isPositionAvailable(coord);
        }
        return new Coordinate(row, col);
    }
}