package org.example;
import java.util.Random;

public class Board {
        private char[][] gameBoard;
        private final int gameBoardSize = 3;

        //Constructor del tablero como una matriz
        public Board() {
            gameBoard = new char[gameBoardSize][gameBoardSize];
            for (int i = 0; i < gameBoardSize; i++) {
                for (int j = 0; j < gameBoardSize; j++) {
                    gameBoard[i][j] = ' ';
                }
            }
        }

    public void displayBoard() {
        for (int i = 0; i < gameBoardSize; i++) {
            for (int j = 0; j < gameBoardSize; j++) {
                System.out.print(gameBoard[i][j]);
                if (j < gameBoardSize - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < gameBoardSize - 1) {
                System.out.println("-----");
            }
        }
    }

}

