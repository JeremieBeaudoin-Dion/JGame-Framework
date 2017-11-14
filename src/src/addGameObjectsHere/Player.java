package addGameObjectsHere;

import addResourceLoaderHere.ImageLoader;
import jGameFramework.coreActions.GameEvent;
import jGameFramework.display.Displayable;
import jGameFramework.display.DisplayableShapeFilled;
import jGameFramework.display.DisplayableText;
import jGameFramework.physicalObjects.Position;
import jGameFramework.physicalObjects.*;

import java.awt.*;
import java.awt.geom.Ellipse2D;
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

    private static final int diameter = 50;

    private static final Font FONT_PLAYER = new Font("Century Schoolbook", Font.PLAIN, 25);

    /**
     * Constructor
     */
    public Player() {
        super(new BoundingArea(new Ellipse2D.Float(100, 100, diameter, diameter)), true,
                new VisionRectangle(200, 200), new VelocitySquare(2, 2));

        generator = new Random();

        setRandomColor();
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

        imagesToShowOnScreen.add(new DisplayableShapeFilled(Displayable.Depth.FOREGROUND,
                new Ellipse2D.Float(positionOnScreen.getX(), positionOnScreen.getY(), diameter, diameter), color));

        Position positionOfText = positionOnScreen.add(new Position(diameter/2,diameter/2));

        imagesToShowOnScreen.add(new DisplayableText(positionOfText, Displayable.Depth.FLOATING,"Player!",
                FONT_PLAYER, Color.GREEN));

        return imagesToShowOnScreen;
    }

    /**
     * Change the color of the player randomly on left click
     */
    @Override
    public void doLeftMouseReleased() {
        setRandomColor();
    }

    private void setRandomColor() {
        color = new Color(getRandomRGBValue(), getRandomRGBValue(), getRandomRGBValue());
    }

    private int getRandomRGBValue() {
        return generator.nextInt(256);
    }

    @Override
    public void doLeftMousePressed() {

    }

    @Override
    public void doRightMouseReleased(){

    }

    @Override
    public void doRightMousePressed(){

    }

    @Override
    public List<GameEvent> getAction() {
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
