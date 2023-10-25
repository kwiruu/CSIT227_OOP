public class Sphere extends Solid {
    double diameter;

    public Sphere(double diameter) {
        this.diameter = diameter;
    }

    public Sphere(int x, int y, double diameter){
        super(x,y);
        this.diameter = diameter;
    }

    @Override
    public String toString(){
        return super.toString()+" which is a Sphere";
    }

    @Override
    public double surfaceArea() {
        return 4 * Math.PI * ((diameter/2) * (diameter/2));
    }

    @Override
    public double volume() {
        return (4.0/3) * Math.PI * ((diameter/2) * (diameter/2) * (diameter/2));
    }

    public static class Hemisphere extends Sphere{

        public Hemisphere(double diameter) {
            super(diameter);
        }

        public Hemisphere(int x, int y, double diameter){
            super(x,y,diameter);
        }

        @Override
        public String toString(){
            return super.toString() + " but only half of it";
        }

        @Override
        public double surfaceArea() {
            return 3 * Math.PI * ((diameter/2) * (diameter/2));
        }

        @Override
        public double volume() {
            return (2.0/3) * Math.PI * ((diameter/2) * (diameter/2) * (diameter/2));
        }

    }
}
