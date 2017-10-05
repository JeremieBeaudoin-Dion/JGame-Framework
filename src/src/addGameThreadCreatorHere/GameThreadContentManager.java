package addGameThreadCreatorHere;

import addGameObjectsHere.Example_Button;
import addGameObjectsHere.Example_Circle;
import addGameObjectsHere.Example_Image;
import addGameObjectsHere.Player;
import addImagesHere.ImageLoader;
import core.Game;
import images.Dimension;
import images.Position;
import physicalObjects.*;

import java.util.TreeSet;

/**
 * Returns the desired objects when creating a new Thread
 *
 * @author Jérémie Beaudoin-Dion
 */
class GameThreadContentManager {

    private static final Position PLAYER_START_POSITION = new Position(Game.WINDOW_WIDTH/2, Game.WINDOW_HEIGHT/2);
    private static final Position PLAYER_LEVEL1_POSITION = new Position(0, 0);

    private ImageLoader imageLoader;

    GameThreadContentManager(ImageLoader imageLoader) {
        this.imageLoader = imageLoader;
    }

    /**
     * Basic player starts at position (0,0)
     */
    private Player getPlayerObject(){
        return new Player(new Dimension(0, 0, 10,10), new VisionCircle(50),
                new VelocitySquare(2,2));
    }

    /**
     * Objects used for the StartGame() thread
     */
    TreeSet<PhysicalObject> getStartGameObjects() {
        TreeSet<PhysicalObject> objects = new TreeSet<>();

        objects.add(new Example_Button());

        return objects;
    }

    Player getStartPlayerObject(){

        Player player = getPlayerObject();

        player.getDimension().setPosition(PLAYER_START_POSITION.clone());

        return player;
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

    Player getLevel1PlayerObject(){

        Player player = getPlayerObject();

        player.getDimension().setPosition(new Position(Game.WINDOW_WIDTH/2, Game.WINDOW_HEIGHT/2));

        return player;

    }

}
