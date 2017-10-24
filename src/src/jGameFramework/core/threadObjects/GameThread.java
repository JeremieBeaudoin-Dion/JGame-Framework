package jGameFramework.core.threadObjects;

import addResourceLoaderHere.GameThreadID;
import addResourceLoaderHere.ImageLoader;
import jGameFramework.collections.InputActionKeyMap;
import jGameFramework.display.Displayable;
import jGameFramework.physicalObjects.Camera;
import jGameFramework.physicalObjects.PhysicalObject;

import java.util.TreeSet;

/**
 * A Game can have multiple threads which consists of an ActionHandler,
 * an ObjectHandler, an InputHandler
 *
 * @author Jérémie Beaudoin-Dion
 */
public class GameThread {

    private ObjectHandler objectHandler;
    private ActionHandler actionHandler;
    private InputHandler inputHandler;
    private GameThreadID id;

    GameThread(GameThreadHandler gameThreadHandler, GameThreadID gameThreadID, Camera camera,
               TreeSet<PhysicalObject> allGameObjects, InputActionKeyMap inputActionKeyMap){

        this.objectHandler = new ObjectHandler(allGameObjects, camera);
        this.actionHandler = new ActionHandler(gameThreadHandler, objectHandler);
        this.inputHandler = new InputHandler(inputActionKeyMap, actionHandler);
        this.id = gameThreadID;

    }

    public void update(double deltaValue) {
        actionHandler.update();
        objectHandler.update(deltaValue);
    }

    GameThreadSerialized getSerial(){
        return new GameThreadSerialized(id, objectHandler.getAllObjectsForSave(), objectHandler.getCamera());
    }

    TreeSet<Displayable> getImages(ImageLoader imageLoader) {
        return objectHandler.get(imageLoader);
    }

    InputHandler getInputHandler() {
        return inputHandler;
    }

}
