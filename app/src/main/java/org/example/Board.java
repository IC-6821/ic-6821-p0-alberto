package org.example;
import java.util.Random;

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

    public void playerMove(String input) {
        int[] move = parseMove(input);
        if (makeMove(move[0], move[1], 'X')) {
            System.out.println("El jugador ha realizado su jugada:");
        }
    }

    public void computerMove() {
        while (true) {
            Random random = new Random();
            int row = random.nextInt(3);
            int column = random.nextInt(3);

            if (makeMove(row, column, 'O')) {
                System.out.println("El ordenador ha realizado su jugada:");
                break;
            }
        }
    }

    public boolean makeMove(int row, int column, char symbol) {
        if (board[row][column] == ' ') {
            board[row][column] = symbol;
            return true;
        } else {
            return false;
        }
    }

    public boolean isPositionAvailable(int row, int column) {
        return board[row][column] == ' ';
    }

    private int[] parseMove(String input) {
        int row = 0, column = 0;

        switch (input) {
            case "arriba izquierda":
                row = 0; column = 0; break;
            case "arriba centro":
                row = 0; column = 1; break;
            case "arriba derecha":
                row = 0; column = 2; break;
            case "medio izquierda":
                row = 1; column = 0; break;
            case "medio centro":
                row = 1; column = 1; break;
            case "medio derecha":
                row = 1; column = 2; break;
            case "abajo izquierda":
                row = 2; column = 0; break;
            case "abajo centro":
                row = 2; column = 1; break;
            case "abajo derecha":
                row = 2; column = 2; break;
        }

        return new int[]{row, column};
    }
}

