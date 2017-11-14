package jGameFramework.physicalObjects;

/**
 * Any object that implements this interface can interact
 * with the mouse (click, pressed, released).
 *
 * @author Jérémie Beaudoin-Dion
 */
public interface MouseInteractingPhysicalObject {

    void doLeftMousePressed();

    void doLeftMouseReleased();

    void doRightMousePressed();

    void doRightMouseReleased();

}
