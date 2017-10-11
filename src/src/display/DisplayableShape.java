package display;

import java.awt.*;

/**
 * A shape that can be displayed on screen. It has a colour
 * and a java.awt shape.
 *
 * @author Jérémie Beaudoin-Dion
 */
public abstract class DisplayableShape extends Displayable {

    private Shape shape;
    private Paint paint;

    /**
     * Constructors
     */
    public DisplayableShape(Depth depth, Shape shape, Paint paint) {
        super(depth);
        this.shape = shape;
        this.paint = paint;
    }

    public Shape getShape(){
        return shape;
    }

    public Paint getPaint(){
        return paint;
    }
}
