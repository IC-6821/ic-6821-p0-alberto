package org.example;

import java.util.Random;

public class ComputerPlayer implements Player {
    public static final int BOARD_SIZE = 3;

    public void makeMove(Board board, Board.Token playerSymbol) {
        Board.setCell(generateCoordinatesEasy(board), playerSymbol);
    }

    public Coordinate generateCoordinatesEasy(Board board) {
        Random random = new Random();
        boolean foundAvailablePosition = false;
        while (!foundAvailablePosition) {
            int row = random.nextInt(BOARD_SIZE);
            int col = random.nextInt(BOARD_SIZE);

            Coordinate coord = new Coordinate(row, col);
            foundAvailablePosition = Board.isPositionAvailable(coord);
        }
        return new Coordinate(row, col);
    }
}