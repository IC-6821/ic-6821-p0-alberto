package org.example;

import java.util.Random;

public final class ComputerPlayer implements Player {
    public static final int BOARD_SIZE = 3;

    public void makeMove(TicTacToeBoard board, TicTacToeBoard.Token playerSymbol) {
        board.setCell(generateCoordinatesEasy(board), playerSymbol);
    }

    public Coordinate generateCoordinatesEasy(TicTacToeBoard board) {
        final Random random = new Random();
        int row = 0;
        int col = 0;
        boolean foundAvailablePosition = false;
        while (!foundAvailablePosition) {
            row = random.nextInt(BOARD_SIZE);
            col = random.nextInt(BOARD_SIZE);

            final Coordinate coord = new Coordinate(row, col);
            foundAvailablePosition = board.isPositionAvailable(coord);
        }
        return new Coordinate(row, col);
    }
}
