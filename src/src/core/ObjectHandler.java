package core;

import coreActions.ActionEvent;
import images.ImageObject;
import images.Position;
import addGameObjectsHere.Camera;
import physicalObjects.InteractingPhysicalObject;
import physicalObjects.PhysicalObject;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * Contains all the useful objects of the game. It handles
 * the camera and returns all ImageObjects to show on screen
 * on the call of get()
 *
 * @author Jérémie Beaudoin-Dion
 */
public class ObjectHandler {

    private Camera camera;

    private TreeSet<PhysicalObject> allGameObjects;

    private List<ActionEvent> allCurrentActions;

    public ObjectHandler(TreeSet<PhysicalObject> allGameObjects) {
        allCurrentActions = new LinkedList<>();
        camera = new Camera();
        this.allGameObjects = allGameObjects;
    }

    /**
     * Returns all objects to send to ImageHandler.
     */
    public TreeSet<ImageObject> get() {
        TreeSet<ImageObject> imagesToShowOnScreen = new TreeSet<>();

        for (PhysicalObject object : allGameObjects) {
            if (camera.isWithinBounds(object)) {
                imagesToShowOnScreen.addAll(object.getImageObjects(camera.getProperties().getDimension().getPosition()));
            }
        }

        return imagesToShowOnScreen;
    }

    /**
     * When a click is made with the mouse, a call to doClick will be sent to
     * any object that collides with that position
     *
     * @param mousePositionOnScreen: the position of the mouse relative to the screen
     */
    public void doClick(Position mousePositionOnScreen) throws NoSuchMethodException {

        Position mousePositionInGame = mousePositionOnScreen.add(camera.getProperties().getDimension().getPosition());

        for (PhysicalObject object : allGameObjects) {

            if (object.isColliding(mousePositionInGame)) {
                object.doClick();
            }
        }

    }

    /**
     * Called every frame
     *
     * Gives every PhysicalObject access to other objects in its vision.
     *
     * In order to be efficient and show objects in the right order,
     * a TreeSet is used.
     *
     * All possible new game objects are returned in InteractingPhysicalObject.update()
     * and are added at the end of the ObjectHandler's update() loop.
     */
    public void update() {
        TreeSet<PhysicalObject> objectsToAdd = new TreeSet<>();
        allCurrentActions = new LinkedList<>();

        for (PhysicalObject currentObject : allGameObjects) {
            objectsToAdd.addAll(updateObjectAndGetObjectsToAdd(currentObject));
            allCurrentActions.addAll(getActionEventFromObject(currentObject));
        }

        allGameObjects.addAll(objectsToAdd);
    }

    /**
     * Update the current object.
     *
     * Return any new object if they should be added
     */
    private TreeSet<PhysicalObject> updateObjectAndGetObjectsToAdd(PhysicalObject currentObject) {
        TreeSet<PhysicalObject> objectsToAdd = new TreeSet<>();
        TreeSet<PhysicalObject> newObjects;

        if (currentObject instanceof InteractingPhysicalObject) {
            newObjects = ((InteractingPhysicalObject) currentObject).update(
                    getSurroundingObjects((InteractingPhysicalObject) currentObject));

            if (newObjects != null && !newObjects.isEmpty()) {
                objectsToAdd.addAll(newObjects);
            }
        }

        return objectsToAdd;
    }

    /**
     * Returns a TreeSet of all objects that are within a specific PhysicalObject's
     * surroundings, according to its vision.
     */
    private TreeSet<PhysicalObject> getSurroundingObjects(InteractingPhysicalObject object) {

        TreeSet<PhysicalObject> surroundingObjects = new TreeSet<>();

        surroundingObjects.addAll(getAllPreviousObjectsInSight(object));

        surroundingObjects.addAll(getAllFollowingObjectsInSight(object));

        return surroundingObjects;
    }

    private TreeSet<PhysicalObject> getAllPreviousObjectsInSight(InteractingPhysicalObject mainObject) {
        TreeSet<PhysicalObject> previousObjects = new TreeSet<>();

        Iterator<PhysicalObject> previousIterator = allGameObjects.headSet(mainObject, false).descendingIterator();
        PhysicalObject iteratedObject;
        boolean iterate = true;

        while (previousIterator.hasNext() && iterate) {
            iteratedObject = previousIterator.next();

            if (mainObject.hasVision(iteratedObject)) {
                previousObjects.add(iteratedObject);
            } else {
                iterate = false;
            }
        }

        return previousObjects;
    }

    private TreeSet<PhysicalObject> getAllFollowingObjectsInSight(InteractingPhysicalObject mainObject) {
        TreeSet<PhysicalObject> nextObjects = new TreeSet<>();

        Iterator<PhysicalObject> nextIterator = allGameObjects.tailSet(mainObject, false).iterator();
        PhysicalObject iteratedObject;
        boolean iterate = true;

        while (nextIterator.hasNext() && iterate) {
            iteratedObject = nextIterator.next();

            if (mainObject.hasVision(iteratedObject)) {
                nextObjects.add(iteratedObject);
            } else {
                iterate = false;
            }
        }

        return nextObjects;
    }

    /**
     * If necessary, returns the ActionEvent that should be done
     */
    private List<ActionEvent> getActionEventFromObject(PhysicalObject object) {
        List<ActionEvent> actionsToDo = new LinkedList<>();
        List<ActionEvent> actionsFromObject;

        actionsFromObject = object.getAction();

        if (actionsFromObject != null && !actionsFromObject.isEmpty()) {
            actionsToDo.addAll(actionsFromObject);
        }

        return actionsToDo;
    }

    /**
     * Getter
     */
    public Camera getCamera() {
        return camera;
    }

    public List<ActionEvent> getAllCurrentActions() {
        return allCurrentActions;
    }

}
