import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Shape someShape = null;


        System.out.print("Select shape: (1 - Triangle, 2 - Square, 3 - Diamond): ");
        int choice = sc.nextInt();
        switch (choice){
            case 0:
                System.out.print("Exiting...");
                break;
            case 1:
                System.out.print("Enter height: ");
                int height = sc.nextInt();
                someShape = new Triangle(height);
                break;
            case 2:
                System.out.print("Enter side: ");
                int side = sc.nextInt();
                someShape = new Square(side);
                break;
            case 3:
                System.out.print("Enter height: ");
                height = sc.nextInt();
                someShape = new Diamond(height);
                break;
        }

        Tester.test(someShape);
    }
}