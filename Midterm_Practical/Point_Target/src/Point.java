import java.util.Comparator;

public class Point implements Comparable<Point> {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public int compareTo(Point other) {
        if (this.y != other.y) {
            return Integer.compare(other.y, this.y);
        } else {
            return Integer.compare(this.x, other.x);
        }

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }



    public static class NearestComparator implements Comparator<Point> {
        private Point target;
        public NearestComparator (Point target) {
            this.target = target;
        }
        @Override
        public int compare(Point o1, Point o2) {
            double distance1 = Math.sqrt(Math.pow(o1.getX() - target.getX(), 2) + Math.pow(o1.getY() - target.getY(), 2));
            double distance2 = Math.sqrt(Math.pow(o2.getX() - target.getX(), 2) + Math.pow(o2.getY() - target.getY(), 2));
            return Double.compare(distance1, distance2);
        }
    }


}