/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ship;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

/**
 *
 * @author Daryl Mathison
 */
public class ShipFactory implements FactoryBean<Ship>, InitializingBean{
    private Ship ship;
    private ShipType shipType = ShipType.FIRSTCOME;

    @Override
    public Ship getObject() throws Exception {
        return ship;
    }

    @Override
    public Class<?> getObjectType() {
        return Ship.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if(shipType == ShipType.FIRSTCOME){
            ship = new FirstChamberShip();
        } else if(shipType == ShipType.LARGEST){
            ship = new MaxChamberShip();
        } else if(shipType == ShipType.SMALLEST) {
            ship = new MinChamberShip();
        }
    }
    
    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }
}
