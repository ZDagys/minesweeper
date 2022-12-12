import java.util.Random;

import static Constants.Constants.BOARD_HEIGHT;
import static Constants.Constants.BOARD_LENGTH;

public class  GameLogic {

    private int neighs = 0;
    public String victoryMessage = "";
    private boolean victory = false;
    private boolean defeat = false;

    int[][] mines = new int[BOARD_LENGTH][BOARD_HEIGHT];
    int[][] neighbours = new int[BOARD_LENGTH][BOARD_HEIGHT];
    boolean[][] uncovered = new boolean[BOARD_LENGTH][BOARD_HEIGHT];
    boolean[][] flagged = new boolean[BOARD_LENGTH][BOARD_HEIGHT];


    Random rand = new Random();

    public boolean isVictory() {
        return victory;
    }

    public boolean isDefeat() {
        return defeat;
    }

    public boolean isGameOver() {
        for (int i = 0; i < BOARD_LENGTH; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                if (uncovered[i][j] && mines[i][j] == 1 ) {
                    defeat = true;
                    return true;
                }
            }
        }
        if (numberOfBoxUncovered() >= BOARD_HEIGHT * BOARD_LENGTH - numberOfMines()) {
            victory = true;
            return true;
        }
        return false;
    }

    public int numberOfMines() {
        int totalMines = 0;
        for (int i = 0; i < BOARD_LENGTH; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                if (mines[i][j] == 1) {
                    totalMines++;
                }
            }
        }
        return totalMines;
    }

    public int numberOfBoxUncovered() {
        int totalUncovered = 0;
        for (int i = 0; i < BOARD_LENGTH; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                if (uncovered[i][j]) {
                    totalUncovered++;
                }
            }
        }
        return totalUncovered;
    }

    public boolean areNeighbours(int i, int j, int m, int n) {
        if (i - m < 2 && i - m > -2 && j - n < 2 && j - n > -2 && mines[m][n] == 1) {
            return true;
        }
        return false;
    }

    public void buildGame() {
        for (int i = 0; i < BOARD_LENGTH; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                if (rand.nextInt(10) < 2) {
                    mines[i][j] = 1;
                } else {
                    mines[i][j] = 0;
                }
                uncovered[i][j] = false;
                flagged[i][j] = false;
            }
        }
        for (int i = 0; i < BOARD_LENGTH; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                neighs = 0;
                for (int m = 0; m < BOARD_LENGTH; m++) {
                    for (int n = 0; n < BOARD_HEIGHT; n++) {
                        if (!(m == i && n == j)) {
                            if (areNeighbours(i, j, m, n)) {
                                neighs++;
                            }
                        }
                    }
                }
                neighbours[i][j] = neighs;
            }
        }

    }
}
