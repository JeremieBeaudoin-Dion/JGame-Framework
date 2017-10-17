package coreActions;

import core.Game;
import exceptions.ActionInvocationException;

import java.lang.reflect.Method;

/**
 * A specific GameEvent that will exit the current GameThread
 *
 * @author Jérémie Beaudoin-Dion
 */
public class GameThreadEventQuit extends GameThreadEvent {

    public GameThreadEventQuit() throws NoSuchMethodException {
        super(Game.class, getQuitStateMethod());
    }

    private static Method getQuitStateMethod(){
        try {
            return Game.class.getMethod("quitCurrentState");
        } catch (NoSuchMethodException e) {
            throw new ActionInvocationException("quitCurrentState", Game.class, e.getMessage());
        }
    }

}
