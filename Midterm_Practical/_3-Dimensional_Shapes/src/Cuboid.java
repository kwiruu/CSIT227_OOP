public class Cuboid extends Solid {
    double height;
    double base;
    double length;

    @Override
    public String toString(){
        return super.toString() + " which is a Cuboid";
    }

    public Cuboid(double height, double base, double length) {
        this.height = height;
        this.base = base;
        this.length = length;
    }

    public Cuboid(int x, int y, double height, double base, double length) {
        super(x,y);
        this.height = height;
        this.base = base;
        this.length = length;
    }

    @Override
    public double volume(){
        return length*base*height;
    }

    @Override
    public double surfaceArea() {
        return 2*((length*base)+(base*height)+(length*height));
    }

    public static class Cube extends Cuboid{
        @Override
        public String toString(){
            return super.toString() + " which is also a Cube";
        }
        public Cube(int x, int y, double height, double base, double length) {
            super(x, y, height, base, length);
        }

        public Cube(double height, double base, double length) {
            super(height, base, length);
        }


    }


}
