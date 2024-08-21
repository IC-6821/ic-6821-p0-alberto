package org.example;

public interface UserInterface {
    void displayGameStateMessage();

    void displayLosingMessage();

    void displayDrawMessage();

    void displayEnterMovePrompt();

    void displayBoard(TicTacToeBoardInterface board);

    Coordinate getUserInput(TicTacToeBoardInterface board);
}
