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

    public static void test(Human human, Egg egg, Bread bread, Rice rice, Meat meat) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter code: ");
        int code = scanner.nextInt();
        if (code == 1) {
            if(Modifier.isAbstract(FoodInterface.class.getModifiers())) {
                System.out.println("SUCCESS");
            }else {
                System.out.println("FAILED");
            }
        }
        else if (code == 2) {
            try {
                Method cook = FoodInterface.class.getDeclaredMethod("cook", int.class);
                Method eat = FoodInterface.class.getDeclaredMethod("eat");

                if (cook != null) {
                    if(!(Modifier.isAbstract(cook.getModifiers()))) {
                        System.out.println("FAILED");
                        return;
                    }
                }else {
                    System.out.println("FAILED");
                }

                if (eat != null) {
                    if(!(Modifier.isAbstract(eat.getModifiers()))) {
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
            if (egg instanceof FoodInterface && bread instanceof FoodInterface && rice instanceof FoodInterface && meat instanceof FoodInterface) {
                System.out.println("SUCCESS");
            }else {
                System.out.println("FAILED");
            }
        }

        else if (code == 4) {
            Human newHuman = human;

            if (newHuman.satietyLevel == human.satietyLevel) {
                System.out.println("SUCCESS");
            }
            else {
                System.out.println("FAILED");
            }
        }

        else if (code == 5) {
            Method getSatiety = getMethod(human, "getSatiety");

            try {
                getSatiety.invoke(human);
                System.out.println("SUCCESS");
            }
            catch(Exception e) {
                System.out.println("FAILED");
            }
        }

        else if (code == 6) {
            Human newHuman = new Human();
            Egg newEgg = new Egg();
            Bread newBread = new Bread();
            Rice newRice = new Rice();
            Meat newMeat = new Meat();

            int testSatietyLevel;
            int eggCookCount = 2;
            int breadCookCount = 1;
            int riceCookCount = 1;
            int meatCookCount = 1;

            Method feed = getMethod(newHuman, "feed");

            Method cookEgg = getMethod(newEgg, "cook");
            Method cookBread = getMethod(newBread, "cook");
            Method cookRice = getMethod(newRice, "cook");
            Method cookMeat = getMethod(newMeat, "cook");

            try {
                cookEgg.invoke(newEgg, eggCookCount);
                feed.invoke(newHuman, newEgg);

                testSatietyLevel = 10;

                if (newHuman.satietyLevel != testSatietyLevel) {
                    System.out.println("FAILED");
                    return;
                }

                cookBread.invoke(newBread, breadCookCount);
                feed.invoke(newHuman, newBread);

                testSatietyLevel = 20;

                if (newHuman.satietyLevel != testSatietyLevel) {
                    System.out.println("FAILED");
                    return;
                }

                cookRice.invoke(newRice, riceCookCount);
                feed.invoke(newHuman, newRice);

                testSatietyLevel = 40;

                if (newHuman.satietyLevel != testSatietyLevel) {
                    System.out.println("FAILED");
                    return;
                }

                cookMeat.invoke(newMeat, meatCookCount);
                feed.invoke(newHuman, newMeat);

                testSatietyLevel = 80;

                if (newHuman.satietyLevel != testSatietyLevel) {
                    System.out.println("FAILED");
                    return;
                }

                eggCookCount = 10;

                cookEgg.invoke(newEgg, eggCookCount);
                feed.invoke(newHuman, newEgg);

                testSatietyLevel = 100;

                if (newHuman.satietyLevel != testSatietyLevel) {
                    System.out.println("FAILED");
                    return;
                }

                System.out.println("SUCCESS");
            }
            catch(Exception e) {
                System.out.println("FAILED");
            }
        }

        else if (code == 7) {
            Egg newEgg = new Egg();

            int satietyPoints;
            int testSatietyPoints = 5;
            int eggCookCount = 2;

            Method cook = getMethod(newEgg, "cook");
            Method eat = getMethod(newEgg, "eat");

            try {
                satietyPoints = Integer.parseInt(eat.invoke(newEgg).toString());

                if (satietyPoints != testSatietyPoints) {
                    System.out.println("FAILED");
                    return;
                }

                cook.invoke(newEgg, eggCookCount);

                satietyPoints = Integer.parseInt(eat.invoke(newEgg).toString());

                testSatietyPoints = 10;

                if (satietyPoints != testSatietyPoints) {
                    System.out.println("FAILED");
                    return;
                }

                System.out.println("SUCCESS");
            }
            catch(Exception e) {
                System.out.println("FAILED");
            }
        }

        else if (code == 8) {
            Bread newBread = new Bread();

            int satietyPoints;
            int testSatietyPoints = 10;
            int breadCookCount = 2;

            Method cook = getMethod(newBread, "cook");
            Method eat = getMethod(newBread, "eat");

            try {
                satietyPoints = Integer.parseInt(eat.invoke(newBread).toString());

                if (satietyPoints != testSatietyPoints) {
                    System.out.println("FAILED");
                    return;
                }

                cook.invoke(newBread, breadCookCount);

                satietyPoints = Integer.parseInt(eat.invoke(newBread).toString());

                testSatietyPoints = 20;

                if (satietyPoints != testSatietyPoints) {
                    System.out.println("FAILED");
                    return;
                }

                System.out.println("SUCCESS");
            }
            catch(Exception e) {
                System.out.println("FAILED");
            }
        }

        else if (code == 9) {
            Rice newRice = new Rice();

            int satietyPoints;
            int testSatietyPoints = 20;
            int riceCookCount = 2;

            Method cook = getMethod(newRice, "cook");
            Method eat = getMethod(newRice, "eat");

            try {
                satietyPoints = Integer.parseInt(eat.invoke(newRice).toString());

                if (satietyPoints != testSatietyPoints) {
                    System.out.println("FAILED");
                    return;
                }

                cook.invoke(newRice, riceCookCount);

                satietyPoints = Integer.parseInt(eat.invoke(newRice).toString());

                testSatietyPoints = 40;

                if (satietyPoints != testSatietyPoints) {
                    System.out.println("FAILED");
                    return;
                }

                System.out.println("SUCCESS");
            }
            catch(Exception e) {
                System.out.println("FAILED");
            }
        }

        else if (code == 10) {
            Meat newMeat = new Meat();

            int satietyPoints;
            int testSatietyPoints = 40;
            int meatCookCount = 2;

            Method cook = getMethod(newMeat, "cook");
            Method eat = getMethod(newMeat, "eat");

            try {
                satietyPoints = Integer.parseInt(eat.invoke(newMeat).toString());

                if (satietyPoints != testSatietyPoints) {
                    System.out.println("FAILED");
                    return;
                }

                cook.invoke(newMeat, meatCookCount);

                satietyPoints = Integer.parseInt(eat.invoke(newMeat).toString());

                testSatietyPoints = 80;

                if (satietyPoints != testSatietyPoints) {
                    System.out.println("FAILED");
                    return;
                }

                System.out.println("SUCCESS");
            }
            catch(Exception e) {
                System.out.println("FAILED");
            }
        }
    }
}