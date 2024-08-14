package org.example;

import java.util.Random;

public class ComputerPlayer extends Player {
    public int[] getComputerCoordinates () {
        Random random = new Random();
        int row = random.nextInt(3);
        int col = random.nextInt(3);
        return new int[]{row, col};
    }
}

