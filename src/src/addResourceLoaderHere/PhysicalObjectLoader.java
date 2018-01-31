package addResourceLoaderHere;

import addGameObjectsHere.*;
import addGameObjectsHere.camera.CameraFollowingPlayer;
import addGameObjectsHere.camera.CameraStill;
import jGameFramework.core.Loader;
import jGameFramework.physicalObjects.Camera;
import jGameFramework.physicalObjects.PhysicalObject;

import java.util.TreeSet;

/**
 * Loads all game objects to create GameThreads.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class PhysicalObjectLoader implements Loader<TreeSet<PhysicalObject>> {

    private Player player;
    private ImageLoader imageLoader;

    public PhysicalObjectLoader(ImageLoader imageLoader){
        this.imageLoader = imageLoader;
        player = new Player();
    }

    public TreeSet<PhysicalObject> get(GameThreadID gameThreadID){
        switch (gameThreadID){
            case Menu:
                return getStartGameObjects();

            case Level1:
                return getLevel1GameObjects();
        }

        throw new IllegalArgumentException("The GameThreadID: " + gameThreadID + " is not implemented.");
    }

    private TreeSet<PhysicalObject> getLevel1GameObjects() {
        TreeSet<PhysicalObject> objects = new TreeSet<>();

        objects.add(new Example_Image(imageLoader.getImageExample()));

        objects.add(new Example_Wall());

        getPlayerObject().reset();
        objects.add(getPlayerObject());

        objects.add(new Example_Trap());

        return objects;
    }

    private TreeSet<PhysicalObject> getStartGameObjects() {
        TreeSet<PhysicalObject> objects = new TreeSet<>();

        objects.add(new Example_Button());

        return objects;
    }

    public Camera getCamera(GameThreadID gameThreadID){
        switch (gameThreadID){
            case Menu:
                return new CameraStill();

            case Level1:
                return new CameraFollowingPlayer(getPlayerObject());
        }

        throw new IllegalArgumentException("The GameThreadID: " + gameThreadID + " is not implemented.");
    }

    /**
     * Player object
     */
    private Player getPlayerObject(){
        return player;
    }

}
