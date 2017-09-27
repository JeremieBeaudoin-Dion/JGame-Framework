package addImagesHere;

/**
 * @author Jérémie Beaudoin-Dion
 */
import core.LoaderOfImages;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Loads main menu images
 *
 * @author Jérémie Beaudoin-Dion
 */
public class ImageLoader extends LoaderOfImages {

    /**
     * Basic constructor
     * @throws IOException if an image is missing
     */
    public ImageLoader() throws IOException {

        loadAllImages();

    }

    /**
     * Loads all image from file
     * @throws IOException : if the image is missing
     */
    private void loadAllImages() throws IOException {

        BufferedImage desiredImage = toCompatibleImage(ImageIO.read(new File("Example.png")));

    }

}
