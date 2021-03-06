package jGameFramework.physicalObjects;

/**
 * For performance purposes, some physical objects do not care about near objects
 * even if they are "updating". Giving them VisionNone is a good way to keep
 * performances high.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class VisionNone implements Vision {

    @Override
    public boolean isInSight(Position centerOfOwner, PhysicalObject other) {
        return false;
    }
}
