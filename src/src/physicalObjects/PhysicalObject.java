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

    private boolean selected;

    /**
     * Constructor
     */
    public PhysicalObject(Dimension dimension) {
        this.dimension = dimension;
        selected = false;
    }

    /**
     * Returns the image representation of this physical object
     */
    public abstract List<ImageObject> getImageObjects(Position cameraPosition);

    /**
     * Returns true if this physical object collides with a Position
     */
    public boolean isColliding(Position position) {
        Dimension dimensionOfPoint = new Dimension(position, 1, 1);

        return getEastCollision(getDimension(), dimensionOfPoint) &&
                getWestCollision(getDimension(), dimensionOfPoint) &&
                getSouthCollision(getDimension(), dimensionOfPoint) &&
                getNorthCollision(getDimension(), dimensionOfPoint);
    }

    /**
     * Returns true if this physical object is colliding with another
     */
    public boolean isColliding(PhysicalObject other) {
        return getEastCollision(getDimension(), other.getDimension()) &&
                getWestCollision(getDimension(), other.getDimension()) &&
                getSouthCollision(getDimension(), other.getDimension()) &&
                getNorthCollision(getDimension(), other.getDimension());
    }

    private boolean getEastCollision(Dimension dimensionOfFirst, Dimension dimensionOfSecond) {
        return dimensionOfFirst.getPosition().getX() + dimensionOfFirst.getWidth()
                >= dimensionOfSecond.getPosition().getX();
    }

    private boolean getWestCollision(Dimension dimensionOfFirst, Dimension dimensionOfSecond) {
        return dimensionOfFirst.getPosition().getX()
                <= dimensionOfSecond.getPosition().getX() + dimensionOfSecond.getWidth();
    }

    private boolean getSouthCollision(Dimension dimensionOfFirst, Dimension dimensionOfSecond) {
        return dimensionOfFirst.getPosition().getY() + dimensionOfFirst.getHeight()
                >= dimensionOfSecond.getPosition().getY();
    }

    private boolean getNorthCollision(Dimension dimensionOfFirst, Dimension dimensionOfSecond) {
        return dimensionOfFirst.getPosition().getY()
                <= dimensionOfSecond.getPosition().getY() + dimensionOfSecond.getHeight();
    }

    /**
     * Example of a generic method doClick()
     * Defining what happens when a physicalObject gets "clicked" by the mouse.
     */
    public void doClick() {
        selected = !isSelected();
    }

    /**
     * Getter
     */
    public Dimension getDimension() {
        return dimension;
    }

    public boolean isSelected() {
        return selected;
    }

}
