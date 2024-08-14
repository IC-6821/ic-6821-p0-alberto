package org.example;

import java.util.Random;

public class ComputerPlayer extends Player {

    Board board = new Board();
    public int[] getComputerCoordinates () {
        Random random = new Random();
        int row = random.nextInt(3);
        int col = random.nextInt(3);
        while (true) {
            if (Game.isValidPosition(row, col, board.board)) {
                break;
            }
            row = random.nextInt(3);
            col = random.nextInt(3);
        }
        return new int[]{row, col};
    }
}

