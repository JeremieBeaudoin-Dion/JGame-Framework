package core;

import actionOfGameHere.actions.*;
import coreActions.Action;
import coreActions.ActionEvent;
import physicalObjects.Camera;

import java.lang.reflect.InvocationTargetException;

/**
 * Receives Actions from the InputHandler and sends
 * an ActionEvent to the correct class.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class ActionHandler {

    private ObjectHandler objectHandler;

    /**
     * Constructor
     */
    public ActionHandler(ObjectHandler objectHandler) {
        this.objectHandler = objectHandler;
    }

    /**
     * Sends an action to do in the game
     */
    public void doAction(Action currentAction) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        if (currentAction.isDoable()) {
            handleActionEvent(currentAction.doAction());
        }
    }

    @SuppressWarnings("unchecked")
    private void handleActionEvent(ActionEvent actionEvent) throws InvocationTargetException, IllegalAccessException {
        if (actionEvent.getClassValue() == Camera.class){
            actionEvent.doAction(objectHandler.getCamera());

        } else if (actionEvent.getClassValue() == ObjectHandler.class) {
            actionEvent.doAction(objectHandler);

        } else if (actionEvent.getClassValue() == Game.class) {

        }
    }

    /**
     * Called every frame
     */
    public void update() {
        updateAllActions();
    }

    /**
     * Updates the ticks of every action
     */
    private void updateAllActions() {
        KeyboardActionMoveRight.update();
        KeyboardActionMoveDown.update();
        KeyboardActionMoveLeft.update();
        KeyboardActionMoveUp.update();

        MouseLeftClickAction.update();
        MouseRightClickAction.update();
    }

}
