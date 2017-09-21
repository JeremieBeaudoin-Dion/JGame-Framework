package core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/** 
 * The current MouseLister, to handle mouse events. It stores 
 * the value of isLeftMouseDown in a boolean. MouseHandler can
 * then be called and know if the mouse is pressed or not with 
 * isLeftMouseDown.
 */ 
public class MouseHandler implements MouseListener {

	private boolean isLeftMouseDown = false;
	private boolean isRightMouseDown = false;

	/** 
     * Assigns the newly created MouseHandler to a Component 
     * @param c Component to get mouse input from 
     */ 
    public MouseHandler(Component c){ 
            c.addMouseListener(this);
    }
	
	/**
	 * Handles mouse events
	 */
	public void mousePressed(MouseEvent event) {

	    if (SwingUtilities.isLeftMouseButton(event)) {
	        isLeftMouseDown = true;
        }

        if (SwingUtilities.isRightMouseButton(event)) {
            isRightMouseDown = true;
        }
	}

	public void mouseReleased(MouseEvent event) {
        if (SwingUtilities.isLeftMouseButton(event)) {
            isLeftMouseDown = false;
        }

        if (SwingUtilities.isRightMouseButton(event)) {
            isRightMouseDown = false;
        }
	}
	
	/**
	 * 
	 * @return Whether the mouse is pressed or not
	 */
	public boolean isLeftMouseDown(){
		return isLeftMouseDown;
	}

	public boolean isRightMouseDown() {
	    return isRightMouseDown;
    }
	
	// Not used
	public void mouseClicked(MouseEvent e) {}

	public void mouseEntered(MouseEvent arg0) {}

	public void mouseExited(MouseEvent arg0) {}
}
