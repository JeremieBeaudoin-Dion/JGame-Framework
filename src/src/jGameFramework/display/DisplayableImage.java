package jGameFramework.display;

import jGameFramework.physicalObjects.PhysicalObject;
import jGameFramework.physicalObjects.Position;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Displays the desired image on screen
 *
 * @author Jérémie Beaudoin-Dion
 */
public class DisplayableImage extends Displayable {

    private Image image;

    /**
     * Constructor for basic PhysicalObject
     */
    public DisplayableImage(PhysicalObject baseObject, Position cameraPosition, Image image) {
        super(baseObject.getPositionAccordingToCamera(cameraPosition),
                new Position(image.getWidth(null), image.getHeight(null)),
                baseObject.getDepth());

        this.image = image;
    }

    /**
     * Constructor with specific position
     */
    public DisplayableImage(Position position, DisplayableDepth depth, Image image) {
        super(position, new Position(image.getWidth(null), image.getHeight(null)),
                depth);

        this.image = image;
    }

    public Image getImage(){
        return image;
    }

    /*
     * Test
     */
    public static void main(String[] args) {
        try {
            Image imageExample = ImageIO.read(new File("ImageExample.png"));

            System.out.println("Test width and height: " + testWidthAndHeight(imageExample));
        } catch (IOException e) {
            System.out.println("Image example was removed from folder");
            e.printStackTrace();
        }
    }

    private static boolean testWidthAndHeight(Image imageExample) {
        return imageExample.getWidth(null) == 800 && imageExample.getHeight(null) == 600;
    }

}
