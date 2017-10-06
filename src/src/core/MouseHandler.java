package core;

import java.awt.event.MouseEvent;

/**
 * The Listener of the Mouse for the Game.
 *
 * Sends the actions to the InputHandler.
 *
 * @author Jérémie Beaudoin-Dion
 */
class MouseHandler implements java.awt.event.MouseListener {

    private Game gameReference;

    MouseHandler(Game gameReference){
        this.gameReference = gameReference;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        gameReference.getCurrentThread().getInputHandler().mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        gameReference.getCurrentThread().getInputHandler().mouseReleased(e);
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
