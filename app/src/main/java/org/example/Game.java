package org.example;

public final class Game {
    private final TicTacToeBoard board;
    private final Player computerPlayer;
    private final ConsoleInterface userInterface;
    private boolean gameOver;

    public Game() {
        board = new TicTacToeBoard();
        computerPlayer = new ComputerPlayer();
        userInterface = new ConsoleInterface(board);
        gameOver = false;
    }

    public void start() {
        userInterface.displayBoard(board);
        boolean validMove = false;
        while (!gameOver) {
            final Coordinate coord = userInterface.getUserInput(board);
            while (!validMove) {
                if (board.makeMove(coord, TicTacToeBoard.Token.X)) {
                    validMove = true;
                }
            }
            if (!gameOver) {
                computerPlayer.makeMove(board, TicTacToeBoard.Token.O);
                checkGameState();
            }
            userInterface.displayBoard(board);
        }
    }

    private void checkGameState() {
        if (board.checkWin()) {
            userInterface.displayGameStateMessage();
            gameOver = true;
        } else if (board.checkDraw()) {
            userInterface.displayLosingMessage();
            gameOver = true;
        }
    }
}
