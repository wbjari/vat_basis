package Domain;

import org.junit.Test;

import static org.junit.Assert.*;

//import Domain.Cylinder;

public class CylinderTest {
    @Test
    public void calculateVolume() throws Exception {
        Cylinder cylinder = new Cylinder(5.0, 6.0);
        assertEquals(471.23889, cylinder.calculateVolume(), 0.00001);

        cylinder.setRadius(5.88);
        cylinder.setHeight(2.37);
        assertEquals(257.42627, cylinder.calculateVolume(), 0.00001);

        cylinder.setRadius(17.6535);
        cylinder.setHeight(5.3645);
        assertEquals(5252.19408, cylinder.calculateVolume(), 0.00001);
    }

}
