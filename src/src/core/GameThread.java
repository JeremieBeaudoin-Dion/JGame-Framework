package core;

import coreActions.InputActionKeyMap;
import display.ImageObject;
import physicalObjects.Camera;
import physicalObjects.PhysicalObject;

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
    private InputHandler inputHandler;

    public GameThread(Game gameReference, Camera camera, TreeSet<PhysicalObject> threadObjects,
                      InputActionKeyMap inputActionKeyMap) {
        this.objectHandler = new ObjectHandler(threadObjects, camera);
        this.actionHandler = new ActionHandler(gameReference, objectHandler);
        this.inputHandler = new InputHandler(inputActionKeyMap, actionHandler);
    }

    void update() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        actionHandler.update();
        objectHandler.update();
    }

    public TreeSet<ImageObject> getImages() {
        return objectHandler.get();
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }
}
