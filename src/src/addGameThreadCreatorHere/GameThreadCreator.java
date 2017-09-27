package addGameThreadCreatorHere;

import addImagesHere.ImageLoader;
import core.ActionHandler;
import core.GameThread;
import core.ObjectHandler;

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

    private ImageLoader imageLoader;

    /**
     * Constructor
     *
     * @param imageLoader the object containing all game images
     */
    public GameThreadCreator(ImageLoader imageLoader) {
        this.imageLoader = imageLoader;
    }

    public GameThread startGame() {
        ObjectHandler objectHandler = new ObjectHandler();
        ActionHandler actionHandler = new ActionHandler(objectHandler);

        return new GameThread(objectHandler, actionHandler);
    }

    public GameThread get(int threadValue) {
        return null;
    }

}
