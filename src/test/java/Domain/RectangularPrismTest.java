package Domain;


import org.junit.Test;

import static org.junit.Assert.*;

public class RectangularPrismTest {
    @Test
    public void calculateVolume() throws Exception {
        RectangularPrism rectangularPrism = new RectangularPrism(3.0, 4.0, 5.0);
        assertEquals(60.0, rectangularPrism.calculateVolume(), 0.00001);

        //rectangularPrism.setLength(6.54);
        //rectangularPrism.setWidth(8.69);
        //rectangularPrism.setHeight(5.36);
        //assertEquals(304.62273, rectangularPrism.calculateVolume(), 0.00001);

        //rectangularPrism.setLength(12.79);
        //rectangularPrism.setWidth(16.93);
        //rectangularPrism.setHeight(3.45);
        //assertEquals(747.04471, rectangularPrism.calculateVolume(), 0.00001);
    }

}