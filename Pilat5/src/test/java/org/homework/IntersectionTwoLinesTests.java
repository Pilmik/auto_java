package org.homework;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class IntersectionTwoLinesTests {

    private IntersectionTwoLines calculator;

    @BeforeEach
    void setUp() {
        calculator = new IntersectionTwoLines();
    }

    @Test
    @Tag("single")
    @DisplayName("Single point intersection")
    void singlePointIntersection() {
        IntersectionTwoLines.Point p1 = new IntersectionTwoLines.Point(0, 0);
        IntersectionTwoLines.Point p2 = new IntersectionTwoLines.Point(1, 1);
        IntersectionTwoLines.Point p3 = new IntersectionTwoLines.Point(0, 1);
        IntersectionTwoLines.Point p4 = new IntersectionTwoLines.Point(1, 0);
        assumeTrue(!p1.equals(p2) && !p3.equals(p4), "Incorrect points");
        assertEquals("single", calculator.calculateIntersection(p1, p2, p3, p4));
    }

    @ParameterizedTest
    @Tag("single")
    @CsvSource({"0, 0, 1, 1, 0, 1, 1, 0",
            "1, 1, 1, 1, 0, 0, 2, 2",
            "-1, -1, 2, 2, 0, 2, 2, 0"})
    void singlePointIntersectionParameterized(double x1, double y1, double x2, double y2,
                                              double x3, double y3, double x4, double y4) {
        IntersectionTwoLines.Point p1 = new IntersectionTwoLines.Point(x1, y1);
        IntersectionTwoLines.Point p2 = new IntersectionTwoLines.Point(x2, y2);
        IntersectionTwoLines.Point p3 = new IntersectionTwoLines.Point(x3, y3);
        IntersectionTwoLines.Point p4 = new IntersectionTwoLines.Point(x4, y4);
        assumeTrue(!p1.equals(p2) && !p3.equals(p4), "Incorrect points");
        assertEquals("single", calculator.calculateIntersection(p1, p2, p3, p4));
    }

    @Test
    @Tag("none")
    @DisplayName("None point intersection")
    void nonePointIntersection() {
        IntersectionTwoLines.Point p1 = new IntersectionTwoLines.Point(0, 0);
        IntersectionTwoLines.Point p2 = new IntersectionTwoLines.Point(1, 1);
        IntersectionTwoLines.Point p3 = new IntersectionTwoLines.Point(1, 0);
        IntersectionTwoLines.Point p4 = new IntersectionTwoLines.Point(2, 1);
        assumeTrue(!p1.equals(p2) && !p3.equals(p4), "Incorrect points");
        assertEquals("none", calculator.calculateIntersection(p1, p2, p3, p4));
    }

    @ParameterizedTest
    @Tag("none")
    @CsvSource({
            "0, 0, 1, 1, 0, 2, 1, 3",
            "1, 1, 2, 2, 1, 3, 2, 4",
            "2, 2, 2, 2, 0, 1, 2, 5"
    })
    void nonePointIntersectionParameterized(double x1, double y1, double x2, double y2,
                                              double x3, double y3, double x4, double y4) {
        IntersectionTwoLines.Point p1 = new IntersectionTwoLines.Point(x1, y1);
        IntersectionTwoLines.Point p2 = new IntersectionTwoLines.Point(x2, y2);
        IntersectionTwoLines.Point p3 = new IntersectionTwoLines.Point(x3, y3);
        IntersectionTwoLines.Point p4 = new IntersectionTwoLines.Point(x4, y4);
        assumeTrue(!p1.equals(p2) && !p3.equals(p4), "Incorrect points");
        assertEquals("none", calculator.calculateIntersection(p1, p2, p3, p4));
    }

    @Test
    @Tag("infinite")
    @DisplayName("Infinite point intersection")
    void infinitePointIntersection() {
        IntersectionTwoLines.Point p1 = new IntersectionTwoLines.Point(0, 0);
        IntersectionTwoLines.Point p2 = new IntersectionTwoLines.Point(1, 1);
        IntersectionTwoLines.Point p3 = new IntersectionTwoLines.Point(2, 2);
        IntersectionTwoLines.Point p4 = new IntersectionTwoLines.Point(3, 3);
        assumeTrue(!p1.equals(p2) && !p3.equals(p4), "Incorrect points");
        assertEquals("infinite", calculator.calculateIntersection(p1, p2, p3, p4));
    }

    @ParameterizedTest
    @Tag("infinite")
    @CsvSource({
            "1, 0, 1, 1, 3, 3, 3, 3",
            "0, 1, 1, 3, 2, 5, 3, 7",
            "0, 2, 1, 1, 2, 0, -1, 3"
    })
    void infinitePointIntersectionParameterized(double x1, double y1, double x2, double y2,
                                            double x3, double y3, double x4, double y4) {
        IntersectionTwoLines.Point p1 = new IntersectionTwoLines.Point(x1, y1);
        IntersectionTwoLines.Point p2 = new IntersectionTwoLines.Point(x2, y2);
        IntersectionTwoLines.Point p3 = new IntersectionTwoLines.Point(x3, y3);
        IntersectionTwoLines.Point p4 = new IntersectionTwoLines.Point(x4, y4);
        assumeTrue(!p1.equals(p2) && !p3.equals(p4), "Incorrect points");
        assertEquals("infinite", calculator.calculateIntersection(p1, p2, p3, p4));
    }
}
