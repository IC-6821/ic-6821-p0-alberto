package org.example;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        final String errorMessage = "";
        final int maxLevel = 3;
        final int minLvel = 1;
        int level = 1;
        if (args.length > 0) {
            try {
                level = Integer.parseInt(args[0]);
                if (level < minLvel || level > maxLevel) {
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
