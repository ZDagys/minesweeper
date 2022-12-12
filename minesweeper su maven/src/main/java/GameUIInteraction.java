import java.util.Objects;

import static Constants.Constants.*;

public class GameUIInteraction {

    public int boxX(int mousePositionX, int mousePositionY) {
        return index(mousePositionX, mousePositionY, 'x');
    }

    public int boxY(int mousePositionX, int mousePositionY) {
        return index(mousePositionX, mousePositionY, 'y');
    }
    private int index(int mousePositionX, int mousePositionY, char index){
        for (int i = 0; i < BOARD_LENGTH; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                if (mousePositionX >= SPACE + i * 80 && mousePositionX < i * 80 + 80 - SPACE && mousePositionY >= SPACE + j * 80 + 106 && mousePositionY < j * 80 + 186 - SPACE) {
                    if (Objects.equals(index, 'x')) return i;
                    else return j;
                }
            }
        }
        return -1;
    }
}
