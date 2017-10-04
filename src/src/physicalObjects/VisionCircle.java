package physicalObjects;

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

    public boolean isInSight(PhysicalObject baseObject, PhysicalObject other) {
        return radius >= Math.abs(baseObject.getDimension().getPosition().getDistance(
                other.getDimension().getPosition()));
    }

}
