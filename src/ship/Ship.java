/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ship;

import java.util.List;
import chamber.Chamber;

/**
 *
 * @author Daryl Mathison
 */
public interface Ship {
    public void addMonopole(int monopole);
    public boolean canAddMonopole(int monopole);
    public void addChamber(Chamber chamber);
    public List<Chamber> getChambers();
    public int getNumChambers();
    public void reset();
    public String toString();
}
