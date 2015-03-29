/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ship;

import chamber.Chamber;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daryl Mathison
 */
public class MinChamberShip extends AbstractShip {

    @Override
    public void addMonopole(int monopole) {
        List<Chamber> eligibleChambers = new ArrayList<Chamber>(chambers.size());
        int minLen = 1000;
        Chamber selectedChamber = null;
        
        for(Chamber c: chambers) {
            if(c.canAddMonopole(monopole)) {
                eligibleChambers.add(c);
            }
        }
        
        for(Chamber c: eligibleChambers) {
            if(minLen > c.numMonopoles()){
                minLen = c.numMonopoles();
                selectedChamber = c;
            }
        }
        selectedChamber.addMonopole(monopole);
    }
    
}
