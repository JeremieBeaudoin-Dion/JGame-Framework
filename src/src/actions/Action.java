package actions;

/**
 * @author Jérémie Beaudoin-Dion
 */
public interface Action {

    boolean isDoable();

    ActionEvent doAction() throws NoSuchMethodException;

}
