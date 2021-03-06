package jGameFramework.coreActions;

import jGameFramework.core.threadObjects.GameThreadHandler;
import jGameFramework.exceptions.ActionInvocationException;

import java.lang.reflect.Method;

/**
 * A specific GameEvent that will play a specific sound according to
 * its id.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class GameEventPlaySound extends GameThreadEvent {

    public GameEventPlaySound(String musicID) {
        super(getPlaySoundMethod(), musicID);
    }

    private static Method getPlaySoundMethod(){
        try {
            return GameThreadHandler.class.getMethod("playSound", String.class);
        } catch (NoSuchMethodException e) {
            throw new ActionInvocationException("playSound", GameThreadHandler.class, e.getMessage());
        }
    }

}
