package org.example;

public interface UserInterface {
    void displayGameStateMessage();

    void displayLosingMessage();

    void displayDrawMessage();

    void displayEnterMovePrompt();

    void displayBoard(TicTacToeBoard board);

    Coordinate getUserInput(TicTacToeBoard board);
}