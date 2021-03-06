package jGameFramework.coreActions;

import jGameFramework.core.threadObjects.GameThreadHandler;

import java.lang.reflect.Method;

/**
 * A specific event that will change the current game thread (the current state
 * of the game object).
 *
 * @author Jérémie Beaudoin-Dion
 */
abstract class GameThreadEvent extends GameEvent<GameThreadHandler> {

    GameThreadEvent(Method methodValue) {
        super(GameThreadHandler.class, methodValue);
    }

    GameThreadEvent(Method methodValue, Object parameterValue) {
        super(GameThreadHandler.class, methodValue, parameterValue.getClass(), parameterValue);
    }
}
