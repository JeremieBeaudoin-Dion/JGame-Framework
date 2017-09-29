package physicalObjects;

import images.Position;

/**
 * The x and y speed of any object
 *
 * When calling the goRight(), goLeft(), goUp() or goDown()
 * the Velocity returns a position that can be added to any
 * position in order to move to the desired direction.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class Velocity {

    private int x;
    private int y;

    /**
     * Constructor
     */
    public Velocity(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public Position goRight() {
        return new Position(x, 0);
    }

    public Position goLeft() {
        return new Position(-x, 0);
    }

    public Position goUp() {
        return new Position(0, -y);
    }

    public Position goDown() {
        return new Position(0, y);
    }
}
