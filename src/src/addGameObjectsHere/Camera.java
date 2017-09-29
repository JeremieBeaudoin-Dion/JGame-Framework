package addGameObjectsHere;

import core.Game;
import coreActions.ActionEvent;
import images.Dimension;
import images.ImageObject;
import images.Position;
import physicalObjects.ObjectProperties;
import physicalObjects.PhysicalObject;
import physicalObjects.Velocity;

import java.util.List;
import java.util.TreeSet;

/**
 * The Camera has a position, and the Width and Height of the Game
 *
 * It defines what will be shown in ImageHandler
 *
 * This can be modified but not removed, it can be ignored by object,
 * but the ObjectHandler will always assume that a Camera object exists.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class Camera extends PhysicalObject {

    /**
     * Basic constructor
     */
    public Camera() {
        super(new ObjectProperties(new Dimension(0, 0, Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT),
                new Velocity(5, 5)));
    }

    /**
     * Returns true if the PhysicalObject is within the
     * Camera's vision.
     *
     * If a zoom is implemented, a new method will be needed
     */
    public boolean isWithinBounds(PhysicalObject physicalObject) {
        return isColliding(physicalObject);
    }

    // Invoked methods
    public void moveRight() {
        getProperties().getDimension().setPosition(
                getProperties().getDimension().getPosition().add(getProperties().getVelocity().goRight()));
    }

    public void moveLeft() {
        getProperties().getDimension().setPosition(
                getProperties().getDimension().getPosition().add(getProperties().getVelocity().goLeft()));
    }

    public void moveDown() {
        getProperties().getDimension().setPosition(
                getProperties().getDimension().getPosition().add(getProperties().getVelocity().goDown()));
    }

    public void moveUp() {
        getProperties().getDimension().setPosition(
                getProperties().getDimension().getPosition().add(getProperties().getVelocity().goUp()));
    }

    /**
     * The Camera doesn't have an Image representation
     */
    @Override
    public TreeSet<ImageObject> getImageObjects(Position cameraPosition) {
        return null;
    }

    @Override
    public void doClick() throws NoSuchMethodException {
        // Could be used for example, getting the game to resume on click
    }

    @Override
    public List<ActionEvent> getAction() {
        return null;
    }
}
