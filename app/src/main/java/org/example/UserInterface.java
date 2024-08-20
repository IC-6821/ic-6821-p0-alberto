package org.example;

import java.util.Scanner;

public class UserInterface {
    private TicTacToeBoard board;

    public static final int BOARD_SIZE = 3;
    public static final int PARTS_IN_USER_INPUT = 2;
    public static final String ENTER_MOVE_PROMPT = "> ";
    public static final String INVALID_INPUT_MESSAGE = "Input inválido. Intente de nuevo.";
    public static final String WIN_MESSAGE = "Has ganado!";
    public static final String DRAW_MESSAGE = "Empate!";
    public static final String COMPUTER_WIN_MESSAGE = "La computadora ha ganado!";
    public static final String BOARD_SEPARATOR = "-----";

    public UserInterface(TicTacToeBoard board) {
        this.board = board;
    }

    public void displayGameStateMessage() {
        System.out.println(WIN_MESSAGE);
    }

    public void displayLosingMessage() {
        System.out.println(COMPUTER_WIN_MESSAGE);
    }

    public void displayDrawMessage() {
        System.out.println(DRAW_MESSAGE);
    }

    public void displayEnterMovePrompt() {
        System.out.print(ENTER_MOVE_PROMPT);
    }

    public void displayBoard(TicTacToeBoard board) {
        //falta implementacion
    }

    public Coordinate getUserInput(TicTacToeBoard board) {
        Scanner scanner = new Scanner(System.in);
        displayEnterMovePrompt();
        String userInput = scanner.nextLine();
        scanner.close();
        try {
            return convertUserInputToCoordinate(userInput, board);
        } catch (IllegalArgumentException e) {
            System.out.println(INVALID_INPUT_MESSAGE);
            return getUserInput(board);
        }
    }

    public Coordinate convertUserInputToCoordinate(String userInput, TicTacToeBoard board) {
        String[] parts = userInput.split(" ");
        if (parts.length != PARTS_IN_USER_INPUT) {
            throw new IllegalArgumentException("Input inválido");
        }
        Board.Row row = board.getRowMapping().get(parts[0].toLowerCase());
        Board.Column column = board.getColumnMapping().get(parts[1].toLowerCase());
        if (row == null || column == null) {
            throw new IllegalArgumentException("Input inválido");
        }
        int rowIndex = row.ordinal();
        int columnIndex = column.ordinal();
        return new Coordinate(rowIndex, columnIndex);
    }
}