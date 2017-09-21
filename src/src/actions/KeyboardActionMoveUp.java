package actions;

import physicalObjects.Camera;

/**
 * @author Jérémie Beaudoin-Dion
 */
public class KeyboardActionMoveUp implements KeyboardActionMove {

    private static int TIME_LEFT_BEFORE_NEXT_EVENT = 0;
    private static int TIME_BETWEEN_EACH_EVENTS = 0;

    public static void update() {
        TIME_LEFT_BEFORE_NEXT_EVENT -= 1;

        if (TIME_LEFT_BEFORE_NEXT_EVENT < 0) {
            TIME_LEFT_BEFORE_NEXT_EVENT = 0;
        }
    }

    @Override
    public boolean isDoable() {
        return TIME_LEFT_BEFORE_NEXT_EVENT <= 0;
    }

    /**
     * In this case, the ActionEvent is defined according to the KeyboardActionMove,
     * but the ActionEvent could also be passed as an argument for any KeyboardAction
     */
    @Override
    public ActionEvent doAction() throws NoSuchMethodException {
        TIME_LEFT_BEFORE_NEXT_EVENT = TIME_BETWEEN_EACH_EVENTS;

        return new ActionEvent<Camera>(Camera.class, Camera.class.getMethod("moveUp"));
    }

}
