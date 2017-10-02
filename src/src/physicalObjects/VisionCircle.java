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
        return radius >= Math.abs(baseObject.getProperties().getDimension().getPosition().getDistance(
                other.getProperties().getDimension().getPosition()));
    }

}
