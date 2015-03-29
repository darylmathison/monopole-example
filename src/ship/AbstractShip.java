/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ship;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import chamber.Chamber;

/**
 *
 * @author Daryl Mathison
 */
abstract class AbstractShip implements Ship {
    protected List<Chamber> chambers = new ArrayList<Chamber>();

    public void addChamber(Chamber chamber) {
        if (chamber == null) {
            throw new NullPointerException("chamber is null");
        }
        chambers.add(chamber);
    }

    @Override
    public abstract void addMonopole(int monopole);

    @Override
    public boolean canAddMonopole(int monopole) {
        boolean canAdd = false;
        for (Chamber c : chambers) {
            if (c.canAddMonopole(monopole)) {
                canAdd = true;
                break;
            }
        }
        return canAdd;
    }

    @Override
    public List<Chamber> getChambers() {
        return Collections.unmodifiableList(chambers);
    }

    @Override
    public int getNumChambers() {
        return chambers.size();
    }

    @Override
    public void reset() {
        for (Chamber c : chambers) {
            c.clear();
        }
    }

    @Override
    public String toString() {
        return "Ship{" + "chambers=" + chambers + '}';
    }
    
}
