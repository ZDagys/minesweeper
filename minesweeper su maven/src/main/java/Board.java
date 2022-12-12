import javax.swing.*;
import java.awt.*;

import static Constants.Constants.*;

public class Board extends JPanel {

    GameLogic logic;

    Board(GameLogic gameLogic) {
        this.logic = gameLogic;
    }

    public void paintComponent(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, 1280, 800);
        for (int i = 0; i < BOARD_LENGTH; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                graphics.setColor(Color.gray);
                if (logic.uncovered[i][j]) {
                    graphics.setColor(Color.white);
                }

                graphics.fillRect(SPACE + i * 80, SPACE + j * 80 + 80, 80 - 2 * SPACE, 80 - 2 * SPACE);
                if (logic.uncovered[i][j]) {
                    if (logic.mines[i][j] == 1) {
                        graphics.setColor(Color.red);
                        graphics.setFont(new Font("Tahoma", Font.BOLD, 40));
                        graphics.drawString("X", i * 80 + 27, j * 80 + 135);
                    } else {
                        graphics.setColor(Color.black);
                        graphics.setFont(new Font("Tahoma", Font.BOLD, 40));
                        graphics.drawString(Integer.toString(logic.neighbours[i][j]), i * 80 + 27, j * 80 + 135);
                    }
                    if (logic.isVictory()) {
                        graphics.setColor(Color.yellow);
                        logic.victoryMessage = "YOU WIN!";
                        graphics.setFont(new Font("Tahoma", Font.BOLD, 40));
                        graphics.drawString(logic.victoryMessage, VICTORY_MESSAGE_X, VICTORY_MESSAGE_Y);
                    }
                    if (logic.isDefeat()) {
                        graphics.setColor(Color.red);
                        logic.victoryMessage = "YOU LOSE!";
                        graphics.setFont(new Font("Tahoma", Font.BOLD, 40));
                        graphics.drawString(logic.victoryMessage, VICTORY_MESSAGE_X, VICTORY_MESSAGE_Y);
                    }

                }
                if (logic.flagged[i][j]) {
                    graphics.setColor(Color.blue);
                    graphics.setFont(new Font("Tahoma", Font.BOLD, 40));
                    graphics.drawString("F", i * 80 + 27, j * 80 + 135);
                }
            }
        }

    }
}