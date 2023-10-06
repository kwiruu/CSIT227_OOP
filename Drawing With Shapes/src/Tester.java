import java.util.*;
import java.lang.reflect.*;

class Tester {
    private static List<Field> getAllFields(List<Field> fields, Class<?> type) {
        fields.addAll(Arrays.asList(type.getDeclaredFields()));

        if (type.getSuperclass() != null) {
            getAllFields(fields, type.getSuperclass());
        }

        return fields;
    }

    private static Field getField(Object obj, String fieldName) {
        List<Field> fields = getAllFields(new LinkedList<Field>(), obj.getClass());
        for(Field f : fields){
            if (f.getName().equals(fieldName)) {
                return f;
            }
        }
        return null;
    }

    private static Method getMethod(Object obj, String methodName) {
        Method[] methods = obj.getClass().getMethods();
        for (Method m : methods) {
            if (m.getName().equals(methodName)) {
                return m;
            }
        }
        return null;
    }

    public static void test (Shape shape) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter code: ");
        int code = scanner.nextInt();
        if (code == 1) {
            if(Modifier.isAbstract(Shape.class.getModifiers())) {
                System.out.println("SUCCESS");
            }else {
                System.out.println("FAILED");
            }
        }
        else if (code == 2) {
            try {
                Method draw = Shape.class.getDeclaredMethod("draw");

                if (draw != null) {
                    if(!(Modifier.isAbstract(draw.getModifiers()))) {
                        System.out.println("FAILED");
                        return;
                    }
                }else {
                    System.out.println("FAILED");
                }
                System.out.println("SUCCESS");
            }
            catch(Exception e) {
                System.out.println("FAILED");
            }
        }

        else if (code == 3) {
            Triangle newTriangle = new Triangle(4);

            if (newTriangle.height != 4 && !(newTriangle instanceof Shape)) {
                System.out.println("FAILED");
                return;
            }

            System.out.println("SUCCESS");
        }

        else if (code == 4) {
            Square newSquare = new Square(4);

            if (newSquare.side != 4 && !(newSquare instanceof Shape)) {
                System.out.println("FAILED");
                return;
            }

            System.out.println("SUCCESS");
        }

        else if (code == 5) {
            Diamond newDiamond = new Diamond(4);

            if (newDiamond.height != 4 && !(newDiamond instanceof Shape)) {
                System.out.println("FAILED");
                return;
            }

            System.out.println("SUCCESS");
        }

        else if (code == 6) {
            Method draw = getMethod(shape, "draw");

            try {
                draw.invoke(shape);
                System.out.println("SUCCESS");
            }
            catch(Exception e) {
                System.out.println("FAILED");
            }
        }
    }
}