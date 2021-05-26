package fundamental;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PointTest {
    @Test
    public void testDistance() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);
        Assertions.assertEquals(p1.distance(p2), Math.sqrt(2));
    }
}
