package physicalObjects;

import display.Position;

import java.awt.geom.RectangularShape;

/**
 * @author Jérémie Beaudoin-Dion
 */
public abstract class BoundingShape {

    private RectangularShape shape;

    public BoundingShape(RectangularShape shape){

    }

    public int getX(){
        return (int) shape.getX();
    }

    public int getY(){
        return (int) shape.getY();
    }

    public Position getPosition(){
        return new Position((int) shape.getX(), (int) shape.getY());
    }

}
