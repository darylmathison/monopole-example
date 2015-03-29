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
public class FirstChamberShip extends AbstractShip {

    @Override
    public void addMonopole(int monopole) {
        if(canAddMonopole(monopole)) {
            for(Chamber c: chambers) {
               if(c.canAddMonopole(monopole)){
                   c.addMonopole(monopole);
                   break;
               }
            } 
        }
    }
}
