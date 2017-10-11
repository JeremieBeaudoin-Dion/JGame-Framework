package addGameObjectsHere.camera;

import addGameObjectsHere.Player;
import core.Game;
import coreActions.GameEvent;
import physicalObjects.Dimension;
import display.ImageObject;
import display.Position;
import physicalObjects.Camera;
import physicalObjects.PhysicalObject;

import java.util.List;
import java.util.TreeSet;

/**
 * The is a Camera that will keep the player in its Edges,
 * which are in the center of the screen.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class CameraWithEdges extends Camera {

    private EdgesOfCamera cameraEdges;

    private static final int CAMERAEDGES_WIDTH = Game.WINDOW_WIDTH/3;
    private static final int CAMERAEDGES_HEIGHT = Game.WINDOW_HEIGHT/3;
    private static final Position CAMERAEDGES_OFFSET = new Position(Game.WINDOW_WIDTH/3, Game.WINDOW_HEIGHT/3);

    /**
     * Basic constructor
     */
    public CameraWithEdges() {
        super();

        cameraEdges = new EdgesOfCamera(new Dimension(getDimension().getPosition().add(CAMERAEDGES_OFFSET),
                CAMERAEDGES_WIDTH, CAMERAEDGES_HEIGHT));
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
    @Override
    public TreeSet<PhysicalObject> update(TreeSet<PhysicalObject> surroundings) {
        cameraEdges.setPosition(getDimension().getPosition().add(CAMERAEDGES_OFFSET));

        for(PhysicalObject object: surroundings){
            if (object instanceof Player){
                setPositionToKeepObjectInEdges(object.getDimension());
                break;
            }
        }

        return null;
    }

    private void setPositionToKeepObjectInEdges(Dimension objectDimensionToConsider){
        Position positionToAdd = cameraEdges.addThisToCameraToKeepObjectInEdges(objectDimensionToConsider);
        Position currentCameraPosition = getDimension().getPosition();

        getDimension().setPosition(currentCameraPosition.add(positionToAdd));
    }

    /**
     * The CameraWithEdges doesn't have an Image representation
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
    public List<GameEvent> getAction() {
        return null;
    }

    /**
     * The CameraWithEdges should not be disposed
     */
    @Override
    public boolean dispose() {
        return false;
    }

}
