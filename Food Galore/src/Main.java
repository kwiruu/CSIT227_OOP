import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Hey there, start typing your Java code here

        Scanner sc = new Scanner(System.in);
        Human human = new Human();
        Egg egg = new Egg();
        Bread bread = new Bread();
        Rice rice = new Rice();
        Meat meat = new Meat();
        Human human1 = new Human();

        System.out.print("Enter the number of times to cook Egg: ");
        int num1 = sc.nextInt();
        egg.cook(num1);
        System.out.print("Enter the number of times to cook Bread: ");
        int num2 = sc.nextInt();
        bread.cook(num2);
        System.out.print("Enter the number of times to cook Rice: ");
        int num3 = sc.nextInt();
        rice.cook(num3);
        System.out.print("Enter the number of times to cook Meat: ");
        int num4 = sc.nextInt();
        meat.cook(num4);

        human.feed(egg);
        human.feed(bread);
        human.feed(rice);
        human.feed(meat);

        Tester.test(human, egg, bread, rice, meat);

    }
}