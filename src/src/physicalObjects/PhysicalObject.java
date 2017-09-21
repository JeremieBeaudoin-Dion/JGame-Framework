package physicalObjects;

import images.Dimension;
import images.ImageObject;
import images.Position;

import java.util.List;

/**
 * A physical object has an ImageObject representation of itself
 * that can be put on screen.
 *
 * @author Jérémie Beaudoin-Dion
 */
public abstract class PhysicalObject {

    private Dimension dimension;

    /**
     * Constructor
     */
    public PhysicalObject(Dimension dimension) {
        this.dimension = dimension;
    }

    /**
     * Returns the image representation of this physical object
     */
    public abstract List<ImageObject> getImageObjects(Position cameraPosition);

    /**
     * Returns true if this physical object is colliding with another
     */
    public boolean isColliding(PhysicalObject other) {
        return getEastCollision(this, other) && getWestCollision(this, other) &&
                getSouthCollision(this, other) && getNorthCollision(this, other);
    }

    private boolean getEastCollision(PhysicalObject first, PhysicalObject second) {
        return first.getDimension().getPosition().getX() + first.getDimension().getWidth()
                >= second.getDimension().getPosition().getX();
    }

    private boolean getWestCollision(PhysicalObject first, PhysicalObject second) {
        return first.getDimension().getPosition().getX()
                <= second.getDimension().getPosition().getX() + second.getDimension().getWidth();
    }

    private boolean getSouthCollision(PhysicalObject first, PhysicalObject second) {
        return first.getDimension().getPosition().getY() + first.getDimension().getHeight()
                >= second.getDimension().getPosition().getY();
    }

    private boolean getNorthCollision(PhysicalObject first, PhysicalObject second) {
        return first.getDimension().getPosition().getY()
                <= second.getDimension().getPosition().getY() + second.getDimension().getHeight();
    }

    /**
     * Getter
     */
    public Dimension getDimension() {
        return dimension;
    }

}
