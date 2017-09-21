package physicalObjects;

import core.Game;
import images.Dimension;
import images.ImageObject;

import java.util.List;

/**
 * The Camera has a position, and the Width and Height of the Game
 *
 * It defines what will be shown in ImageHandler
 *
 * @author Jérémie Beaudoin-Dion
 */
public class Camera extends PhysicalObject {

    private final static int X_VELOCITY = 5;
    private final static int Y_VELOCITY = 5;

    /**
     * Basic constructor
     */
    public Camera() {
        super(new Dimension(0, 0, Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT));
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

    }

    public void moveLeft() {

    }

    public void moveDown() {

    }

    public void moveUp() {

    }

    @Override
    public List<ImageObject> getImageObjects() {
        return null;
    }

}
