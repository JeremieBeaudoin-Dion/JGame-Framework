package physicalObjects;

import java.util.TreeSet;

/**
 * A type of physical object that will interact with its
 * surroundings.
 *
 * This particular PhysicalObject has vision of its surroundings
 *
 * @author Jérémie Beaudoin-Dion
 */
public abstract class PhysicalObjectUpdating extends PhysicalObject {

    private Vision vision;

    /**
     * Constructor
     */
    public PhysicalObjectUpdating(BoundingArea area, boolean isObstacle, Vision vision) {
        super(area, isObstacle);

        this.vision = vision;
    }

    /**
     * Method called every frame
     *
     * @return any new PhysicalObject created by this one
     */
    public abstract TreeSet<PhysicalObject> update(TreeSet<PhysicalObject> surroundings);

    /**
     * Return true if this physicalObject has vision of another
     */
    public boolean hasVision(PhysicalObject other) {
        return vision.isInSight(getBoundingArea().getCenterPosition(), other);
    }
}
