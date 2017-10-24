package jGameFramework.exceptions;

/**
 * A RuntimeException thrown when get(String key) is called on
 * a KeyMap that doesn't contains the desired key.
 *
 * The Java hashMap returns null if the key is not in the Map and
 * this helps avoid nullPointerExceptions and simplifies greatly
 * the code.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class UnimplementedKeyException extends RuntimeException {

    public UnimplementedKeyException(String message){
        super(message);
    }

}
