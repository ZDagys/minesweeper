import org.junit.*;

import static Constants.Constants.BOARD_HEIGHT;
import static Constants.Constants.BOARD_LENGTH;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class  Tests {

    private static final int INVALID_MOUSE_POSITION_X = -99999;
    private static final int INVALID_MOUSE_POSITION_Y = -99999;

    GameUIInteraction gameUIInteraction = new GameUIInteraction();

    GameLogic gameLogic = new GameLogic();

    @Test
    public void whenGivenIvalidMousePosition_thenReturnMinusOne() {
        assertEquals(-1, gameUIInteraction.boxX(INVALID_MOUSE_POSITION_X, INVALID_MOUSE_POSITION_Y));
        assertEquals(-1, gameUIInteraction.boxY(INVALID_MOUSE_POSITION_X, INVALID_MOUSE_POSITION_Y));
    }

    @Test
    public void whenGameBuilt_thenHaveMines() {
        int numberOfBombs = 0;
        gameLogic.buildGame();
        for (int i = 0; i < BOARD_LENGTH; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                if (gameLogic.mines[i][j] == 1) {
                    numberOfBombs++;
                }
            }
        }
        assertNotEquals(0, numberOfBombs);
    }

    @Test
    public void whenGameBuilt_thenUncoveredBoxesEqualsZero() {
        int numberOfUncovered = 0;
        gameLogic.buildGame();
        for (int i = 0; i < BOARD_LENGTH; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                if (gameLogic.uncovered[i][j]) {
                    numberOfUncovered++;
                }
            }
        }
        assertEquals(0, numberOfUncovered);
    }
}
