package addGameObjectsHere;

import coreActions.ActionEvent;
import images.ImageObject;
import images.Position;
import physicalObjects.InteractingPhysicalObject;
import physicalObjects.ObjectProperties;
import physicalObjects.PhysicalObject;
import physicalObjects.Vision;

import java.util.List;
import java.util.TreeSet;

/**
 * An example of a simple Player object.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class Player extends InteractingPhysicalObject {

    /**
     * Constructor
     */
    public Player(ObjectProperties properties, Vision vision) {
        super(properties, vision);
    }

    // Invoked methods
    public void moveRight() {
        moveTo(getProperties().getDimension().getPosition().add(getProperties().getVelocity().goRight()));
    }

    public void moveLeft() {
        moveTo(getProperties().getDimension().getPosition().add(getProperties().getVelocity().goLeft()));
    }

    public void moveDown() {
        moveTo(getProperties().getDimension().getPosition().add(getProperties().getVelocity().goDown()));
    }

    public void moveUp() {
        moveTo(getProperties().getDimension().getPosition().add(getProperties().getVelocity().goUp()));
    }

    @Override
    public TreeSet<PhysicalObject> update(TreeSet<PhysicalObject> surroundings) {
        return null;
    }

    @Override
    public TreeSet<ImageObject> getImageObjects(Position cameraPosition) {
        return null;
    }

    @Override
    public void doClick() throws NoSuchMethodException {

    }

    @Override
    public List<ActionEvent> getAction() {
        return null;
    }

    @Override
    public boolean dispose() {
        return false;
    }
}
