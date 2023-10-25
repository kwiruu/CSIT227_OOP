import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Solid solid = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter solid: ");
        String option = sc.nextLine();
        int x, y = 0;
        System.out.print("Enter x: ");
        x = sc.nextInt();
        if(x != -1) {
            System.out.print("Enter y: ");
            y = sc.nextInt();
        }
        switch (option) {
            case "Cuboid":
                System.out.print("Enter height: ");
                double hei = sc.nextDouble();
                System.out.print("Enter base: ");
                double base = sc.nextDouble();
                System.out.print("Enter length: ");
                double len = sc.nextDouble();
                // This nextLine is to rid the next line made by the previous scan
                // Do this in the future as well, before getting a String input
                sc.nextLine();
                if(x!=-1){
                    solid = new Cuboid(x,y,hei, base, len);
                }
                else{
                    solid = new Cuboid(hei, base, len);
                }
                break;
            case "Cube":
                System.out.print("Enter side: ");

                len = sc.nextDouble();
                hei = len;
                base = len;
                sc.nextLine();
                if(x!=-1){
                    solid = new Cuboid.Cube(x,y,hei, base, len);
                }
                else{
                    solid = new Cuboid.Cube(hei, base, len);
                }
                break;
            case "Sphere":
                System.out.print("Enter diameter: ");
                double dia = sc.nextDouble();
                sc.nextLine();
                if(x!=-1){
                    solid = new Sphere(x,y,dia);
                }
                else{
                    solid = new Sphere(dia);
                }
                break;
            case "Hemisphere":
                System.out.print("Enter diameter: ");
                dia = sc.nextDouble();
                sc.nextLine();
                if(x!=-1){
                    solid = new Sphere.Hemisphere(x,y,dia);
                }
                else{
                    solid = new Sphere.Hemisphere(dia);
                }
                break;
            case "Cone":
                System.out.print("Enter base diameter: ");
                dia = sc.nextDouble();
                System.out.print("Enter height: ");
                hei = sc.nextDouble();
                sc.nextLine();
                if(x!=-1){
                    solid = new Cone(x,y,dia,hei);
                }
                else{
                    solid = new Cone(dia,hei);
                }
                break;
            // Add other cases for other shapes here
            default:
                System.out.println("Not a shape");
        }

        // This assert simply states that by the time the switch is done,
        // the shape should already be assigned to a particular shape
        // and is therefore not null anymore
        assert solid != null;

        System.out.println(solid);
        System.out.print("Surface Area is ");
        System.out.format("%.2f", solid.surfaceArea());
        System.out.print("\nVolume is ");
        System.out.format("%.2f", solid.volume());
    }
}