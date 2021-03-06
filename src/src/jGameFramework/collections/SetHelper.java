package jGameFramework.collections;

import java.util.Set;
import java.util.TreeSet;

/**
 * Helper method for methods used frequently.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class SetHelper {

    @SuppressWarnings("unchecked")
    public static void addAllIfNotNull(Set desiredSet, Set setToAdd){
        if (setToAdd != null && !setToAdd.isEmpty()){
            desiredSet.addAll(setToAdd);
        }
    }

    public static <E extends Comparable> Set<E> getSetFromObject(E object) {
        Set<E> set = new TreeSet<>();

        set.add(object);

        return set;
    }

}
