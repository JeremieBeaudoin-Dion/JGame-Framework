package core;

import coreActions.InputActionKeyMap;
import display.Position;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;

/**
 * The InputHandler class handles input from the player and converts it to
 * actionOfGameHere that the actionHandler can handle.
 * 
 * @author Jérémie Beaudoin-Dion
 */
class InputHandler {

	private ActionHandler actionHandler;

	// Stores what to do with KeyEvents and MouseEvents
	private InputActionKeyMap inputActionKeyMap;
	
	/**
	 * Constructor
	 *
	 * @param inputActionKeyMap: The binds between each KeyEvent and
	 */
	InputHandler(InputActionKeyMap inputActionKeyMap, ActionHandler actionHandler) {
		this.actionHandler = actionHandler;

		if (inputActionKeyMap == null){
			this.inputActionKeyMap = new InputActionKeyMap(null, null,null,null);
		} else {
			this.inputActionKeyMap = inputActionKeyMap;
		}

	}

	/**
	 * Called when a key is pressed by the KeyListener
	 * @param event KeyEvent sent by the component
	 */
	void keyPressed(KeyEvent event) {

		try{
			actionHandler.doAction(inputActionKeyMap.getKeyDown(event.getKeyCode()));

		} catch (UnsupportedOperationException e){
			// The keyEvent does not return an action to do

		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
			// Something went wrong in the code, the ActionHandler cannot do said action
		}

	}

	/**
	 * Called when a key is released by the KeyListener
	 * @param event KeyEvent sent by the component
	 */
	void keyReleased(KeyEvent event) {
		try{
			actionHandler.doAction(inputActionKeyMap.getKeyRelease(event.getKeyCode()));

		} catch (UnsupportedOperationException e){
			// The keyEvent does not return an action to do

		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
			// Something went wrong in the code, the ActionHandler cannot do said action
		}
	}

	void mousePressed(MouseEvent mouseEvent) {
		try{
			actionHandler.doAction(inputActionKeyMap.getMouseDown(mouseEvent.getButton()),
                    getTrueMousePosition(mouseEvent));

		} catch (UnsupportedOperationException e){
			// The keyEvent does not return an action to do

		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
			// Something went wrong in the code, the ActionHandler cannot do said action
		}
	}

	void mouseReleased(MouseEvent mouseEvent) {
		try{
			actionHandler.doAction(inputActionKeyMap.getMouseDown(mouseEvent.getButton()),
                    getTrueMousePosition(mouseEvent));

		} catch (UnsupportedOperationException e){
			// The keyEvent does not return an action to do

		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
			// Something went wrong in the code, the ActionHandler cannot do said action
		}
	}

	private Position getTrueMousePosition(MouseEvent mouseEvent){
	    Position positionAccordingToScreen = new Position(mouseEvent.getX(), mouseEvent.getY());

	    return positionAccordingToScreen.add(new Position(-ImageHandler.INSETS.left, -ImageHandler.INSETS.top));
    }
}
