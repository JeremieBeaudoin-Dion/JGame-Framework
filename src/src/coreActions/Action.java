package coreActions;

/**
 * An Action is an instance send by the InputHandler to the ActionHandler. It represents an input
 * from the user and will return an ActionEvent that will help the ActionHandler to easily
 * influence the game with that action.
 *
 * @author Jérémie Beaudoin-Dion
 */
public interface Action {

    boolean isDoable();

    ActionEvent doAction() throws NoSuchMethodException;

}
