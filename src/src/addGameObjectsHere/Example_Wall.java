package addGameObjectsHere;

import addResourceLoaderHere.ImageLoader;
import jGameFramework.core.Game;
import jGameFramework.coreActions.GameEvent;
import jGameFramework.display.Displayable;
import jGameFramework.display.DisplayableDepth;
import jGameFramework.display.DisplayableShapeOutline;
import jGameFramework.physicalObjects.BoundingArea;
import jGameFramework.physicalObjects.Position;
import jGameFramework.physicalObjects.PhysicalObject;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * An jGameFramework.example of a simple PhysicalObject
 *
 * @author Jérémie Beaudoin-Dion
 */
public class Example_Wall extends PhysicalObject {

    private Color color = Color.WHITE;

    /**
     * Constructor
     */
    public Example_Wall() {
        super(new BoundingArea(getShapes()), true, new DisplayableDepth(DisplayableDepth.MIDDLE-1));
    }

    private static List<Shape> getShapes(){
        List<Shape> allShapes = new LinkedList<>();

        int baseX = Game.WINDOW_WIDTH - Game.WINDOW_WIDTH/4;
        int baseY = Game.WINDOW_HEIGHT/10;

        allShapes.add(new Ellipse2D.Float(baseX, baseY, 100, 100));
        allShapes.add(new Rectangle2D.Float(baseX + 40, baseY+ 100, 20, 300));
        allShapes.add(new Ellipse2D.Float(baseX, baseY + 400, 100, 100));

        return allShapes;
    }

    /**
     * This PhysicalObject is DEPENDENT from the position of the Camera.
     * It will move according to it.
     */
    @Override
    public TreeSet<Displayable> getImageObjects(Position cameraPosition, ImageLoader imageLoader) {
        TreeSet<Displayable> screenRepresentation = new TreeSet<>();

        screenRepresentation.add(new DisplayableShapeOutline(getDepth(),
                getAreaAccordingToCamera(cameraPosition), color));

        return screenRepresentation;
    }

    @Override
    public List<GameEvent> getAction() {
        return null;  // Never returns actions
    }

    @Override
    public boolean dispose() {
        return false;
    }

    @Override
    public void resize(Position lastScreenSize, Position newScreenSize) {
        // do nothing
    }

}
