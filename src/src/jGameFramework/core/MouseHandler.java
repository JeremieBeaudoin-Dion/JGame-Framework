package jGameFramework.core;

import jGameFramework.core.threadObjects.GameThreadHandler;

import java.awt.event.MouseEvent;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

/**
 * The Listener of the Mouse for the Game.
 *
 * Sends the actions to the InputHandler.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class MouseHandler implements java.awt.event.MouseListener {

    public enum MouseClick {Right, Left}

    private Map<Integer, MouseClick> integerToClickMap;

    private GameThreadHandler gameThreadHandler;

    MouseHandler(GameThreadHandler gameThreadHandler){
        this.gameThreadHandler = gameThreadHandler;

        integerToClickMap = new HashMap<>();
        integerToClickMap.put(MouseEvent.BUTTON3, MouseClick.Right);
        integerToClickMap.put(MouseEvent.BUTTON1, MouseClick.Left);
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        gameThreadHandler.getCurrentInputHandler().mousePressed(mouseEvent, integerToClickMap.get(mouseEvent.getButton()));
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        gameThreadHandler.getCurrentInputHandler().mouseReleased(mouseEvent, integerToClickMap.get(mouseEvent.getButton()));
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
