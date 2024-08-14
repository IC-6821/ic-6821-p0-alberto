package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        Board board = new Board();
        boolean gameOver = false;

        System.out.println("¡Bienvenido al Tic-Tac-Toe!");
        board.displayBoard();

        while (!gameOver) {
            //turno del jugador
            System.out.println("Introduce un movimiento: ");
            String userInput = scanner.nextLine().trim().toLowerCase();

            while (!game.isValidCharacter(userInput)) {
                System.out.println("Movimiento no valido, intentalo de nuevo.");
                userInput = scanner.nextLine().trim().toLowerCase();
            }

            game.playerMove(userInput, board.board);
            board.displayBoard();

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
            game.computerMove(board.board);
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
