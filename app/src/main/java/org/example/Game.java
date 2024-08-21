package org.example;

public final class Game {
    private final TicTacToeBoardInterface board;
    private final PlayerInterface computerPlayerInterface;
    private final ConsoleInterface userInterface;
    private boolean gameOver;

    public Game() {
        board = new TicTacToeBoardInterface();
        computerPlayerInterface = new ComputerPlayerInterface();
        userInterface = new ConsoleInterface();
        gameOver = false;
    }

    public void start() {
        userInterface.displayBoard(board);
        while (!gameOver) {
            final Coordinate coordinate = userInterface.getUserInput(board);
            if (board.makeMove(coordinate, TicTacToeBoardInterface.Token.X)) {
                checkGameState();
                if (!gameOver) {
                    computerPlayerInterface.makeMove(board, TicTacToeBoardInterface.Token.O);
                    checkGameState();
                }
            }
            userInterface.displayBoard(board);
        }
    }

    private void checkGameState() {
        if (board.checkWin(TicTacToeBoardInterface.Token.X)) {
            userInterface.displayGameStateMessage();
            gameOver = true;
        } else if (board.checkWin(TicTacToeBoardInterface.Token.O)) {
            userInterface.displayLosingMessage();
            gameOver = true;
        } else if (board.checkDraw()) {
            userInterface.displayDrawMessage();
            gameOver = true;
        }
    }
}
