package org.example;

public class Main {
    public static void main(String[] args) {
        final String errorMessage = "";
        int level = 1;
        if (args.length > 0) {
            try {
                level = Integer.parseInt(args[0]);
                if (level < 1 || level > 3) {
                    System.out.println(errorMessage);
                    level = 1;
                }
            } catch (NumberFormatException e) {
                System.out.println(errorMessage);
            }
        }

        final Game game = new Game();
        try {
            game.start();
        } catch (Exception e) {
            System.out.println(errorMessage);
        }
    }
}
