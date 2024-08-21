package org.example;

public final class Game {
    private final TicTacToeBoard board;
    private final Player computerPlayer;
    private final ConsoleInterface userInterface;
    private boolean gameOver;

    public Game() {
        board = new TicTacToeBoard();
        computerPlayer = new ComputerPlayer();
        userInterface = new ConsoleInterface();
        gameOver = false;
    }

    public void start() {
        userInterface.displayBoard(board);
        while (!gameOver) {
            final Coordinate coord = userInterface.getUserInput(board);
            if (board.makeMove(coord, TicTacToeBoard.Token.X)) {
                checkGameState();
                if (!gameOver) {
                    computerPlayer.makeMove(board, TicTacToeBoard.Token.O);
                    checkGameState();
                }
            }
            userInterface.displayBoard(board);
        }
    }

    private void checkGameState() {
        if (board.checkWin()) {
            userInterface.displayGameStateMessage();
            gameOver = true;
        } else if (board.checkDraw()) {
            userInterface.displayDrawMessage();
            gameOver = true;
        }
    }
}
