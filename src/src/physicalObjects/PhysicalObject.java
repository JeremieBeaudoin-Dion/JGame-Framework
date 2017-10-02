package physicalObjects;

import coreActions.ActionEvent;
import images.Dimension;
import images.ImageObject;
import images.Position;

import java.util.List;
import java.util.TreeSet;

/**
 * A physical object has an ImageObject representation of itself
 * that can be put on screen.
 *
 * Note: this class has a natural ordering that is inconsistent with equals.
 *
 * @author Jérémie Beaudoin-Dion
 */
public abstract class PhysicalObject implements Comparable<PhysicalObject> {

    private ObjectProperties properties;

    /**
     * Constructor
     */
    public PhysicalObject(ObjectProperties properties) {
        this.properties = properties;
    }

    /**
     * Returns the image representation of this physical object
     *
     * The ImageObject will have a relative position depending
     * on the position of the Camera.
     */
    public abstract TreeSet<ImageObject> getImageObjects(Position cameraPosition);

    public abstract void doClick() throws NoSuchMethodException;

    public abstract List<ActionEvent> getAction();

    public abstract boolean dispose();

    /**
     * PhysicalObjects are compared according to
     * their position on the screen
     */
    @Override
    public int compareTo(PhysicalObject other) {
        return properties.getDimension().getPosition().compareTo(other.getProperties().getDimension().getPosition());
    }

    /**
     * Places the PhysicalObject at the desiredPosition
     */
    public void moveTo(Position newPosition) {
        this.properties.getDimension().setPosition(newPosition);
    }

    /**
     * Returns true if this physical object collides with a Position
     */
    public boolean isColliding(Position position) {
        Dimension dimensionOfPoint = new Dimension(position, 1, 1);

        return getEastCollision(properties.getDimension(), dimensionOfPoint) &&
                getWestCollision(properties.getDimension(), dimensionOfPoint) &&
                getSouthCollision(properties.getDimension(), dimensionOfPoint) &&
                getNorthCollision(properties.getDimension(), dimensionOfPoint);
    }

    /**
     * Returns true if this physical object is colliding with another
     */
    public boolean isColliding(PhysicalObject other) {
        return getEastCollision(properties.getDimension(), other.getProperties().getDimension()) &&
                getWestCollision(properties.getDimension(), other.getProperties().getDimension()) &&
                getSouthCollision(properties.getDimension(), other.getProperties().getDimension()) &&
                getNorthCollision(properties.getDimension(), other.getProperties().getDimension());
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
     * Getter
     */
    public ObjectProperties getProperties() {
        return properties;
    }

    /**
     * Useful method to get the value of the current position according
     * to the camera's. It is mostly useful when creating the TreeSet of
     * the ImageObjects of this object.
     */
    protected Position getPositionAccordingToCamera(Position cameraPosition) {

        return getProperties().getDimension().getPosition().add(
                new Position(-cameraPosition.getX(), -cameraPosition.getY()));
    }

}
