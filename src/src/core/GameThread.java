package core;

import actionOfGameHere.ActionHandler;
import coreActions.Action;
import images.ImageObject;

import java.lang.reflect.InvocationTargetException;
import java.util.TreeSet;

/**
 * A Game can have multiple threads which consists of an ActionHandler
 * and an ObjectHandler
 *
 * @author Jérémie Beaudoin-Dion
 */
public class GameThread {

    private ObjectHandler objectHandler;
    private ActionHandler actionHandler;

    public GameThread(ObjectHandler objectHandler, ActionHandler actionHandler) {
        this.objectHandler = objectHandler;
        this.actionHandler = actionHandler;
    }

    public void update() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        actionHandler.update();
        objectHandler.update();
    }

    public void doAction(Action action) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        actionHandler.doAction(action);
    }

    public TreeSet<ImageObject> getImages() {
        return objectHandler.get();
    }

}
