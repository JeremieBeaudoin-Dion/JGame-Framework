package addGameThreadCreatorHere;

import addImageLoaderHere.ImageLoader;
import core.Game;
import core.GameThread;

/**
 * A very Game-Dependent class.
 *
 * This will instantiate GameThreads according to the
 * desired thread's value.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class GameThreadCreator {

    public final static String GAME_NAME = "Test";

    public final static int WINDOW_WIDTH = 900;
    public final static int WINDOW_HEIGHT = 600;

    public static final long FRAMES_PER_SECOND = 60;

    private Game gameObject;

    // Threads
    public final static int GAME_MENU = 0;
    public final static int GAME_LEVEL_1 = 1;

    private GameThreadContentManager gameThreadContentManager;

    /**
     * Constructor
     *
     * @param imageLoader the object containing all game display
     */
    public GameThreadCreator(Game gameObject, ImageLoader imageLoader) {
        this.gameObject = gameObject;
        gameThreadContentManager = new GameThreadContentManager(imageLoader);
    }

    /**
     * Necessary method called by Game at start of the game.
     */
    public GameThread startGame() {
        return gameThreadContentManager.getStartGame(gameObject);
    }

    public GameThread get(int threadValue) {

        switch (threadValue) {

            case GAME_MENU:
                return gameThreadContentManager.getStartGame(gameObject);

            case GAME_LEVEL_1:
                return gameThreadContentManager.getLevel1(gameObject);

        }

        throw new IllegalArgumentException("The threadValue " + threadValue + " is not valid");
    }

}
