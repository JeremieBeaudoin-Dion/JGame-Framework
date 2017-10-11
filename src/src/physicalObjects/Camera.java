package physicalObjects;

import core.Game;
import display.Position;

/**
 * A camera has a position, and the Width and Height of the Game
 *
 * It defines what will be shown in ImageHandler
 *
 * This can be modified but not removed, it can be ignored by object,
 * but the ObjectHandler will always assume that a Camera object exists.
 *
 * @author Jérémie Beaudoin-Dion
 */
public abstract class Camera extends PhysicalObjectUpdating {

    /**
     * Constructor
     */
    public Camera() {
        super(new Dimension(0, 0, Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT), false, new VisionRectangle(
                new Position(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT)));
    }

    /**
     * Returns true if the PhysicalObject collides with the CameraWithEdges
     *
     * If a zoom is implemented, a new method will be needed
     */
    public boolean isWithinBounds(PhysicalObject physicalObject) {
        return isColliding(physicalObject);
    }

}
