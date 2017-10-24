package jGameFramework.collections;

import jGameFramework.exceptions.UnimplementedKeyException;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains a map of Images, Music or Actions that are stored
 * and bound to a String key.
 *
 * This class ensures that certain operations like map.clear()
 * are not done on these maps. Such operations would lead to
 * the game not working properly.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class ResourceKeyMap<K, O> {

    private Map<K, O> content;

    /**
     * Constructor
     */
    public ResourceKeyMap(Map<K, O> content){
        this.content = getMapIfNotNull(content);
    }

    private Map<K, O> getMapIfNotNull(Map<K, O> desiredMap){
        if (desiredMap != null){
            return desiredMap;
        } else {
            return new HashMap<>();
        }
    }

    /**
     * Returns the desired object bound to the key.
     *
     * This throws a UnimplementedKeyException instead of returning
     * null. This helps clean the code and if not caught, the
     * UnimplementedKeyException is more descriptive than the
     * NullPointerException.
     */
    public O get(K key){
        if (content.containsKey(key)){
            return content.get(key);
        }

        throw new UnimplementedKeyException("The key : " + key + " is not implemented in the ResourceMap.");
    }


}
