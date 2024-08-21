package org.example;

import java.util.Random;

import static org.example.TicTacToeBoardInterface.BOARD_SIZE;

public final class ComputerPlayerInterface implements PlayerInterface {
    public void makeMove(TicTacToeBoardInterface board, TicTacToeBoardInterface.Token playerSymbol) {
        board.setCell(generateCoordinatesEasy(board), playerSymbol);
    }

    public Coordinate generateCoordinatesEasy(TicTacToeBoardInterface board) {
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
