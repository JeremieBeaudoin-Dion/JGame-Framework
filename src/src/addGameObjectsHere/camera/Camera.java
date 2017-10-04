package addGameObjectsHere.camera;

import core.Game;
import coreActions.ActionEvent;
import images.Dimension;
import images.ImageObject;
import images.Position;
import physicalObjects.PhysicalObject;

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

    private CameraEdges cameraEdges;

    private static final int CAMERAEDGES_WIDTH = Game.WINDOW_WIDTH/3;
    private static final int CAMERAEDGES_HEIGHT = Game.WINDOW_HEIGHT/3;
    private static final Position CAMERAEDGES_OFFSET = new Position(Game.WINDOW_WIDTH/3, Game.WINDOW_HEIGHT/3);

    /**
     * Basic constructor
     */
    public Camera() {
        super(new Dimension(0, 0, Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT));

        cameraEdges = new CameraEdges(new Dimension(getDimension().getPosition().add(CAMERAEDGES_OFFSET),
                CAMERAEDGES_WIDTH, CAMERAEDGES_HEIGHT));
    }

    /**
     * Returns true if the PhysicalObject collides with the Camera
     *
     * If a zoom is implemented, a new method will be needed
     */
    public boolean isWithinBounds(PhysicalObject physicalObject) {
        return isColliding(physicalObject);
    }

    /**
     * Called every frame
     *
     * In this case, the camera will always put the player near the
     * center of the screen, considering the cameraEdges set in the
     * constructor
     *
     * Leave method empty to have a camera that doest not move.
     */
    public void setPositionAccordingTo(Dimension objectDimensionToConsider){
        cameraEdges.setPosition(getDimension().getPosition().add(CAMERAEDGES_OFFSET));

        setPositionToKeepObjectInEdges(objectDimensionToConsider);
    }

    private void setPositionToKeepObjectInEdges(Dimension objectDimensionToConsider){
        Position positionToAdd = cameraEdges.addThisToCameraToKeepObjectInEdges(objectDimensionToConsider);
        Position currentCameraPosition = getDimension().getPosition();

        getDimension().setPosition(currentCameraPosition.add(positionToAdd));
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
        // Could be used, for example, to resume the game on click
    }

    @Override
    public List<ActionEvent> getAction() {
        return null;
    }

    /**
     * The Camera should not be disposed
     */
    @Override
    public boolean dispose() {
        return false;
    }
}
