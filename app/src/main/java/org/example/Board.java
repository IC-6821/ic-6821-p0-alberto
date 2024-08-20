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

    enum Row {
        TOP("arriba"), MIDDLE("medio"), BOTTOM("abajo");

        private final String textValue;

        Row(String textValue) {
            this.textValue = textValue;
        }

        public String getTextValue() {
            return textValue;
        }
    }

    enum Column {
        LEFT("izquierda"), MIDDLE("medio"), RIGHT("derecha");

        private final String textValue;

        Column(String textValue) {
            this.textValue = textValue;
        }

        public String getTextValue() {
            return textValue;
        }
    }
}
