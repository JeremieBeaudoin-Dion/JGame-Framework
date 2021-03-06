package addGameObjectsHere;

import addResourceLoaderHere.ImageLoader;
import jGameFramework.coreActions.GameEvent;
import jGameFramework.coreActions.GameThreadEventQuit;
import jGameFramework.display.Displayable;
import jGameFramework.display.DisplayableDepth;
import jGameFramework.display.DisplayableShapeFilled;
import jGameFramework.display.DisplayableText;
import jGameFramework.physicalObjects.Position;
import jGameFramework.physicalObjects.*;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

/**
 * An jGameFramework.example of a simple Player object.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class Player extends PhysicalObjectMoving implements MouseInteractingPhysicalObject {

    private Color color;
    private Random generator;

    private static final int START_X = 400;
    private static final int START_Y = 200;

    private boolean iAmDead;

    private static final int diameter = 50;

    private static final Font FONT_PLAYER = new Font("Century Schoolbook", Font.PLAIN, 25);

    /**
     * Constructor
     */
    public Player() {
        super(new BoundingArea(new Ellipse2D.Float(START_X, START_Y, diameter, diameter)), true,
                new DisplayableDepth(DisplayableDepth.MIDDLE+10), new VisionRectangle(200, 200),
                new VelocitySquare(2, 2));

        generator = new Random();
        iAmDead = false;
        setRandomColor();
    }

    public void reset() {
        setPositionTo(new Position(START_X, START_Y));
        removeAllMovingOrders();
        iAmDead = false;
    }

    @Override
    public TreeSet<PhysicalObject> update(TreeSet<PhysicalObject> surroundings) {
        updateAndMove(surroundings);

        return null;
    }

    @Override
    public TreeSet<Displayable> getImageObjects(Position cameraPosition, ImageLoader imageLoader) {
        TreeSet<Displayable> imagesToShowOnScreen = new TreeSet<>();

        Position positionOnScreen = getPositionAccordingToCamera(cameraPosition);

        imagesToShowOnScreen.add(new DisplayableShapeFilled(getDepth(),
                new Ellipse2D.Float(positionOnScreen.getX(), positionOnScreen.getY(), diameter, diameter), color));

        Position positionOfText = positionOnScreen.add(new Position(diameter/2,diameter/2));

        imagesToShowOnScreen.add(new DisplayableText(positionOfText, getDepth().add(100),"Player!",
                FONT_PLAYER, Color.GREEN, DisplayableText.Alignment.center));

        return imagesToShowOnScreen;
    }

    /**
     * Change the color of the player randomly on left click
     */
    @Override
    public void doLeftMouseReleased(Position mousePositionCollidingWithObject) {
        setRandomColor();
    }

    private void setRandomColor() {
        color = new Color(getRandomRGBValue(), getRandomRGBValue(), getRandomRGBValue());
    }

    private int getRandomRGBValue() {
        return generator.nextInt(256);
    }

    @Override
    public void doLeftMousePressed(Position mousePositionCollidingWithObject) {

    }

    @Override
    public void doRightMouseReleased(Position mousePositionCollidingWithObject){

    }

    @Override
    public void doRightMousePressed(Position mousePositionCollidingWithObject){

    }

    @Override
    public List<GameEvent> getAction() {
        List<GameEvent> allEvents = new LinkedList<>();

        if (iAmDead) {
            allEvents.add(new GameThreadEventQuit());
        }

        return allEvents;
    }

    /**
     * If the player would be disposed, the current
     * GameThread will be quit.
     */
    @Override
    public boolean dispose() {
        return false;
    }

    void kill() {
        iAmDead = true;
    }

    @Override
    public void resize(Position lastScreenSize, Position newScreenSize) {
        // do nothing
    }

}
