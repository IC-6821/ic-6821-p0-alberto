package org.example;

import java.util.Map;

public interface Board {

    enum Token {
        X, O
    }

    Token getCellValue(Coordinate cord);

    boolean checkWin();

    boolean checkDraw();

    void initializeBoard();

    Map<String, Row> getRowMapping();

    Map<String, Column> getColumnMapping();

    void setCell(Coordinate coord, Token playerSymbol);

    boolean isPositionAvailable(Coordinate coord);

    boolean makeMove(Coordinate coord, Token symbol);

    enum Row {
        TOP("arriba"), MIDDLE("medio"), BOTTOM("abajo");

        private final String textValue;

        Row(final String textValue) {
            this.textValue = textValue;
        }

        public String getTextValue() {
            return textValue;
        }
    }

    enum Column {
        LEFT("izquierda"), MIDDLE("centro"), RIGHT("derecha");

        private final String textValue;

        Column(final String textValue) {
            this.textValue = textValue;
        }

        public String getTextValue() {
            return textValue;
        }
    }
}
