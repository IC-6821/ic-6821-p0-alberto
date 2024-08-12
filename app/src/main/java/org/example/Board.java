package org.example;

public class Board {
        private char[][] board;
        private final int SIZE = 3;

        //Constructor del tablero como una matriz
        public Board() {
            board = new char[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    board[i][j] = ' ';
                }
            }
        }
}
