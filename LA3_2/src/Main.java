import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Hey there, start typing your Java code here...
        System.out.println("Enter Robot type (1 - Vacuum, 2 - Car): ");
        int type = sc.nextInt();


        Robot somerobot = new Robot();
        Tester.test(someRobot);


    }
}