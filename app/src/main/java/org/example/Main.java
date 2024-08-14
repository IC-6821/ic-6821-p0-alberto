package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        Board board = new Board();
        ComputerPlayer computerPlayer = new ComputerPlayer();
        boolean gameOver = false;

        System.out.println("¡Bienvenido al Tic-Tac-Toe!");
        board.displayBoard();

        while (!gameOver) {
            //turno del jugador
            System.out.println("Introduce un movimiento: ");
            String userInput = scanner.nextLine().trim().toLowerCase();

            int[] coordinates;
            int boardRow, boardColumn;

            while (true) {
                if (!game.isValidUserInput(userInput)) {
                    System.out.println("Movimiento no válido, intenta de nuevo.");
                    userInput = scanner.nextLine().trim().toLowerCase();
                    continue;
                }

                coordinates = Game.convertUserInputToPosition(userInput);
                boardRow = coordinates[0];
                boardColumn = coordinates[1];

                if (Game.isValidPosition(boardRow, boardColumn, board.board)) {
                    break;
                } else {
                    System.out.println("La casilla ya está ocupada. Inténtalo de nuevo.");
                    userInput = scanner.nextLine().trim().toLowerCase();
                }
            }

            Player.makeMove(boardRow, boardColumn, board.board, 'X');

            //llamadas a game para verificar el estado del juego
            if (game.checkWin(board.board)) {
                System.out.println("Felicidades, has ganado.");
                gameOver = true;
                break;
            } else if (game.checkDraw(board.board)) {
                System.out.println("La partida termino en empate.");
                gameOver = true;
                break;
            }

            //turno de la maquina
            int[] computerCoordinates = computerPlayer.getComputerCoordinates(board.board);
            int computerRow = computerCoordinates[0];
            int computerCol = computerCoordinates[1];

            ComputerPlayer.makeMove(computerRow, computerCol, board.board, 'O');

            board.displayBoard();

            //llamadas a game para verificar el estado del juego
            if (game.checkWin(board.board)) {
                System.out.println("La computadora ha ganado.");
                gameOver = true;
            } else if (game.checkDraw(board.board)) {
                System.out.println("La partida termino en empate.");
                gameOver = true;
            }
        }

        System.out.println("Fin del juego.");
        scanner.close();
    }
}