package org.example;

import java.util.Scanner;

public final class UserInterface {
    private TicTacToeBoard board;

    public static final int BOARD_SIZE = 3;
    public static final int PARTS_IN_USER_INPUT = 2;
    public static final String ENTER_MOVE_PROMPT = "> ";
    public static final String INVALID_INPUT_MESSAGE = "Input inválido. Intente de nuevo.";
    public static final String WIN_MESSAGE = "Has ganado!";
    public static final String DRAW_MESSAGE = "Empate!";
    public static final String COMPUTER_WIN_MESSAGE = "La computadora ha ganado!";
    public static final String BOARD_SEPARATOR = "-----";

    public UserInterface(final TicTacToeBoard board) {
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
        for (int i = 0; i < BOARD_SIZE; i++) {
        for (int j = 0; j < BOARD_SIZE; j++) {
            Coordinate cord = new Coordinate(i, j);
            System.out.print(board.getCellValue(cord));
            if (j < BOARD_SIZE - 1) {
                System.out.print("|");
            }
        }
        System.out.println();
        if (i < BOARD_SIZE - 1) {
            System.out.println(BOARD_SEPARATOR);
        }
    }
    }

    public Coordinate getUserInput(TicTacToeBoard board) {
        final Scanner scanner = new Scanner(System.in);
        displayEnterMovePrompt();
        final String userInput = scanner.nextLine();
        scanner.close();
        try {
            return convertUserInputToCoordinate(userInput, board);
        } catch (IllegalArgumentException e) {
            System.out.println(INVALID_INPUT_MESSAGE);
            return getUserInput(board);
        }
    }

    public Coordinate convertUserInputToCoordinate(String userInput, TicTacToeBoard board) {
        final String[] parts = userInput.split(" ");
        if (parts.length != PARTS_IN_USER_INPUT) {
            throw new IllegalArgumentException("Input inválido");
        }
        final Board.Row row = board.getRowMapping().get(parts[0].toLowerCase());
        final Board.Column column = board.getColumnMapping().get(parts[1].toLowerCase());
        if (row == null || column == null) {
            throw new IllegalArgumentException("Input inválido");
        }
        final int rowIndex = row.ordinal();
        final int columnIndex = column.ordinal();
        return new Coordinate(rowIndex, columnIndex);
    }
}
