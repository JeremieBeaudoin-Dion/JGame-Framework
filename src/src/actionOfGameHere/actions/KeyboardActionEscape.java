package actionOfGameHere.actions;

import coreActions.Action;
import coreActions.ActionEvent;
import coreActions.GameThreadEventQuit;

/**
 * @author Jérémie Beaudoin-Dion
 */
public class KeyboardActionEscape implements Action {

    private static final long TIME_BETWEEN_EACH_EVENTS = 200;
    private static long TIME_LAST_CALLED = System.currentTimeMillis();

    /**
     * Can always be called
     */
    @Override
    public boolean isDoable() {
        return System.currentTimeMillis() - TIME_LAST_CALLED >= TIME_BETWEEN_EACH_EVENTS;
    }

    @Override
    public ActionEvent doAction() throws NoSuchMethodException {
        TIME_LAST_CALLED = System.currentTimeMillis();

        return new GameThreadEventQuit();
    }

}
