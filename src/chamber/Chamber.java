/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chamber;

import java.util.List;

/**
 *
 * @author Daryl Mathison
 */
public interface Chamber {
    public void addMonopole(int monopole);
    public boolean canAddMonopole(int monopole);
    public int numMonopoles();
    public List<Integer> getMonopoles();
    public void clear();
    public boolean isEmpty();
    public String toString();
}
