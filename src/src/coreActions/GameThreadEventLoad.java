package coreActions;

import core.Game;
import exceptions.ActionInvocationException;

import java.lang.reflect.Method;

/**
 * @author Jérémie Beaudoin-Dion
 */
public class GameThreadEventLoad extends GameThreadEvent {

    public GameThreadEventLoad(String saveFilePath) {
        super(Game.class, getSaveGameStateMethod(), saveFilePath);
    }

    private static Method getSaveGameStateMethod(){
        try {
            return Game.class.getMethod("loadGame", String.class);
        } catch (NoSuchMethodException e) {
            throw new ActionInvocationException("loadGame", Game.class, e.getMessage());
        }
    }

}
