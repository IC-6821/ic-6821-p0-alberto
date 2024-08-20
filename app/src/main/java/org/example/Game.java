package org.example;

public class Game {
    private final TicTacToeBoard board;
    private final Player humanPlayer;
    private final Player computerPlayer;
    private boolean gameOver;

    public Game() {
        board = new TicTacToeBoard();
        humanPlayer = new HumanPlayer();
        computerPlayer = new ComputerPlayer();
        gameOver = false;
    }

    public void start() {
        UserInterface.showBoard();
        while (!gameOver) {
            humanPlayer.makeMove(board, TicTacToeBoard.Token.X); //Asumiendo que maneja todo la logica
            checkGameState();
            if (!gameOver) {
                computerPlayer.makeMove(board, TicTacToeBoard.Token.O);
                checkGameState();
            }
            UserInterface.showBoard();
        }
    }

    private void checkGameState() {
        if (board.checkWin()) {
            UserInterface.displayGameStateMessage();
            gameOver = true;
        } else if (board.checkDraw()) {
            UserInterface.displayLosingMessage();
            gameOver = true;
        }
    }
}

