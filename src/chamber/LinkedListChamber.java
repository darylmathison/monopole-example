/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chamber;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Daryl Mathison
 */
public class LinkedListChamber implements Chamber {
    private List<Integer> monopoles;
    private Set<Integer> monopoleTypeCache;
    
    public LinkedListChamber() {
        monopoles = new LinkedList<Integer>();
        monopoleTypeCache = new HashSet<Integer>();
    }

    @Override
    public void addMonopole(int monopole) {
        if(monopole < 1 || monopole > 52) {
            throw new IllegalArgumentException("the range for monopole is 1 to 52");
        }
        if(canAddMonopole(monopole)) {
            addToCache(monopole);
            monopoles.add(monopole);
        }
    }

    @Override
    public boolean canAddMonopole(int monopole) {
        return !monopoleTypeCache.contains(new Integer(monopole));
    }

    @Override
    public int numMonopoles() {
        return monopoles.size();
    }

    @Override
    public List<Integer> getMonopoles() {
        return Collections.unmodifiableList(monopoles);
    }

    @Override
    public void clear() {
        monopoles.clear();
        monopoleTypeCache.clear();
    }

    @Override
    public boolean isEmpty() {
        return monopoles.isEmpty();
    }

    @Override
    public String toString() {
        return "LinkedListChamberImpl{" + "monopoles=" + monopoles + "}";
    }
    
    private void addToCache(int monopole) {
        List<Integer> temp = new LinkedList<Integer>();
        for(int m: monopoles){
            temp.add(m + monopole);
        }
        
        monopoleTypeCache.addAll(temp);
    }
}
