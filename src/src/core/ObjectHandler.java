package core;

import images.ImageObject;
import images.Position;
import physicalObjects.Camera;
import physicalObjects.PhysicalObject;

import java.util.LinkedList;
import java.util.List;

/**
 * Contains all the useful objects of the game. It handles
 * the camera and returns all ImageObjects to show on screen
 * on the call of get()
 *
 * @author Jérémie Beaudoin-Dion
 */
public class ObjectHandler {

    private Camera camera;

    private List<PhysicalObject> allGameObjects;

    public ObjectHandler() {
        camera = new Camera();
        allGameObjects = new LinkedList<>();
    }

    /**
     * Returns all objects to send to ImageHandler.
     */
    public List<ImageObject> get() {
        List<ImageObject> imagesToShowOnScreen = new LinkedList<>();

        for (PhysicalObject object : allGameObjects) {
            if (camera.isWithinBounds(object)) {
                imagesToShowOnScreen.addAll(object.getImageObjects(camera.getProperties().getDimension().getPosition()));
            }
        }

        return imagesToShowOnScreen;
    }

    /**
     * When a click is made with the mouse, any object that collides with
     * that position will be selected and any other will be unselected
     *
     * @param mousePositionOnScreen: the position of the mouse relative to the screen
     */
    public void doClick(Position mousePositionOnScreen) {

        Position mousePositionInGame = mousePositionOnScreen.add(camera.getProperties().getDimension().getPosition());

        for (PhysicalObject object : allGameObjects) {

            if (object.isColliding(mousePositionInGame)) {
                object.doClick();
            }
        }

    }

    /**
     * Getter
     */
    public Camera getCamera() {
        return camera;
    }

}
