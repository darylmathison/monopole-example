/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monopole;

import chamber.Chamber;
import ship.Ship;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 *
 * @author Daryl Mathison
 */
public class Monopole {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext cxt = 
                new GenericXmlApplicationContext("classpath:swing/monopole.xml");
        
        Ship maxShip = cxt.getBean("maxChamberShip", Ship.class);
        Ship firstShip = cxt.getBean("firstChamberShip", Ship.class);
        Ship minShip = cxt.getBean("minChamberShip", Ship.class);
        
        run(firstShip, cxt);
        run(maxShip, cxt);
        run(minShip, cxt);

    }
    
    public static void run(Ship ship, ApplicationContext cxt) {
        int numOfMono = 0;
        Chamber chamber = cxt.getBean("chamber", Chamber.class);
        ship.addChamber(chamber);
        
        while (numOfMono < 52 && ship.getNumChambers() < 52){
            for(int i = 1; i <= 52; i++) {
                if (ship.canAddMonopole(i)){
                    numOfMono++;
                    ship.addMonopole(i);
                } else {
                    numOfMono = 0;
                    chamber = cxt.getBean("chamber", Chamber.class);
                    ship.addChamber(chamber);
                    ship.reset();
                    break;
                }
            }
        }
        System.out.println("largest num " + numOfMono + " with " 
                            + ship.getNumChambers() + " chambers");
        System.out.println(ship);

    }
}
