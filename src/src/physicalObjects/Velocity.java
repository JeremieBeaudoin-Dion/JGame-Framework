package physicalObjects;

import images.Position;

/**
 * A velocity determines how much a PhysicalObject
 * should move in a certain direction according to
 * its speed.
 *
 * @author Jérémie Beaudoin-Dion
 */
public interface Velocity {

    Position goRight();

    Position goLeft();

    Position goUp();

    Position goDown();

}
