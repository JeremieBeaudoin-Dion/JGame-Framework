package addResourceLoaderHere;

import addGameObjectsHere.Player;
import jGameFramework.collections.InputActionKeyMap;
import jGameFramework.core.MouseHandler;
import jGameFramework.core.threadObjects.ObjectHandler;
import jGameFramework.coreActions.*;
import jGameFramework.physicalObjects.Position;
import jGameFramework.physicalObjects.Velocity;

import java.awt.event.KeyEvent;
import java.util.HashMap;

/**
 * @author Jérémie Beaudoin-Dion
 */
public class ActionLoader {

    public InputActionKeyMap getInputActionKeyMap(GameThreadID gameThreadID){

        switch (gameThreadID){
            case Menu:
                return getStartGameKeyMap();

            case Level1:
                return getLevel1KeyMap();
        }

        throw new IllegalArgumentException("The GameThreadID: " + gameThreadID + " is not implemented.");
    }

    private InputActionKeyMap getStartGameKeyMap(){
        HashMap<MouseHandler.MouseClick, Action> mouseActionMap = new HashMap<>();
        HashMap<Integer, Action> actionReleaseMap = new HashMap<>();

        try {
            GameEvent<ObjectHandler> clickEvent = new GameEvent<>(ObjectHandler.class, ObjectHandler.class.getMethod("doMouseReleased", Position.class));
            ActionTimed leftClickAction = new ActionTimed(clickEvent, 200);

            mouseActionMap.put(MouseHandler.MouseClick.Left, leftClickAction);

            // when L is released, load the game
            actionReleaseMap.put(KeyEvent.VK_L, new Action(new GameThreadEventLoad("savedGame.s")));

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return new InputActionKeyMap(null, actionReleaseMap, mouseActionMap, null);
    }

    private InputActionKeyMap getLevel1KeyMap(){
        HashMap<Integer, Action> actionPushMap = new HashMap<>();
        HashMap<Integer, Action> actionReleaseMap = new HashMap<>();
        HashMap<MouseHandler.MouseClick, Action> mouseClickMap = new HashMap<>();

        try {
            // When pushed, the actions are done
            Action playerGoingUp = new Action(new GameEvent<>(Player.class, Player.class.getMethod("addToMovingOrders", Velocity.Direction.class), Velocity.Direction.UP));
            actionPushMap.put(KeyEvent.VK_UP, playerGoingUp);

            Action playerGoingDown = new Action(new GameEvent<>(Player.class, Player.class.getMethod("addToMovingOrders", Velocity.Direction.class), Velocity.Direction.DOWN));
            actionPushMap.put(KeyEvent.VK_DOWN, playerGoingDown);

            Action playerGoingLeft = new Action(new GameEvent<>(Player.class, Player.class.getMethod("addToMovingOrders", Velocity.Direction.class), Velocity.Direction.LEFT));
            actionPushMap.put(KeyEvent.VK_LEFT, playerGoingLeft);

            Action playerGoingRight = new Action(new GameEvent<>(Player.class, Player.class.getMethod("addToMovingOrders", Velocity.Direction.class), Velocity.Direction.RIGHT));
            actionPushMap.put(KeyEvent.VK_RIGHT, playerGoingRight);

            // When released, the actions are removed.
            Action playerNotUp = new Action(new GameEvent<>(Player.class, Player.class.getMethod("removeToMovingOrders", Velocity.Direction.class), Velocity.Direction.UP));
            actionReleaseMap.put(KeyEvent.VK_UP, playerNotUp);

            Action playerNotDown = new Action(new GameEvent<>(Player.class, Player.class.getMethod("removeToMovingOrders", Velocity.Direction.class), Velocity.Direction.DOWN));
            actionReleaseMap.put(KeyEvent.VK_DOWN, playerNotDown);

            Action playerNotLeft = new Action(new GameEvent<>(Player.class, Player.class.getMethod("removeToMovingOrders", Velocity.Direction.class), Velocity.Direction.LEFT));
            actionReleaseMap.put(KeyEvent.VK_LEFT, playerNotLeft);

            Action playerNotRight = new Action(new GameEvent<>(Player.class, Player.class.getMethod("removeToMovingOrders", Velocity.Direction.class), Velocity.Direction.RIGHT));
            actionReleaseMap.put(KeyEvent.VK_RIGHT, playerNotRight);

            // when P is released, save the game
            actionReleaseMap.put(KeyEvent.VK_P, new Action(new GameThreadEventSave("savedGame.s")));

            // Mouse actions
            GameEvent<ObjectHandler> clickEvent = new GameEvent<>(ObjectHandler.class, ObjectHandler.class.getMethod("doMouseReleased", Position.class));
            ActionTimed leftClickAction = new ActionTimed(clickEvent, 200);

            mouseClickMap.put(MouseHandler.MouseClick.Left, leftClickAction);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return new InputActionKeyMap(actionPushMap, actionReleaseMap, mouseClickMap, null);
    }

}

