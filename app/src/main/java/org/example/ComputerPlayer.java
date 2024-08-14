package org.example;

import java.util.Random;

public class ComputerPlayer extends Player {
    public int[] getComputerCoordinates(char[][] board) {
        Random random = new Random();
        int row, col;
        while (true) {
            row = random.nextInt(3);
            col = random.nextInt(3);

            if (Game.isValidPosition(row, col, board)) {
                break;
            }
        }
        return new int[]{row, col};
    }
}

