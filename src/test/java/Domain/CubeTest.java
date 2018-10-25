package Domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class CubeTest {
    @Test
    public void calculateVolume() throws Exception {
        Cube cube = new Cube(5.0, 5.0, 5.0);
        assertEquals(125.0, cube.calculateVolume(), 0.00001);

        //cube.setLength(3.65);
        //cube.setWidth(3.65);
        //cube.setHeight(3.65);
        //assertEquals(48,627125, cube.calculateVolume(), 0.00001);

    }

}