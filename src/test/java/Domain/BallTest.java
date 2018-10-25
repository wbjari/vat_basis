package Domain;

import Domain.Ball;
import org.junit.Test;

import static org.junit.Assert.*;

public class BallTest {
    @Test
    public void calculateVolume() throws Exception {
        Ball ball = new Ball(7.0);
        assertEquals(179.59438003, ball.calculateVolume(), 0.00001);
    }

}