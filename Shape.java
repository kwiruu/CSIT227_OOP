// Add Comparable and Comparator interface implementation here

import java.util.Comparator;

public abstract class Shape implements Comparable<Shape>, Comparator<Shape> {
    String color;

    public Shape(String color) {
        this.color = color;
    }

    @Override
    public int compareTo(Shape o) {

        return 0;
    }

    @Override
    public int compare(Shape o1, Shape o2) {
        //Shape is smaller
        return 0;
    }

    @Override
    public String toString() {
        return "A shape that is color " + color;
    }

    public abstract double area();
    public abstract double perimeter();

    public static class ShapeColorComparator implements Comparator<Shape> {
        @Override
        public int compare(Shape o1, Shape o2) {
            return String.CASE_INSENSITIVE_ORDER.compare(o1.color, o2.color);
        }
    }
    public static class ShapeAreaComparator implements Comparator<Shape> {
        @Override
        public int compare(Shape o1, Shape o2) {
            double x = o2.area() - o1.area();
            if (x < 0){
                x = -1;
            }
            Math.ceil(x);
            return (int) x;
        }
    }
    public static class ShapePerimeterComparator implements Comparator<Shape> {
        @Override
        public int compare(Shape o1, Shape o2) {
            double x = o2.perimeter() - o1.perimeter();
            if (x < 0){
                x = -1;
            }
            Math.ceil(x);
            return (int) x;
        }
    }
}