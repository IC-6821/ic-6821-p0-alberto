package org.example;

import java.util.Arrays;
import java.util.List;

public class Player {
    public static void makeMove(int row, int col, char[][] board, char playerSymbol) {
        if (Game.isValidPosition(row, col, board)) {
            board[row][col] = playerSymbol;
        } else {
            System.out.println("Movimiento no válido, intenta nuevamente.");
        }
    }
}

