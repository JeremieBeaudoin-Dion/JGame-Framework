package coreActions;

import core.Game;

/**
 * A specific ActionEvent that will exit the current GameThread
 *
 * @author Jérémie Beaudoin-Dion
 */
public class GameThreadEventQuit extends GameThreadEvent {

    public GameThreadEventQuit() throws NoSuchMethodException {
        super(Game.class, Game.class.getMethod("quitCurrentState"));
    }

}
