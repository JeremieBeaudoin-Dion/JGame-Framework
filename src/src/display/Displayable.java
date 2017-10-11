package display;

/**
 * Displayables are objects which can be displayed on screen
 * using the ImageHandler.
 *
 * Their Depth represent the order in which the Displayables will be put,
 * to make sure a Foreground object is over a Background object.
 *
 * @author Jérémie Beaudoin-Dion
 */
public abstract class Displayable implements Comparable<Displayable> {

    public enum Depth {
        BACKGROUND, FOREGROUND, FLOATING
    }

    private Depth depth;
    private Position position;

    /**
     * Constructors
     */
    public Displayable(Position position, Depth depth) {
        this.depth = depth;
        this.position = position;
    }

    public Position getPosition(){
        return position;
    }

    /**
     * Displayables are foremost compared with their depth values.
     * A FLOATING image will be added to the frame after any FOREGROUND
     * display, for example.
     *
     * If the depth values are the same, the positions are compared
     *
     * //todo: check equal
     */
    @Override
    public int compareTo(Displayable other) {
        if (depth == other.depth) {
            return position.compareTo(other.getPosition());
        }

        return depth.compareTo(other.depth);
    }

}
