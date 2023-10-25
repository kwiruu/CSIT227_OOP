public abstract class Solid {
    int x;
    int y;

    public Solid() {
        this.x = 50;
        this.y = 50;
    }

    public Solid(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "A solid at ("+x+", "+y+")";
    }

    public abstract double surfaceArea();
    public abstract double volume();

}
