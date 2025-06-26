package org.homework;

public class IntersectionTwoLines {
    public static class Point {
        double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Point other)) return false;
            return Double.compare(this.x, other.x) == 0 && Double.compare(this.y, other.y) == 0;
        }
    }

    public String calculateIntersection(Point p1, Point p2, Point p3, Point p4) {
        double m1 = (p2.y - p1.y)/(p2.x - p1.x);
        double m2 = (p4.y - p3.y)/(p4.x - p3.x);

        if (Double.compare(m1, m2) == 0) {
            double b1 = p1.y - p1.x * m1;
            double b2 = p3.y - p3.x * m2;

            if (Double.compare(b1, b2) == 0) {
                return "infinite";
            } else {
                return "none";
            }
        } else {
            return "single";
        }
    }
}
