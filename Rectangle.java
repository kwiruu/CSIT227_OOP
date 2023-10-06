public class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width, String color) {
        super(color);
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }

    @Override
    public String toString() {
        return super.toString() + " which is also a Rectangle";
    }

    public static class Square extends Rectangle {

        public Square(double side, String color) {
            // TODO call super()
            super(side, side, color);
        }
        @Override
        public String toString() {
            return super.toString() + " which is also a Square";
        }
    }
}