package addGameObjectsHere;

import coreActions.ActionEvent;
import images.Dimension;
import images.ImageObject;
import images.Position;
import images.Rectangle;
import images.Text;
import physicalObjects.*;

import java.awt.*;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

/**
 * An example of a simple Player object.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class Player extends PhysicalObjectMoving {

    private Stack<Integer> actionsToDo;

    public static final int MOVE_UP = 0;
    public static final int MOVE_DOWN = 1;
    public static final int MOVE_LEFT = 2;
    public static final int MOVE_RIGHT = 3;

    private static final Font FONT_PLAYER = new Font("Century Schoolbook", Font.PLAIN, 25);

    /**
     * Constructor
     */
    public Player(Dimension dimension, Vision vision, VelocitySquare velocity) {
        super(dimension, vision, velocity);

        actionsToDo = new Stack<>();
    }

    /**
     * Invoked method.
     *
     * This will store the actionID into a stack. The update()
     * method will go through that stack and will consider the
     * surroundings of the player before making a move.
     */
    public void storeAction(Integer actionID){
        actionsToDo.push(actionID);
    }

    @Override
    public TreeSet<PhysicalObject> update(TreeSet<PhysicalObject> surroundings) {
        handleActionsToDo(surroundings);
        return null;
    }

    /**
     * Goes through the stack of actions and sends them to the handler
     */
    private void handleActionsToDo(TreeSet<PhysicalObject> surroundings){
        while(!actionsToDo.isEmpty()){
            handleAction(surroundings, actionsToDo.pop());
        }
    }

    private void handleAction(TreeSet<PhysicalObject> surroundings, Integer action){
        switch (action){
            case MOVE_UP:
                moveUp(surroundings);
                break;

            case MOVE_DOWN:
                moveDown(surroundings);
                break;

            case MOVE_LEFT:
                moveLeft(surroundings);
                break;

            case MOVE_RIGHT:
                moveRight(surroundings);
        }
    }

    @Override
    public TreeSet<ImageObject> getImageObjects(Position cameraPosition) {
        Position positionOnScreen = getPositionAccordingToCamera(cameraPosition);

        TreeSet<ImageObject> imagesToShowOnScreen = new TreeSet<>();

        imagesToShowOnScreen.add(new Rectangle(new Dimension(positionOnScreen, getDimension().getWidth(),
                getDimension().getHeight()),
                ImageObject.FOREGROUND, Color.darkGray, true));

        Position positionOfText = positionOnScreen.add(new Position(getDimension().getWidth()/3,
                        getDimension().getHeight()/2));

        imagesToShowOnScreen.add(new Text(positionOfText, "Player!", FONT_PLAYER,
                Color.GREEN, ImageObject.FLOATING));

        return imagesToShowOnScreen;
    }

    @Override
    public void doClick() throws NoSuchMethodException {

    }

    @Override
    public List<ActionEvent> getAction() {
        return null;
    }

    /**
     * If the player would be disposed, the current
     * GameThread will be quit.
     */
    @Override
    public boolean dispose() {
        return false;
    }
}
