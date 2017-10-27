package addResourceLoaderHere;

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

    public final static int WINDOW_WIDTH = 900;
    public final static int WINDOW_HEIGHT = 600;

    public static final long FRAMES_PER_SECOND = 60;

    public static final GameThreadID START_GAME_ID = GameThreadID.Menu;


    // To simplify a lot of the code, all the music clips share the same LoopValue.
    public static final int musicLoopValue = Clip.LOOP_CONTINUOUSLY;

}
