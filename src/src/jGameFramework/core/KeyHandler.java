package jGameFramework.core;

import jGameFramework.core.threadObjects.GameThreadHandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Jérémie Beaudoin-Dion
 */
class KeyHandler implements KeyListener {

    private GameThreadHandler gameThreadHandler;

    KeyHandler(GameThreadHandler gameThreadHandler){
        this.gameThreadHandler = gameThreadHandler;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        /*
         * TODO: Implement basic KeyType to send as string
         */
    }

    @Override
    public void keyPressed(KeyEvent e) {
        gameThreadHandler.getCurrentInputHandler().keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        gameThreadHandler.getCurrentInputHandler().keyReleased(e);
    }
}
