package physicalObjects;

import display.Position;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * A round vision that uses a single variable as radius.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class VisionCircle implements Vision {

    private int diameter;

    public VisionCircle(int diameter) {
        this.diameter = diameter;
    }

    public boolean isInSight(Position centerOfOwner, PhysicalObject other) {
        Shape circle = new Ellipse2D.Double(centerOfOwner.getX(), centerOfOwner.getY(), diameter, diameter);
        BoundingArea area = new BoundingArea(circle);

        return area.collidesWith(other.getBoundingArea());
    }

}
