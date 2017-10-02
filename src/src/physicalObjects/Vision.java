package physicalObjects;

/**
 * Returns true if another object is in sight
 *
 * @author Jérémie Beaudoin-Dion
 */
public interface Vision {

    boolean isInSight(PhysicalObject baseObject, PhysicalObject other);

}
