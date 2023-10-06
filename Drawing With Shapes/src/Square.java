public class Square implements Shape {
    public int side;

    public Square(int side) {
        this.side = side;
    }

    public void draw() {
        for (int i = 1; i <= side; i++) {
            for (int j = 1; j <= side; j++) {
                System.out.print("` ");
            }
            System.out.println(); // Move to the next line after each row
        }
    }
}