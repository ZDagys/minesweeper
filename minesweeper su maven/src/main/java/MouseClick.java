import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseClick implements MouseListener, MouseMotionListener {

    public int mousePositionX = -100;
    public int mousePositionY = -100;

    GameUIInteraction gameUIInteraction;

    GameLogic gameLogic;

    MouseClick(GameUIInteraction gameUIInteraction, GameLogic gameLogic) {
        this.gameUIInteraction = gameUIInteraction;
        this.gameLogic = gameLogic;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int boxX = gameUIInteraction.boxX(mousePositionX, mousePositionY);
        int boxY = gameUIInteraction.boxY(mousePositionX, mousePositionY);

        if (SwingUtilities.isLeftMouseButton(e)) {
            if (boxX != -1 && boxY != -1) {
                gameLogic.uncovered[boxX][boxY] = true;
                gameLogic.flagged[boxX][boxY] = false;
            }

        }

        if (SwingUtilities.isRightMouseButton(e)) {
            if (boxX != -1 && boxY != -1 && !gameLogic.uncovered[boxX][boxY]) {
                gameLogic.flagged[boxX][boxY] = true;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.mousePositionX = e.getX();
        this.mousePositionY = e.getY();
    }
}