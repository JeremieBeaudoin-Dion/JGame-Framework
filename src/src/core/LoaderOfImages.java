package core;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * An ImageLoader is an object that returns images to the objectHandler.
 *
 * It has the method: toCompatibleImage, which greatly improves performance.
 */
public class LoaderOfImages {

    /**
     * Helper method to improve performance with images
     */
    protected BufferedImage toCompatibleImage(BufferedImage image) {
        // obtain the current system graphical settings
        GraphicsConfiguration gfx_config = GraphicsEnvironment.
                getLocalGraphicsEnvironment().getDefaultScreenDevice().
                getDefaultConfiguration();

        /*
        * if image is already compatible and optimized for current system
        * settings, simply return it
        */
        if (image.getColorModel().equals(gfx_config.getColorModel()))
            return image;

        // image is not optimized, so create a new image that is
        BufferedImage new_image = gfx_config.createCompatibleImage(
                image.getWidth(), image.getHeight(), image.getTransparency());

        // get the graphics context of the new image to draw the old image on
        Graphics2D g2d = (Graphics2D) new_image.getGraphics();

        // actually draw the image and dispose of context no longer needed
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();

        // return the new optimized image
        return new_image;
    }


}