package jGameFramework.coreActions;

/**
 * @author Jérémie Beaudoin-Dion
 */

import addResourceLoaderHere.GameThreadID;
import jGameFramework.core.threadObjects.GameThreadHandler;
import jGameFramework.exceptions.ActionInvocationException;

import java.lang.reflect.Method;

/**
 * A specific GameEvent that will create a new Thread to the game.
 *
 * This Thread will be set as the top thread of the stack.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class GameThreadEventSetNew extends GameThreadEvent {

    public GameThreadEventSetNew(GameThreadID newThreadValue) {
        super(getNewGameStateMethod(), newThreadValue);
    }

    private static Method getNewGameStateMethod(){
        try {
            return GameThreadHandler.class.getMethod("setNewGameState", GameThreadID.class);
        } catch (NoSuchMethodException e) {
            throw new ActionInvocationException("setNewGameState", GameThreadHandler.class, e.getMessage());
        }
    }


}
