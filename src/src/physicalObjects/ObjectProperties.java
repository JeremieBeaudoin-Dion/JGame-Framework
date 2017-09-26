package physicalObjects;

import images.Dimension;

/**
 * Every PhysicalObject has a Dimension,
 * Speed, Vision, etc.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class ObjectProperties {

    private Dimension dimension;
    private Velocity velocity;
    private Vision vision;

    public ObjectProperties(Dimension dimension, Velocity velocity, Vision vision) {
        this.dimension = dimension;
        this.velocity = velocity;
        this.vision = vision;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public Velocity getVelocity() {
        return velocity;
    }

}
