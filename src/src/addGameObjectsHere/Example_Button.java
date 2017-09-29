package addGameObjectsHere;

import addGameThreadCreatorHere.GameThreadCreator;
import core.Game;
import coreActions.ActionEvent;
import coreActions.GameThreadEventNew;
import images.*;
import images.Dimension;
import images.Rectangle;
import physicalObjects.*;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * An example of a button which, on click, will return an action
 * that will set the game to a new thread (GAME_LEVEL_1 in this case).
 *
 * This example is pretty simple and could have been set as a child
 * of a parent Button, but it should be a good example of the use
 * of the Framework.
 *
 * The action is set to null every frame, to ensure that it is
 * done only once.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class Example_Button extends PhysicalObject {

    private static final Font FONT_BUTTON = new Font("Century Schoolbook", Font.PLAIN, 25);

    private ActionEvent actionToDo;

    /**
     * Constructor
     *
     * In this example, no argument is passed as Position, which is simpler
     * but less viable. A position could be passed to make the Button more
     * generic.
     */
    public Example_Button() {
        super(new ObjectProperties(new Dimension(new Position(Game.WINDOW_HEIGHT/2, Game.WINDOW_WIDTH/2),
                300, 50), new Velocity(0, 0)));

        actionToDo = null;
    }

    /**
     * Returns a square with the text "PLAY!" printed on it.
     *
     * In this example, the images of this button are INDEPENDENT
     * of the position of the camera.
     */
    @Override
    public TreeSet<ImageObject> getImageObjects(Position cameraPosition) {
        TreeSet<ImageObject> imagesToShowOnScreen = new TreeSet<>();

        imagesToShowOnScreen.add(new Rectangle(getProperties().getDimension().clone(),
                ImageObject.FOREGROUND, Color.darkGray, true));

        Position positionOfText = getProperties().getDimension().getPosition().add(
                new Position(getProperties().getDimension().getWidth()/3,
                getProperties().getDimension().getHeight()/2));

        imagesToShowOnScreen.add(new Text(positionOfText, "PLAY!", FONT_BUTTON,
                Color.GREEN, ImageObject.FLOATING));

        return imagesToShowOnScreen;
    }

    @Override
    public void doClick() throws NoSuchMethodException {
        actionToDo = new GameThreadEventNew(GameThreadCreator.GAME_LEVEL_1);
    }

    /**
     * Returns a list of actions to do. In this case, it will only
     * have one element if any.
     *
     * Ensures that the action is set back to null after it is called
     */
    @Override
    public List<ActionEvent> getAction() {
        List<ActionEvent> actionsToDo = new LinkedList<>();

        if (actionToDo != null) {
            actionsToDo.add(actionToDo);
            actionToDo = null;
        }

        return actionsToDo;
    }

}
