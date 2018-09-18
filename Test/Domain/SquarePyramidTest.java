package Domain;


import Domain.SquarePyramid;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquarePyramidTest {
    @Test
    public void calculateVolume() throws Exception {
        SquarePyramid squarePyramid = new SquarePyramid(3.0, 2.0);
        assertEquals(6.0, squarePyramid.calculateVolume(), 0.00001);

        squarePyramid.setLength(17.45);
        squarePyramid.setHeight(8.65);
        assertEquals(877.98221, squarePyramid.calculateVolume(), 0.00001);

        squarePyramid.setLength(0.78);
        squarePyramid.setHeight(0.25);
        assertEquals(0.0507, squarePyramid.calculateVolume(), 0.00001);
    }

}