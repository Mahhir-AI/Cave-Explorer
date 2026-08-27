package src;

public class GameManager implements Observer {
    private static GameManager instance;
    private int pagesCollected = 0;
    private boolean gameWon = false;

    private GameManager() {}

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void update(String event) {
        if (event.equals("page_collected")) {
            pagesCollected++;
            if (pagesCollected >= 7) {
                gameWon = true;
                System.out.println("You have collected all 7 pages!");
            }
        }
    }

    public int getPagesCollected() {
        return pagesCollected;
    }

    public boolean isGameWon() {
        return gameWon;
    }
}