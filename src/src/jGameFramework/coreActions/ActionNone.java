package jGameFramework.coreActions;

/**
 * A type of action that does nothing.
 *
 * This is useful to prevent the throwing of errors when doing actions
 * with keys that do nothing.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class ActionNone extends Action {

    public ActionNone() {
        super(null);
    }

    public boolean isDoable(){
        return false;
    }

    public GameEvent getAction(){
        return null;
    }

}
