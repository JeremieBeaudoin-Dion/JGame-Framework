package addResourceLoaderHere;

import jGameFramework.physicalObjects.Position;

import javax.sound.sampled.Clip;

/**
 * Contains all the useful game information, such as the name,
 * the pixels of the window, the FPS and the GameThreadID to
 * use at start of game.
 *
 * These variables should not be removed as they are necessary
 * for the game to run.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class GameInformation {

    public final static String GAME_NAME = "Test";

    public static int WINDOW_WIDTH = 900;
    public static int WINDOW_HEIGHT = 600;

    public static final long FRAMES_PER_SECOND = 60;

    public static final GameThreadID START_GAME_ID = GameThreadID.Menu;

    /*
     * CAUTION: When using the integrated RESIZABLE feature in Java-Game-Engine,
     * the system automatically resizes and rearranges the PhysicalObjects.
     *
     * For any custom ways to handle resizing, override the resize() method
     * in PhysicalObjects
     */
    public static final boolean RESIZABLE = true;

    // To simplify a lot of the code, all the music clips share the same LoopValue.
    public static final int musicLoopValue = Clip.LOOP_CONTINUOUSLY;

    /**
     * Called automatically every time the JFrame is resized.
     */
    public static void resize(Position newWidthAndHeight) {
        WINDOW_WIDTH = newWidthAndHeight.getX();
        WINDOW_HEIGHT = newWidthAndHeight.getY();
    }

}
