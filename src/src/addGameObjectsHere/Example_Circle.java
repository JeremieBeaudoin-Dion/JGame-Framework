package addGameObjectsHere;

import coreActions.GameEvent;
import physicalObjects.Dimension;
import display.Ellipse;
import display.ImageObject;
import display.Position;
import physicalObjects.PhysicalObject;

import java.awt.*;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

/**
 * An example of a simple PhysicalObject
 *
 * @author Jérémie Beaudoin-Dion
 */
public class Example_Circle extends PhysicalObject {

    private Color buttonColor;
    private Random generator;

    /**
     * Constructor
     */
    public Example_Circle() {
        super(new Dimension(100, 100, 50, 50), true);
        generator = new Random();
        setRandomColor();
    }

    private void setRandomColor() {
        buttonColor = new Color(getRandomRGBValue(), getRandomRGBValue(), getRandomRGBValue());
    }

    private int getRandomRGBValue() {
        return generator.nextInt(256);
    }

    /**
     * Changes the color of the button randomly
     */
    @Override
    public void doClick() {
        setRandomColor();
    }

    @Override
    public List<GameEvent> getAction() {
        return null;  // Never returns actions
    }

    @Override
    public boolean dispose() {
        return false;
    }

    /**
     * This PhysicalObject will return a simple circle that is
     * DEPENDENT from the position of the CameraWithEdges. It will
     * move according to it.
     */
    @Override
    public TreeSet<ImageObject> getImageObjects(Position cameraPosition) {
        Position positionOnScreen = getPositionAccordingToCamera(cameraPosition);

        TreeSet<ImageObject> screenRepresentation = new TreeSet<>();

        screenRepresentation.add(new Ellipse(new Dimension(positionOnScreen, getDimension().getWidth(),
                getDimension().getHeight()), ImageObject.FOREGROUND, buttonColor, true));

        return screenRepresentation;
    }
}
