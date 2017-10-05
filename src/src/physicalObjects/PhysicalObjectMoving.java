package physicalObjects;

import images.Dimension;
import images.Position;

import java.util.TreeSet;

/**
 * An updating PhysicalObject that has a velocity: it can move.
 *
 * @author Jérémie Beaudoin-Dion
 */
public abstract class PhysicalObjectMoving extends PhysicalObjectUpdating {

    private Velocity velocity;

    /**
     * Constructor
     */
    public PhysicalObjectMoving(Dimension dimension, Vision vision, Velocity velocity) {
        super(dimension, vision);

        this.velocity = velocity;
    }

    protected void moveRight(TreeSet<PhysicalObject> surroundings) {
        Position desiredPosition = getDimension().getPosition().add(getVelocity().goRight());

        if (canMoveThere(surroundings, getObjectDimensionAtPosition(desiredPosition))){
            moveTo(desiredPosition);
        }

    }

    protected void moveLeft(TreeSet<PhysicalObject> surroundings) {
        Position desiredPosition = getDimension().getPosition().add(getVelocity().goLeft());

        if (canMoveThere(surroundings, getObjectDimensionAtPosition(desiredPosition))){
            moveTo(desiredPosition);
        }
    }

    protected void moveDown(TreeSet<PhysicalObject> surroundings) {
        Position desiredPosition = getDimension().getPosition().add(getVelocity().goDown());

        if (canMoveThere(surroundings, getObjectDimensionAtPosition(desiredPosition))){
            moveTo(desiredPosition);
        }
    }

    protected void moveUp(TreeSet<PhysicalObject> surroundings) {
        Position desiredPosition = getDimension().getPosition().add(getVelocity().goUp());

        if (canMoveThere(surroundings, getObjectDimensionAtPosition(desiredPosition))){
            moveTo(desiredPosition);
        }
    }

    private boolean canMoveThere(TreeSet<PhysicalObject> surroundings, Dimension dimensionAtDesiredPosition){
        for (PhysicalObject otherObject: surroundings){
            if (otherObject instanceof PhysicalObjectUpdating && otherObject != this){
                if (otherObject.isColliding(dimensionAtDesiredPosition)){
                    return false;
                }
            }
        }

        return true;
    }

    // Getter
    public Velocity getVelocity(){
        return velocity;
    }
}
