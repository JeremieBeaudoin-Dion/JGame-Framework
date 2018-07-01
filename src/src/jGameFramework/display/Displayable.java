package jGameFramework.display;

import jGameFramework.core.ObjectWithID;
import jGameFramework.physicalObjects.BoundingArea;
import jGameFramework.physicalObjects.Position;

import java.awt.*;

/**
 * Displayables are objects which can be displayed on screen using the ImageHandler.
 *
 * Their Depth represent the order in which the Displayables will be put on the screen.
 *
 * @author Jérémie Beaudoin-Dion
 */
public abstract class Displayable extends ObjectWithID {

    private DisplayableDepth depth;
    private Position position;
    private Position widthAndHeight;

    /**
     * Constructors
     */
    public Displayable(Position position, Position widthAndHeight, DisplayableDepth depth) {
        this.depth = depth;
        this.position = position;
        this.widthAndHeight = widthAndHeight;
    }

    public Position getPosition(){
        return position;
    }

    /**
     * Displayables are first compared with their depth values. The bigger the depth, the higher the image.
     *
     * If the depth values are the same, the positions are compared. The bigger the y value, the higher the image.
     * If the ys are the same, the bigger the x value, the higher the image.
     *
     * If their position are the same, the smaller width and height are considered higher.
     */
    @Override
    public int compareTo(ObjectWithID objectWithID) {
        if (!(objectWithID instanceof Displayable)){
            return super.compareTo(objectWithID);
        }

        Displayable other = (Displayable) objectWithID;

        if (depth.equals(other.depth)) {
            if (position.equals(other.getPosition())){
                return -widthAndHeight.compareTo(other.widthAndHeight);
            }

            return position.compareTo(other.getPosition());
        }

        return depth.compareTo(other.depth);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Displayable)){
            return super.equals(other);
        }

        Displayable displayable = (Displayable) other;

        return position.equals(displayable.getPosition()) && depth.equals(displayable.depth) &&
                widthAndHeight.equals(displayable.widthAndHeight);
    }


    public static void main(String[] args) {
        System.out.println("Test equal: " + testEqual());

        System.out.println("Test compare: " + testCompare());
    }

    private static boolean testEqual() {
        Displayable disp1 = new DisplayableShapeFilled(DisplayableDepth.HIGHEST,
                new BoundingArea(150, 150, 100, 100), Color.RED);

        Displayable disp2 = new DisplayableShapeFilled(DisplayableDepth.HIGHEST,
                new BoundingArea(150, 100, 100, 100), Color.RED);

        Displayable disp3 = new DisplayableShapeFilled(DisplayableDepth.HIGHEST,
                new BoundingArea(150, 150, 100, 100), Color.BLUE);

        Displayable disp4 = new DisplayableShapeFilled(DisplayableDepth.HIGHEST,
                new BoundingArea(150, 150, 100, 200), Color.BLUE);

        return !(disp1.equals(disp2)) && disp1.equals(disp3) && !(disp1.equals(disp4));
    }

    private static boolean testCompare() {
        Displayable disp1 = new DisplayableShapeFilled(DisplayableDepth.HIGHEST,
                new BoundingArea(150, 150, 100, 100), Color.RED);

        Displayable disp2 = new DisplayableShapeFilled(DisplayableDepth.HIGHEST,
                new BoundingArea(150, 100, 100, 100), Color.RED);

        Displayable disp3 = new DisplayableShapeFilled(DisplayableDepth.HIGHEST,
                new BoundingArea(150, 150, 100, 100), Color.BLUE);

        Displayable disp4 = new DisplayableShapeFilled(DisplayableDepth.HIGHEST,
                new BoundingArea(150, 150, 100, 200), Color.BLUE);

        return disp1.compareTo(disp3) == 0 && disp1.compareTo(disp2) > 0 && disp1.compareTo(disp4) < 0;
    }

}
