package actions;

import core.ObjectHandler;
import images.Position;

/**
 * @author Jérémie Beaudoin-Dion
 */
public class MouseLeftClickAction implements MouseClickAction {

    private static int TIME_LEFT_BEFORE_NEXT_EVENT = 0;
    private static int TIME_BETWEEN_EACH_EVENTS = 5;

    private Position positionOnScreen;

    /**
     * Constructor
     */
    public MouseLeftClickAction(Position positionOnScreen) {
        this.positionOnScreen = positionOnScreen;
    }

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
     * In this case, the ActionEvent is defined according to the MouseClickAction,
     * but the ActionEvent could also be passed as an argument for any MouseClickAction
     */
    @Override
    public ActionEvent doAction() throws NoSuchMethodException {
        TIME_LEFT_BEFORE_NEXT_EVENT = TIME_BETWEEN_EACH_EVENTS;

        return new ActionEvent<ObjectHandler>(ObjectHandler.class,
                ObjectHandler.class.getMethod("doClick", Position.class), positionOnScreen);
    }
}
