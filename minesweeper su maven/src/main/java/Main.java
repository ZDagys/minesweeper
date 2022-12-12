public class Main implements Runnable {

    public static void main(String[] args) {
        new Thread(new Main()).start();
    }

    @Override
    public void run() {
        GameLogic gameLogic = new GameLogic();
        UserInterface userInterface = new UserInterface(gameLogic);
        while (!gameLogic.isGameOver()) {
            userInterface.repaint();

        }
    }
}
