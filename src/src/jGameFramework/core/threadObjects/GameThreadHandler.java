package jGameFramework.core.threadObjects;

import addResourceLoaderHere.*;
import jGameFramework.display.Displayable;
import jGameFramework.exceptions.EmptyThreadException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.*;
import java.util.Stack;
import java.util.TreeSet;

/**
 * The GameThreadHandler uses the ResourceLoaders to create and put
 * all current GameThreads in a Stack. Only one GameThread runs at
 * a time (the one on top of the stack) so when a game thread is added
 * to the stack, the others are paused until the game returns to that
 * thread.
 *
 * This class also handles saveGame() and loadGame(), storing the
 * current stack of GameThreads in a file or deSerializing it to
 * come back to the desired state.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class GameThreadHandler {

    // Threads
    private Stack<GameThread> allThreads;

    // Resource loaders
    private ImageLoader imageLoader;
    private ActionLoader actionLoader;
    private MusicLoader musicLoader;
    private SoundLoader soundLoader;
    private PhysicalObjectLoader physicalObjectLoader;

    /**
     * Constructor
     */
    public GameThreadHandler() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        loadResources();

        allThreads = new Stack<>();
        newGameState(GameInformation.START_GAME_ID);

    }

    private void loadResources() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        imageLoader = new ImageLoader();
        actionLoader = new ActionLoader();
        musicLoader = new MusicLoader();
        soundLoader = new SoundLoader();
        physicalObjectLoader = new PhysicalObjectLoader(imageLoader);
    }

    /**
     * Getter for the current thread's InputHandler
     *
     * This is used by the KeyHandler and MouseHandler to get
     * the proper coreAction.Action to do according to the input.
     */
    public InputHandler getCurrentInputHandler(){
        return allThreads.peek().getInputHandler();
    }

    /*
     * Basic methods called every frame
     */
    public void update(double deltaValue){
        allThreads.peek().update(deltaValue);
    }

    /**
     * Returns the images to display on screen according to the
     * current GameThread.
     */
    public TreeSet<Displayable> getImages(){
        return allThreads.peek().getImages(imageLoader);
    }

    /*
     * Plays music and sounds
     */
    public void playSound(String id){
        allThreads.peek().playSound(id);
    }

    public void playMusic(String id){
        allThreads.peek().playMusic(id);
    }

    public void stopMusic(String id){
        allThreads.peek().stopMusic(id);
    }

    /*
     * Change the current thread
     */
    /**
     * Pops the current thread. If the stack of threads is
     * empty, quits the game.
     */
    public void quitCurrentState() {
        if (!allThreads.isEmpty()) {
            allThreads.peek().clear();
            allThreads.pop();
        }

        if (allThreads.isEmpty()) {
            throw new EmptyThreadException();
        }
    }

    /**
     * Adds a new GameThread on top of current thread's stack
     */
    public void newGameState(GameThreadID gameThreadID) {
        allThreads.push(createGameThread(gameThreadID));
    }

    private GameThread createGameThread(GameThreadID gameThreadID){
        return new GameThread(this, gameThreadID, physicalObjectLoader.getCamera(gameThreadID),
                physicalObjectLoader.get(gameThreadID), actionLoader.get(gameThreadID),
                musicLoader.get(gameThreadID), soundLoader.get(gameThreadID));
    }

    /*
     * Save and load games
     */
    public void saveGame(String saveFilePath) {

        try {
            FileOutputStream fileOut = new FileOutputStream(saveFilePath);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(getSerial());

            out.close();
            fileOut.close();

        } catch (IOException i) {
            i.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    private Stack<GameThreadSerialized> getSerial() {
        Stack<GameThreadSerialized> serialThreads = new Stack<>();
        Stack<GameThread> copiedStack = (Stack<GameThread>) allThreads.clone();

        while (!copiedStack.isEmpty()) {
            serialThreads.push(copiedStack.pop().getSerial());
        }

        return serialThreads;
    }

    @SuppressWarnings("unchecked")
    public void loadGame(String saveFilePath) {
        try {
            FileInputStream file = new FileInputStream(saveFilePath);
            ObjectInputStream saved = new ObjectInputStream(file);

            deSerialize((Stack<GameThreadSerialized>) saved.readObject());

            saved.close();
            file.close();

        } catch (IOException | ClassNotFoundException e) {
            allThreads = new Stack<>();
            newGameState(GameInformation.START_GAME_ID);
            e.printStackTrace();
        }

    }

    private void deSerialize(Stack<GameThreadSerialized> serialThreads) {
        allThreads = new Stack<>();

        while (!serialThreads.isEmpty()) {
            allThreads.push(serialThreads.pop().getThread(this, actionLoader, musicLoader, soundLoader));
        }
    }

}
