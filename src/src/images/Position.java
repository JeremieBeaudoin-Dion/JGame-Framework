package images;

/**
 * A Position is an object which has two variables representing
 * the X axis and the Y axis as Integers.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class Position {

    private int x;
    private int y;

    /**
     * The constructor
     *
     * @param x: the X axis integer
     * @param y: the Y axis integer
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns a new position with the added values
     * of the current and the other
     */
    public Position add(Position other) {
        return new Position(x + other.getX(), y + other.getY());
    }

    /**
     * Using Pythagorean equation to find the true distance between two Positions
     */
    public double getDistance(Position other) {
        return Math.sqrt(Math.pow(x - other.getX(), 2.0) + Math.pow(x - other.getX(), 2.0));
    }

    /**
     * Getters
     */
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}