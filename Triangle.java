public class Triangle extends Shape {
    // TODO implement Triangle
    private double base;
    private double height;
    private double b;
    private double c;
    public Triangle(double base, double height, double b, double c, String color) {
        super(color);
        this.base = base;
        this.height = height;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        return .5*(base*height);
    }

    @Override
    public double perimeter() {
        return base+b+c;
    }

    @Override
    public String toString() {
        return super.toString() + " which is also a Triangle";
    }

    public static class EquilateralTriangle extends Triangle {
        //double side;
        // TODO implement EquilateralTriangle
        public EquilateralTriangle(double side, String color) {
            // TODO call super()
            super(side, (Math.sqrt(3)/2)*side, side, side, color);
        }

        @Override
        public String toString() {
            return super.toString() + " which is also an Equilateral Triangle";
        }
    }
}