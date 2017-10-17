package coreActions;

import core.Game;
import exceptions.ActionInvocationException;

import java.lang.reflect.Method;

/**
 * @author Jérémie Beaudoin-Dion
 */
public class GameThreadEventSave extends GameThreadEvent {

    public GameThreadEventSave(String saveFilePath) {
        super(Game.class, getSaveGameStateMethod(), saveFilePath);
    }

    private static Method getSaveGameStateMethod(){
        try {
            return Game.class.getMethod("saveGame", String.class);
        } catch (NoSuchMethodException e) {
            throw new ActionInvocationException("saveGame", Game.class, e.getMessage());
        }
    }

}
