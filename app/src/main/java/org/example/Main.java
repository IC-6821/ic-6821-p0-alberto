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

            int[] coordinates = Game.parseUserInput(userInput);
            int row = coordinates[0];
            int col = coordinates[1];

            while (!Game.isValidPosition(row, col, board.board) || !game.isValidCharacter(userInput)) {
                System.out.println("Movimiento no valido, intentalo de nuevo.");
                userInput = scanner.nextLine().trim().toLowerCase();
                coordinates = Game.parseUserInput(userInput);
                row = coordinates[0];
                col = coordinates[1];
            }

            Player.makeMove(row, col, board.board, 'X');

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
            int[] computerCoordinates = computerPlayer.getComputerCoordinates();
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