package display;

import java.awt.*;

/**
 * A shape that can be put on screen. Only its outline will be
 * seen. To show a FilledShape, use DisplayableShapeFilled.
 *
 * The default stroke value is a solid outline.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class DisplayableShapeOutline extends DisplayableShape {

    private Stroke stroke;

    /**
     * Constructors for a solid BLACK outline
     */
    public DisplayableShapeOutline(Depth depth, Shape shape) {
        super(depth, shape, Color.BLACK);
        this.stroke = new BasicStroke();
    }

    /**
     * Constructors for a solid outline
     */
    public DisplayableShapeOutline(Depth depth, Shape shape, Paint paint) {
        super(depth, shape, paint);
        this.stroke = new BasicStroke();
    }

    /**
     * Constructor for a specific desired outline
     */
    public DisplayableShapeOutline(Depth depth, Shape shape, Paint paint, Stroke stroke){
        super(depth, shape, paint);
        this.stroke = stroke;
    }

    public Stroke getStroke(){
        return stroke;
    }

}
