public class Triangle implements Shape{
    public int height;

    public Triangle(int height) {
        this.height = height;
    }

    @Override
    public void draw(){
        for (int i = 1; i <= height; i++) {
            // Print spaces for the left side of the pyramid
            for (int j = 1; j <= height - i; j++) {
                System.out.print("  ");
            }

            // Print stars for the center of the pyramid
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("` ");
            }

            // Move to the next line after each row
            System.out.println();
        }
    }
}
