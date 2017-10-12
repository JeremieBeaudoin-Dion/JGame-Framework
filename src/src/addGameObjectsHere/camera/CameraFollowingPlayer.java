package addGameObjectsHere.camera;

import addGameObjectsHere.Player;
import coreActions.GameEvent;
import display.Displayable;
import physicalObjects.Position;
import physicalObjects.Camera;
import physicalObjects.PhysicalObject;

import java.util.List;
import java.util.TreeSet;

/**
 * @author Jérémie Beaudoin-Dion
 */
public class CameraFollowingPlayer extends Camera {

    private Player playerReference;

    public CameraFollowingPlayer(Player player){
        super();

        playerReference = player;
    }

    /**
     * When updated, makes sure the player is at the center of the screen
     */
    @Override
    public TreeSet<PhysicalObject> update(TreeSet<PhysicalObject> surroundings) {

        /*
        Position centerOfCamera = getBoundingArea().getCenterPosition();
        Position playerPosition = playerReference.getBoundingArea().getCenterPosition();

        Position newCameraPosition = centerOfCamera.add(new Position(playerPosition.getX(), playerPosition.getY()));

        setPositionTo(newCameraPosition);*/

        return null;
    }

    @Override
    public TreeSet<Displayable> getImageObjects(Position cameraPosition) {
        return null;
    }

    @Override
    public void doClick() {
    }

    @Override
    public List<GameEvent> getAction() {
        return null;
    }

    @Override
    public boolean dispose() {
        return false;
    }
}
