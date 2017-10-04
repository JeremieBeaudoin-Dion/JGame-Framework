package addGameObjectsHere;

import coreActions.ActionEvent;
import images.Dimension;
import images.Image;
import images.ImageObject;
import images.Position;
import physicalObjects.ObjectProperties;
import physicalObjects.PhysicalObject;
import physicalObjects.Velocity;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.TreeSet;

/**
 * An example of an image PhysicalObject
 *
 * @author Jérémie Beaudoin-Dion
 */
public class Example_Image extends PhysicalObject {

    private BufferedImage myImage;

    /**
     * Constructor
     */
    public Example_Image(BufferedImage myImage) {
        super(new ObjectProperties(new Dimension(0, 0, myImage.getWidth(), myImage.getHeight()),
                new Velocity(0, 0)));

        this.myImage = myImage;
    }

    /**
     * This example returns a simple image that is INDEPENDENT from the
     * position of the Camera
     */
    @Override
    public TreeSet<ImageObject> getImageObjects(Position cameraPosition) {
        TreeSet<ImageObject> myImageRepresentation = new TreeSet<>();

        Position positionOnScreen = getPositionAccordingToCamera(cameraPosition);

        myImageRepresentation.add(new Image(new Dimension(positionOnScreen, getProperties().getDimension().getWidth(),
                getProperties().getDimension().getHeight()), ImageObject.BACKGROUND, myImage));

        return myImageRepresentation;
    }

    @Override
    public void doClick() throws NoSuchMethodException {

    }

    @Override
    public List<ActionEvent> getAction() {
        return null;
    }

    @Override
    public boolean dispose() {
        return false;
    }
}
