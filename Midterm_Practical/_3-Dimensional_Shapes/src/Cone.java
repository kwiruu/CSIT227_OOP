public class Cone extends Solid {
    double diameter;
    double height;

    public Cone(double diameter, double height) {
        this.diameter = diameter;
        this.height = height;
    }
    public Cone(int x, int y, double diameter, double height) {
        super(x,y);
        this.diameter = diameter;
        this.height = height;
    }

    @Override
    public String toString(){
        return super.toString()+" which is a Cone";
    }

    @Override
    public double surfaceArea() {
        return Math.PI * (diameter/2) * (Math.sqrt(((diameter/2)*(diameter/2))+(height*height)) + (diameter/2));
    }

    @Override
    public double volume() {
        return (1.0/3) * Math.PI * ((diameter/2) * (diameter/2)) * height;
    }
}
