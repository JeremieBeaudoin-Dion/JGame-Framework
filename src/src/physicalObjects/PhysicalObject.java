package physicalObjects;

import coreActions.GameEvent;
import display.Displayable;
import display.Position;

import java.util.List;
import java.util.TreeSet;

/**
 * A physical object has a Displayable representation of itself
 * that can be put on screen.
 *
 * @author Jérémie Beaudoin-Dion
 */
public abstract class PhysicalObject implements Comparable<PhysicalObject> {

    private static int ORDER_OF_APPEARANCE = 0;

    private Dimension dimension;

    private boolean obstacle;

    private int appearanceNumber;

    /**
     * Constructor
     */
    public PhysicalObject(Dimension dimension, boolean isObstacle) {
        this.dimension = dimension;
        this.obstacle = isObstacle;

        appearanceNumber = ORDER_OF_APPEARANCE++;
    }

    /**
     * Returns the image representation of this physical object
     *
     * The ImageObject will have a relative position depending
     * on the position of the CameraWithEdges.
     */
    public abstract TreeSet<Displayable> getImageObjects(Position cameraPosition);

    public abstract void doClick() throws NoSuchMethodException;

    public abstract List<GameEvent> getAction();

    public abstract boolean dispose();

    /**
     * PhysicalObjects are compared according to
     * their position on the screen
     */
    @Override
    public int compareTo(PhysicalObject other) {
        if (getDimension().getPosition().compareTo(other.getDimension().getPosition()) == 0){
            return appearanceNumber - other.appearanceNumber;
        }

        return getDimension().getPosition().compareTo(other.getDimension().getPosition());
    }

    /**
     * Places the PhysicalObject at the desiredPosition
     */
    public void setPositionTo(Position newPosition) {
        this.getDimension().setPosition(newPosition);
    }

    public boolean isColliding(Position position) {
        Dimension dimensionOfPoint = new Dimension(position, 1, 1);

        return getDimension().collidesWith(dimensionOfPoint);
    }

    public boolean isColliding(PhysicalObject other) {
        return getDimension().collidesWith(other.getDimension());
    }

    public boolean isColliding(Dimension dimension){
        return getDimension().collidesWith(dimension);
    }

    /**
     * Getter
     */
    public Dimension getDimension() {
        return dimension;
    }

    /**
     * If an other object can pass through this one
     */
    public boolean isObstacle(){
        return obstacle;
    }

    /**
     * Useful method to get the value of the current position according
     * to the camera's. It is mostly useful when creating the TreeSet of
     * the ImageObjects of this object.
     */
    protected Position getPositionAccordingToCamera(Position cameraPosition) {

        return getDimension().getPosition().add(
                new Position(-cameraPosition.getX(), -cameraPosition.getY()));
    }

    protected Dimension getObjectDimensionAtPosition(Position position){
        return new Dimension(position.clone(),
                getDimension().getWidth(), getDimension().getHeight());
    }

    @Override
    public String toString(){
        return "PhysicalObject: " + this.getClass() + " at Position: " +
                getDimension().getPosition().toString();
    }

}
