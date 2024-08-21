package org.example;

import java.util.Scanner;

import static org.example.TicTacToeBoard.BOARD_SIZE;

public final class ConsoleInterface implements UserInterface {
    public static final int PARTS_IN_USER_INPUT = 2;
    public static final String ENTER_MOVE_PROMPT = "> ";
    public static final String INVALID_INPUT_MESSAGE = "Input inválido. Intente de nuevo.";
    public static final String WIN_MESSAGE = "Has ganado!";
    public static final String DRAW_MESSAGE = "Empate!";
    public static final String COMPUTER_WIN_MESSAGE = "Has perdido!";
    public static final String BOARD_SEPARATOR = "-----------";

    @Override
    public void displayGameStateMessage() {
        System.out.println(WIN_MESSAGE);
    }

    @Override
    public void displayLosingMessage() {
        System.out.println(COMPUTER_WIN_MESSAGE);
    }

    @Override
    public void displayDrawMessage() {
        System.out.println(DRAW_MESSAGE);
    }

    @Override
    public void displayEnterMovePrompt() {
        System.out.print(ENTER_MOVE_PROMPT);
    }

    @Override
    public void displayBoard(TicTacToeBoard board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                final Coordinate coordinate = new Coordinate(i, j);
                final String displayValue = (board.getCellValue(coordinate) == null)
                        ? "   "
                        : String.format(" %s ", board.getCellValue(coordinate).toString());
                System.out.print(displayValue);
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

    @Override
    public Coordinate getUserInput(TicTacToeBoard board) {
        final Scanner scanner = new Scanner(System.in);
        displayEnterMovePrompt();
        final String userInput = scanner.nextLine();
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
