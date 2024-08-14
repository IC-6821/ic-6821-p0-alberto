package org.example;

public class Board {
    public char[][] board;
    private final int boardSize = 3;

    //Constructor del tablero como una matriz
    public Board() {
        board = new char[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void displayBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.print(board[i][j]);
                if (j < boardSize - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < boardSize - 1) {
                System.out.println("-----");
            }
        }
    }

}

