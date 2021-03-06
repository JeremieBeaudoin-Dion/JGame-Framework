package jGameFramework.physicalObjects;

/**
 * Represents the position, width and height of an image.
 *
 * These dimensions may not be changed.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class PlaneDimension {

    private Position position;
    private Position dimensions;

    public PlaneDimension(Position position, Position dimensions) {
        this.position = position;
        this.dimensions = dimensions;
    }

    public Position getPosition() {
        return position.clone();
    }

    public Position getDimensions() {
        return dimensions.clone();
    }

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }

    public int getWidth() {
        return dimensions.getX();
    }

    public int getHeight() {
        return dimensions.getY();
    }

    public Position getCenter() {
        return getPosition().add(new Position(dimensions.getX()/2, dimensions.getY()/2));
    }
}
