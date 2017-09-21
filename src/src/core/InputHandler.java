package core;

import actions.*;
import images.Position;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;

/**
 * The InputHandler class handles input from the player and converts it to
 * actions that the actionHandler can handle.
 * 
 * @author Jérémie Beaudoin-Dion
 */
public class InputHandler {
	
	private ImageHandler imageHandler;
	
	// Enables player input
	private KeyHandler playerKeyboardInput;
	private MouseHandler playerMouseInput;

	private ActionHandler actionHandler;
	
	/**
	 * Constructor
	 * 
	 * @param imageHandler: The reference ImageHandler object
	 */
	public InputHandler(ImageHandler imageHandler, ActionHandler actionHandler) {
		// Handles input
		playerKeyboardInput = new KeyHandler(imageHandler);
		playerMouseInput = new MouseHandler(imageHandler);

		this.actionHandler = actionHandler;
		
		this.imageHandler = imageHandler;
	}
	
	/**
	 * Gets the player input and sends it to the actionHandler if there is an action to do
	 */
	public void doInput() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		
		if (playerKeyboardInput.isKeyDown(KeyEvent.VK_A) || playerKeyboardInput.isKeyDown(KeyEvent.VK_LEFT)){
			actionHandler.doAction(new KeyboardActionMoveLeft());
		} 
		
		if (playerKeyboardInput.isKeyDown(KeyEvent.VK_D) || playerKeyboardInput.isKeyDown(KeyEvent.VK_RIGHT)){
			actionHandler.doAction(new KeyboardActionMoveRight());
		} 
		
		if (playerKeyboardInput.isKeyDown(KeyEvent.VK_W) || playerKeyboardInput.isKeyDown(KeyEvent.VK_UP)){
			actionHandler.doAction(new KeyboardActionMoveUp());
		}
		
		if (playerKeyboardInput.isKeyDown(KeyEvent.VK_S) || playerKeyboardInput.isKeyDown(KeyEvent.VK_DOWN)){
			actionHandler.doAction(new KeyboardActionMoveDown());
		}
		
		if (playerMouseInput.isLeftMouseDown()){
			Point mouse = imageHandler.getMousePosition();
			Position mousePositionOnScreen = new Position((int) mouse.getX(), (int) mouse.getY());

			actionHandler.doAction(new MouseLeftClickAction(mousePositionOnScreen));
		}

		if (playerMouseInput.isRightMouseDown()){
			Point mouse = imageHandler.getMousePosition();
			Position mousePositionOnScreen = new Position((int) mouse.getX(), (int) mouse.getY());

			actionHandler.doAction(new MouseRightClickAction(mousePositionOnScreen));
		}

	}

}
