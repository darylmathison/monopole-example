/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ship;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import chamber.Chamber;

/**
 *
 * @author Daryl Mathison
 */
public class MaxChamberShip extends AbstractShip {

    @Override
    public void addMonopole(int monopole) {
        List<Chamber> eligibleChambers = new ArrayList<Chamber>(chambers.size());
        int maxLen = -1;
        Chamber selectedChamber = null;
        
        for(Chamber c: chambers) {
            if(c.canAddMonopole(monopole)) {
                eligibleChambers.add(c);
            }
        }
        
        for(Chamber c: eligibleChambers) {
            if(maxLen < c.numMonopoles()){
                maxLen = c.numMonopoles();
                selectedChamber = c;
            }
        }
        selectedChamber.addMonopole(monopole);
    }
    
}
