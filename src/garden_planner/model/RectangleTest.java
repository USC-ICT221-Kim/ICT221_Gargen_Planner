package garden_planner.model;
/**
 * Rectangle Class
 */
import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @org.junit.jupiter.api.Test
    void getWidth() {
    }

    @org.junit.jupiter.api.Test
    void getHeight() {
    }

    @org.junit.jupiter.api.Test
    void getArea() {
        Rectangle rect = new Rectangle();
        assertEquals(1.0,rect.getWidth(), 1e-6);
        assertEquals(1.0, rect.getHeight(), 1e-6);
        assertEquals(0.0, rect.getTop(),1e-6);
        assertEquals(0.0, rect.getLeft(),1e-6);
        assertEquals(1.0, rect.getArea(),1e-6);
        assertEquals(4.0, rect.getPerimeter(),1e-6);

    }

    @org.junit.jupiter.api.Test
    void getPerimeter() {

    }
}