package addGameObjectsHere;

import addResourceLoaderHere.ImageLoader;
import jGameFramework.coreActions.GameEvent;
import jGameFramework.display.Displayable;
import jGameFramework.display.DisplayableDepth;
import jGameFramework.display.DisplayableShapeFilled;
import jGameFramework.display.DisplayableShapeOutline;
import jGameFramework.physicalObjects.*;

import java.awt.*;
import java.util.List;
import java.util.TreeSet;

/**
 * @author Jérémie Beaudoin-Dion
 */
public class Example_Trap extends PhysicalObjectUpdating {

    private static int width = 50;
    private static int height = 50;

    private static Color color = Color.RED;

    // Creating a daskedStroke
    private final static float dashWidth[] = {10.0f};
    private final static BasicStroke dashedStroke = new BasicStroke(1.0f,
                                                            BasicStroke.CAP_BUTT,
                                                            BasicStroke.JOIN_MITER,
                                                            10.0f, dashWidth, 0.0f);

    private double time_before_active;
    private static double MAX_TIME = 100;
    private boolean active;

    /**
     * Constructor
     */
    public Example_Trap() {
        super(new BoundingArea(600, 200, width, height), false, new VisionRectangle(width, height),
                new DisplayableDepth(DisplayableDepth.MIDDLE));
        active = false;
    }

    @Override
    public TreeSet<PhysicalObject> update(TreeSet<PhysicalObject> surroundings) {
        // Using the delta value to ensure stable interactions according to FPS
        time_before_active -= 1 * this.deltaValue;

        changeActiveState();

        if (active) {
            destroyAllObjectsCollidingWithThisOne(surroundings);
        }

        return null;
    }

    private void changeActiveState() {

        if (time_before_active <= 0) {
            active = !active;
            time_before_active = MAX_TIME;
        }

    }

    private void destroyAllObjectsCollidingWithThisOne(TreeSet<PhysicalObject> surroundings) {
        for (PhysicalObject object: surroundings) {
            if (object instanceof Player && isColliding(object)) {
                ((Player) object).kill();
            }
        }
    }

    @Override
    public TreeSet<Displayable> getImageObjects(Position cameraPosition, ImageLoader imageLoader) {
        TreeSet<Displayable> screenRepresentation = new TreeSet<>();

        if (active) {
            screenRepresentation.add(new DisplayableShapeFilled(getDepth(),
                    getAreaAccordingToCamera(cameraPosition), color));
        } else {
            screenRepresentation.add(new DisplayableShapeOutline(getDepth(),
                    getAreaAccordingToCamera(cameraPosition), color, dashedStroke));
        }

        return screenRepresentation;
    }

    @Override
    public List<GameEvent> getAction() {
        return null;
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
