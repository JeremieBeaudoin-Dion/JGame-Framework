package physicalObjects;

import display.Position;

/**
 * A round vision that uses a single variable as radius.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class VisionCircle implements Vision {

    private int radius;

    public VisionCircle(int radius) {
        this.radius = radius;
    }

    /**
     * DOES NOT WORK!
     *
     * https://stackoverflow.com/questions/401847/circle-rectangle-collision-detection-intersection
     */
    public boolean isInSight(Position centerOfOwner, PhysicalObject other) {


        return radius >= Math.abs(centerOfOwner.getDistance(
                other.getDimension().getPosition()));
    }

}
