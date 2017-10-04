package actionOfGameHere;

import actionOfGameHere.actions.*;
import core.ImageHandler;
import core.KeyHandler;
import core.MouseHandler;
import core.GameThread;
import coreActions.GameThreadEventQuit;
import images.Position;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;

/**
 * The InputHandler class handles input from the player and converts it to
 * actionOfGameHere that the actionHandler can handle.
 * 
 * @author Jérémie Beaudoin-Dion
 */
public class InputHandler {
	
	private ImageHandler imageHandler;
	
	// Enables player input
	private KeyHandler playerKeyboardInput;
	private MouseHandler playerMouseInput;
	
	/**
	 * Constructor
	 * 
	 * @param imageHandler: The reference ImageHandler object
	 */
	public InputHandler(ImageHandler imageHandler) {
		// Handles input
		playerKeyboardInput = new KeyHandler(imageHandler);
		playerMouseInput = new MouseHandler(imageHandler);
		
		this.imageHandler = imageHandler;
	}
	
	/**
	 * Gets the player input and sends it to the current GameThread if there is an action to do
	 */
	public void doInput(GameThread currentGameThread) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		
		if (playerKeyboardInput.isKeyDown(KeyEvent.VK_A) || playerKeyboardInput.isKeyDown(KeyEvent.VK_LEFT)){
			currentGameThread.doAction(new KeyboardActionMoveLeft());
		} 
		
		if (playerKeyboardInput.isKeyDown(KeyEvent.VK_D) || playerKeyboardInput.isKeyDown(KeyEvent.VK_RIGHT)){
			currentGameThread.doAction(new KeyboardActionMoveRight());
		} 
		
		if (playerKeyboardInput.isKeyDown(KeyEvent.VK_W) || playerKeyboardInput.isKeyDown(KeyEvent.VK_UP)){
			currentGameThread.doAction(new KeyboardActionMoveUp());
		}
		
		if (playerKeyboardInput.isKeyDown(KeyEvent.VK_S) || playerKeyboardInput.isKeyDown(KeyEvent.VK_DOWN)){
			currentGameThread.doAction(new KeyboardActionMoveDown());
		}

		if (playerKeyboardInput.isKeyDown(KeyEvent.VK_ESCAPE)){
			currentGameThread.doAction(new KeyboardActionEscape());
		}
		
		if (playerMouseInput.isLeftMouseDown()){
			Point mouse = imageHandler.getMousePosition();
			Position mousePositionOnScreen = new Position((int) mouse.getX(), (int) mouse.getY());

			currentGameThread.doAction(new MouseLeftClickAction(mousePositionOnScreen));
		}

		if (playerMouseInput.isRightMouseDown()){
			Point mouse = imageHandler.getMousePosition();
			Position mousePositionOnScreen = new Position((int) mouse.getX(), (int) mouse.getY());

			currentGameThread.doAction(new MouseRightClickAction(mousePositionOnScreen));
		}

	}

}
