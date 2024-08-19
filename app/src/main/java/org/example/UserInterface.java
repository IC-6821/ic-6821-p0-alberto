package org.example;
import java.util.Map;
import java.util.Scanner;

public class UserInterface {
    private static final Map<String, Row> ROW_MAPPING = Map.of(
            "arriba", Row.TOP,
            "medio", Row.MIDDLE,
            "abajo", Row.BOTTOM
    );

    private static final Map<String, Column> COLUMN_MAPPING = Map.of(
            "izquierda", Column.LEFT,
            "centro", Column.CENTER,
            "derecha", Column.RIGHT
    );


    private static final String ENTER_MOVE_PROMPT = "> ";
    private static final String INVALID_INPUT_MESSAGE = "Input inválido. Intente de nuevo.";

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        boolean playing = true;

        while (playing) {
            //displayBoard
            System.out.print(ENTER_MOVE_PROMPT);
            String userInput = scanner.nextLine();

            try {
                Coordinate coordinate = convertUserInputToCoordinate(userInput);
            } catch (IllegalArgumentException e) {
                System.out.println(INVALID_INPUT_MESSAGE);
            }
        }
    }

    private Coordinate convertUserInputToCoordinate(String userInput) {
        String[] parts = userInput.split(" ");
        Row row = ROW_MAPPING.get(parts[0]);
        Column column = COLUMN_MAPPING.get(parts[1]);
        return new Coordinate(row, column);
    }
}

