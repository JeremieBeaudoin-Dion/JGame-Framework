package physicalObjects;

/**
 * The vision of every object is represented by a circle.
 * Vision stores the value of the radius and returns true
 * if an object is in sight.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class Vision {

    private int radius;

    public Vision(int radius) {
        this.radius = radius;
    }

    public boolean isInSight(PhysicalObject baseObject, PhysicalObject other) {
        return radius >= Math.abs(baseObject.getProperties().getDimension().getPosition().getDistance(
                other.getProperties().getDimension().getPosition()));
    }

}
