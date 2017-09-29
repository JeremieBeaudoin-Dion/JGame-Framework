package addGameThreadCreatorHere;

import addGameObjectsHere.Example_Button;
import addGameObjectsHere.Example_Circle;
import addGameObjectsHere.Example_Image;
import addImagesHere.ImageLoader;
import physicalObjects.PhysicalObject;

import java.util.TreeSet;

/**
 * Returns the desired objects when creating a new Thread
 *
 * @author Jérémie Beaudoin-Dion
 */
class GameThreadContentManager {

    private ImageLoader imageLoader;

    GameThreadContentManager(ImageLoader imageLoader) {
        this.imageLoader = imageLoader;
    }

    /**
     * Objects used for the StartGame() thread
     */
    TreeSet<PhysicalObject> getStartGameObjects() {
        TreeSet<PhysicalObject> objects = new TreeSet<>();

        objects.add(new Example_Button());

        return objects;
    }

    /**
     * Objects used for the Level_1 thread
     */
    TreeSet<PhysicalObject> getLevel1GameObjects() {
        TreeSet<PhysicalObject> objects = new TreeSet<>();

        objects.add(new Example_Image(imageLoader.getImageExample()));

        objects.add(new Example_Circle());

        return objects;
    }

}
