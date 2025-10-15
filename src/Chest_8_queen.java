public class Chest_8_queen {

    private static final String RESET  = "\u001B[0m";
    private static final String BLOCK  = "█";

    private static final String BLACK  = "\u001B[30m";
    private static final String WHITE  = "\u001B[97m";

    private static final String RED    = "\u001B[31m";
    private static final String GREEN  = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE   = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN   = "\u001B[36m";
    private static final String ORANGE = "\u001B[91m";
    private static final String AQUA   = "\u001B[96m";

    public static int[][] GAME_POLE_CHEST = new int[8][8];
    public static int count = 0;
    public static int count1 = 0;

    public static void main(String[] args) {
        for (int i = 0; i < GAME_POLE_CHEST.length; i++) {
            for (int j = 0; j < GAME_POLE_CHEST[i].length; j++) {
                if ((i + j) % 2 == 0) {
                    GAME_POLE_CHEST[i][j] = 0;
                }
                else {
                    GAME_POLE_CHEST[i][j] = -1;
                }
            }
        }
        viewPole(GAME_POLE_CHEST);
        System.out.println();
        queen(GAME_POLE_CHEST, 0, 0);
        System.out.println();
        System.out.println("Количество комбинаций: " + count);
        System.out.println("Количество попыток: " + count1);
    }

    public static int queenEit = 8; // 1-8
    public static void queen(int[][] GAME_POLE_CHEST, int Y, int X) {
        try {
            Thread.sleep(10);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        if (queenEit <= 0) {
            System.out.println();
            viewPole(GAME_POLE_CHEST);
            count++;
            return;
        }
        if (Y > 8) {
            return;
        }
        for (int i = 0; i < GAME_POLE_CHEST[0].length; i++) {
            count1++;
            if (GAME_POLE_CHEST[Y][i] > 0) {
                X += 1;
            }
            else if (GAME_POLE_CHEST[Y][i] == -1 || GAME_POLE_CHEST[Y][i] == 0) {
                GAME_POLE_CHEST[Y][i] = queenEit + 10;
                chessInteraction(GAME_POLE_CHEST, Y, i);
                queenEit--;
                queen(GAME_POLE_CHEST, Y + 1, 0);
                GAME_POLE_CHEST[Y][i] = ((Y + i) % 2 == 0) ? 0: -1;
                queenEit++;
                clearQueen(GAME_POLE_CHEST, Y, i);
            }
        }
    }

    public static void chessInteraction(int[][] GAME_POLE_CHEST, int Y, int X) {
        for (int i = 0; i < GAME_POLE_CHEST[Y].length; i++) {
            if (GAME_POLE_CHEST[Y][i] <= 0) {
                GAME_POLE_CHEST[Y][i] = queenEit;
            }
        }
        for (int i = 0; i < GAME_POLE_CHEST.length; i++) {
            if (GAME_POLE_CHEST[i][X] <= 0) {
                GAME_POLE_CHEST[i][X] = queenEit;
            }
        }
        // ↘ (вниз-вправо)
        for (int i = 1; Y + i < 8 && X + i < 8; i++) {
            if (GAME_POLE_CHEST[Y + i][X + i] <= 0) {
                GAME_POLE_CHEST[Y + i][X + i] = queenEit;
            }
        }
        // ↙ (вниз-влево)
        for (int i = 1; Y + i < 8 && X - i >= 0; i++) {
            if (GAME_POLE_CHEST[Y + i][X - i] <= 0) {
                GAME_POLE_CHEST[Y + i][X - i] = queenEit;
            }
        }
        // ↖ (вверх-влево)
        for (int i = 1; Y - i >= 0 && X - i >= 0; i++) {
            if (GAME_POLE_CHEST[Y - i][X - i] <= 0) {
                GAME_POLE_CHEST[Y - i][X - i] = queenEit;
            }
        }
        // ↗ (вверх-вправо)
        for (int i = 1; Y - i >= 0 && X + i < 8; i++) {
            if (GAME_POLE_CHEST[Y - i][X + i] <= 0) {
                GAME_POLE_CHEST[Y - i][X + i] = queenEit;
            }
        }
    }

    public static void clearQueen(int[][] GAME_POLE_CHEST, int Y, int X) {
        for (int i = 0; i < GAME_POLE_CHEST[Y].length; i++) {
            if (GAME_POLE_CHEST[Y][i] == queenEit) {
                GAME_POLE_CHEST[Y][i] = ((Y + i) % 2 == 0) ? 0: -1;
            }
        }
        for (int i = 0; i < GAME_POLE_CHEST.length; i++) {
            if (GAME_POLE_CHEST[i][X] == queenEit) {
                GAME_POLE_CHEST[i][X] = ((i + X) % 2 == 0) ? 0: -1;
            }
        }
        // ↘ (вниз-вправо)
        for (int i = 1; Y + i < 8 && X + i < 8; i++) {
            if (GAME_POLE_CHEST[Y + i][X + i] == queenEit) {
                GAME_POLE_CHEST[Y + i][X + i] = ((Y + X) % 2 == 0) ? 0: -1;
            }
        }
        // ↙ (вниз-влево)
        for (int i = 1; Y + i < 8 && X - i >= 0; i++) {
            if (GAME_POLE_CHEST[Y + i][X - i] == queenEit) {
                GAME_POLE_CHEST[Y + i][X - i] = ((Y + X) % 2 == 0) ? 0: -1;;
            }
        }
        // ↖ (вверх-влево)
        for (int i = 1; Y - i >= 0 && X - i >= 0; i++) {
            if (GAME_POLE_CHEST[Y - i][X - i] == queenEit) {
                GAME_POLE_CHEST[Y - i][X - i] = ((Y + X) % 2 == 0) ? 0: -1;;
            }
        }
        // ↗ (вверх-вправо)
        for (int i = 1; Y - i >= 0 && X + i < 8; i++) {
            if (GAME_POLE_CHEST[Y - i][X + i] == queenEit) {
                GAME_POLE_CHEST[Y - i][X + i] = ((Y + X) % 2 == 0) ? 0: -1;;
            }
        }
    }

    public static void viewPole(int[][] GAME_POLE_CHEST) {
        for (int i = 0; i < GAME_POLE_CHEST.length; i++) {
            System.out.println();
            for (int j = 0; j < GAME_POLE_CHEST[i].length; j++) {
                switch (GAME_POLE_CHEST[i][j]) {
                    case -1 -> System.out.print("[" + WHITE + BLOCK + RESET + "]");
                    case 0 -> System.out.print("[" + BLACK + BLOCK + RESET + "]");
                    case 1 -> System.out.print("[" + AQUA + BLOCK + RESET + "]");
                    case 11 -> System.out.print("[" + AQUA + "$" + RESET + "]");
                    case 2 -> System.out.print("[" + ORANGE + BLOCK + RESET + "]");
                    case 12 -> System.out.print("[" + ORANGE + "$" + RESET + "]");
                    case 3 -> System.out.print("[" + CYAN + BLOCK + RESET + "]");
                    case 13 -> System.out.print("[" + CYAN + "$" + RESET + "]");
                    case 4 -> System.out.print("[" + PURPLE + BLOCK + RESET + "]");
                    case 14 -> System.out.print("[" + PURPLE + "$" + RESET + "]");
                    case 5 -> System.out.print("[" + BLUE + BLOCK + RESET + "]");
                    case 15 -> System.out.print("[" + BLUE + "$" + RESET + "]");
                    case 6 -> System.out.print("[" + YELLOW + BLOCK + RESET + "]");
                    case 16 -> System.out.print("[" + YELLOW + "$" + RESET + "]");
                    case 7 -> System.out.print("[" + GREEN + BLOCK + RESET + "]");
                    case 17 -> System.out.print("[" + GREEN + "$" + RESET + "]");
                    case 8 -> System.out.print("[" + RED + BLOCK + RESET + "]");
                    case 18 -> System.out.print("[" + RED + "$" + RESET + "]");
                }
            }
        }
    }
}