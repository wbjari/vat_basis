package Domain;

import Domain.Sphere;
import org.junit.Test;

import static org.junit.Assert.*;

public class SphereTest {
    @Test
    public void calculateVolume() throws Exception {
        Sphere sphere = new Sphere(5.0);
        assertEquals(523.59877, sphere.calculateVolume(), 0.00001);

        sphere.setRadius(13.25);
        assertEquals( 9743.9768643435, sphere.calculateVolume(), 0.00000001);

        sphere.setRadius(25.6384);
        assertEquals(70592.955717374, sphere.calculateVolume(), 0.000000001);
    }

}