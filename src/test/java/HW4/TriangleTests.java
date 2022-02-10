package HW4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTests {
    private static Logger logger = LoggerFactory.getLogger(TriangleTests.class);

    @BeforeEach
    void logging() {
        logger.error("Log error");
        logger.trace("Log trace");
    }


    @Test
    @DisplayName("Проверка площади позитивный")
    void checkAreaPositive() throws Exception {
        assertEquals(2.8, TriangleTest.triangleArea(2, 3, 3), 0.1);
        assertEquals(12.0, TriangleTest.triangleArea(8, 5, 5), 0.1);
        assertEquals(62.4, TriangleTest.triangleArea(12, 12, 12), 0.1);
        assertEquals(52.2, TriangleTest.triangleArea(9, 13, 12), 0.1);
    }

    @Test
    @DisplayName("Проверка площади негативный")
    void checkAreaNegative() {
        assertThrows(Exception.class, () -> TriangleTest.triangleArea(-12, 12, 12));
        assertThrows(Exception.class, () -> TriangleTest.triangleArea(0, 12, 12));
        assertThrows(Exception.class, () -> TriangleTest.triangleArea(10, -10, 10));
        assertThrows(Exception.class, () -> TriangleTest.triangleArea(10, 0, 10));
        assertThrows(Exception.class, () -> TriangleTest.triangleArea(5, 8, -7));
        assertThrows(Exception.class, () -> TriangleTest.triangleArea(5, 8, 0));
        assertThrows(Exception.class, () -> TriangleTest.triangleArea(1, 1, 10));

    }

}