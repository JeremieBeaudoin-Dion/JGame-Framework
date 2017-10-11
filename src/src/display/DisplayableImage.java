package display;

import java.awt.image.BufferedImage;

/**
 * Displays the desired image on screen
 *
 * @author Jérémie Beaudoin-Dion
 */
public class DisplayableImage extends Displayable {

    private BufferedImage image;

    /**
     * Constructors
     */
    public DisplayableImage(Depth depth, BufferedImage image) {
        super(depth);
        this.image = image;
    }

    // todo: change to image?
    public BufferedImage getImage(){
        return image;
    }
}
