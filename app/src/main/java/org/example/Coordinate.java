package org.example;

public class Coordinate {
    private enum Row {
        TOP("arriba"), MIDDLE("medio"), BOTTOM("abajo");

        private String textValue;

        Row(String textValue) {
            this.textValue = textValue;
        }

        public String getTextValue() {
            return textValue;
        }
    }

    private enum Column {
        LEFT("izquierda"), CENTER("centro"), RIGHT("derecha");

        private String textValue;

        Column(String textValue) {
            this.textValue = textValue;
        }

        public String getTextValue() {
            return textValue;
        }
    }

    private Row row;
    private Column column;

    public Coordinate(Row row, Column column) {
        this.row = row;
        this.column = column;
    }

}
