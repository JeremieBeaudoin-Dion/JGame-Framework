package jGameFramework.core;

import java.util.LinkedList;
import java.util.List;

/**
 * An object which takes care of Object's IDs. This is useful
 * when creating multiple identical objects and wanting to keep
 * track of how many of these objects are still in use.
 *
 * @author Jérémie Beaudoin-Dion
 */
class ObjectIdCounter {

    private List<Integer> ids;

    ObjectIdCounter(){
        ids = new LinkedList<>();
    }

    int next(){
        int i = 0;

        while(ids.contains(i)){
            i++;
        }

        ids.add(i);

        return i;
    }

    void remove(Integer value){
        ids.remove(value);
    }

    int size(){
        return ids.size();
    }

}
