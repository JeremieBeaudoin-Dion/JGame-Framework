package jGameFramework.display;

import jGameFramework.physicalObjects.Position;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
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
     * Constructors
     */
    public DisplayableImage(Position position, int depth, Image image) {
        super(position, new Position(image.getWidth(null), image.getHeight(null)),
                new DisplayableDepth(depth));

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
