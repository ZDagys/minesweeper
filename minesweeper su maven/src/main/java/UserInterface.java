import javax.swing.*;

public class UserInterface extends JFrame {
    public UserInterface(GameLogic gameLogic) {
        this.setTitle("Minesweeper");
        this.setSize(1286, 829);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(true);

        Board board = new Board(gameLogic);
        this.setContentPane(board);

        GameUIInteraction gameUIInteraction = new GameUIInteraction();
        MouseClick mouseClick = new MouseClick(gameUIInteraction, gameLogic);
        this.addMouseListener(mouseClick);
        this.addMouseMotionListener(mouseClick);
        gameLogic.buildGame();
    }
}
