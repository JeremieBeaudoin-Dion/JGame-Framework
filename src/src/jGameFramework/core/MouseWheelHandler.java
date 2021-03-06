package jGameFramework.core;

import jGameFramework.core.threadObjects.GameThreadHandler;
import jGameFramework.physicalObjects.PlaneDimension;
import jGameFramework.physicalObjects.Position;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

/**
 * The listener for the mouse wheel.
 *
 * Sends the actions to the InputHandler.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class MouseWheelHandler implements MouseWheelListener {

    public enum MouseWheel {ScrollUp, ScrollDown}

    private GameThreadHandler gameThreadHandler;

    MouseWheelHandler(GameThreadHandler gameThreadHandler){
        this.gameThreadHandler = gameThreadHandler;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent) {
        if (mouseWheelEvent.getWheelRotation() < 0) {
            gameThreadHandler.getCurrentInputHandler().mouseWheelMoved(MouseWheel.ScrollUp, getDimensionOfWheelEvent(mouseWheelEvent));
        } else {
            gameThreadHandler.getCurrentInputHandler().mouseWheelMoved(MouseWheel.ScrollDown, getDimensionOfWheelEvent(mouseWheelEvent));
        }
    }

    /**
     * For now, the wheel will only scroll up and down.
     *
     * This will return the position of the mouse and its height: the amount of scrolling.
     */
    private PlaneDimension getDimensionOfWheelEvent(MouseWheelEvent mouseWheelEvent) {
        Position position = MouseHandler.getMousePositionRelativeToScreen(new Position(mouseWheelEvent.getX(), mouseWheelEvent.getY()));

        Integer height = Math.abs(mouseWheelEvent.getWheelRotation());

        return new PlaneDimension(position, new Position(0, height));
    }

}
