package physicalObjects;

import display.Position;

/**
 * A type of vision which works as a rectangle
 *
 * The Position send to the constructor should represent
 * the rectangle that surrounds the object.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class VisionRectangle implements Vision {

    private Position addToGetNorthWestPosition;
    private Position widthAndHeight;

    /**
     * Constructor with the full width and height of the rectangle
     * that represents the vision
     */
    public VisionRectangle(Position dimension) {
        this.addToGetNorthWestPosition = new Position(-dimension.getX()/2, -dimension.getY()/2);
        widthAndHeight = dimension.clone();
    }

    /**
     * Returns true if the baseObject can see the other according
     * to this vision's dimensions
     */
    public boolean isInSight(PhysicalObject baseObject, PhysicalObject other) {

        Dimension dimension = new Dimension(baseObject.getDimension().getPosition().add(addToGetNorthWestPosition),
                widthAndHeight.getX(), widthAndHeight.getY());

        return dimension.collidesWith(other.getDimension());
    }

}
