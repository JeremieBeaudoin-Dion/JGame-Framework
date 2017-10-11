package addGameObjectsHere.camera;

import physicalObjects.Dimension;
import display.Position;

/**
 * An object that belongs to the camera and helps put the
 * player object inside a sub-camera square.
 *
 * @author Jérémie Beaudoin-Dion
 */
class EdgesOfCamera {

    private Dimension dimension;

    /**
     * Constructor that sets the EdgesOfCamera as a rectangle
     * according to a Dimension
     */
    EdgesOfCamera(Dimension dimension){
        this.dimension = dimension;
    }

    void setPosition(Position position){
        this.dimension.setPosition(position);
    }

    Position addThisToCameraToKeepObjectInEdges(Dimension objectsDimension){

        int xValue = getXValueOfPositionToAdd(objectsDimension);
        int yValue = getYValueOfPositionToAdd(objectsDimension);

        return new Position(xValue, yValue);
    }

    private int getXValueOfPositionToAdd(Dimension objectsDimension){
        int xValue = 0;

        if (objectsDimension.getPosition().getX() < dimension.getPosition().getX()){
            xValue = objectsDimension.getPosition().getX() - dimension.getPosition().getX();

        } else if ((objectsDimension.getPosition().getX() + objectsDimension.getWidth()) >
                (dimension.getPosition().getX() + dimension.getWidth())){
            xValue = objectsDimension.getPosition().getX() + objectsDimension.getWidth() -
                    (dimension.getPosition().getX() + dimension.getWidth());
        }

        return xValue;
    }

    private int getYValueOfPositionToAdd(Dimension objectsDimension){
        int yValue = 0;

        if (objectsDimension.getPosition().getY() < dimension.getPosition().getY()){
            yValue = objectsDimension.getPosition().getY() - dimension.getPosition().getY();

        } else if ((objectsDimension.getPosition().getY() + objectsDimension.getHeight()) >
                (dimension.getPosition().getY() + dimension.getHeight())){
            yValue = objectsDimension.getPosition().getY() + objectsDimension.getHeight() -
                    (dimension.getPosition().getY() + dimension.getHeight());
        }

        return yValue;
    }

}
