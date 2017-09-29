package addGameObjectsHere;

import coreActions.ActionEvent;
import images.Dimension;
import images.Ellipse;
import images.ImageObject;
import images.Position;
import physicalObjects.ObjectProperties;
import physicalObjects.PhysicalObject;
import physicalObjects.Velocity;

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
        super(new ObjectProperties(new Dimension(100, 100, 50, 50), new Velocity(0, 0)));
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
    public List<ActionEvent> getAction() {
        return null;  // Never returns actions
    }

    @Override
    public TreeSet<ImageObject> getImageObjects(Position cameraPosition) {
        Position positionOnScreen = getPositionAccordingToCamera(cameraPosition);

        TreeSet<ImageObject> screenRepresentation = new TreeSet<>();

        screenRepresentation.add(new Ellipse(new Dimension(positionOnScreen, getProperties().getDimension().getWidth(),
                getProperties().getDimension().getHeight()), ImageObject.FOREGROUND, buttonColor, true));

        return screenRepresentation;
    }
}
