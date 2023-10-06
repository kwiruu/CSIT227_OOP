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

    public static void test(Robot someRobot) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter code: ");
        int code = scanner.nextInt();
        if (code == 1) {
            Field name = Tester.getField(someRobot, "name");
            Field direction = Tester.getField(someRobot, "direction");
            Field xLocation = Tester.getField(someRobot, "xLocation");
            Field yLocation = Tester.getField(someRobot, "yLocation");

            if(
                    (name != null && Modifier.isPrivate(name.getModifiers())) &&
                            (direction != null && Modifier.isPrivate(direction.getModifiers())) &&
                            (xLocation != null && Modifier.isPrivate(xLocation.getModifiers())) &&
                            (yLocation != null && Modifier.isPrivate(yLocation.getModifiers()))
            ) {

                if (someRobot instanceof VacuumRobot) {
                    Field totalUnitsCleaned = Tester.getField(someRobot, "totalUnitsCleaned");

                    if (!(totalUnitsCleaned != null && Modifier.isPrivate(totalUnitsCleaned.getModifiers()))) {
                        System.out.println("FAILED");
                        return;
                    }
                }

                System.out.println("SUCCESS");
            } else {
                System.out.println("FAILED");
            }
        }
        else if (code == 2) {
            Method getName = Tester.getMethod(someRobot, "getName");
            Method getDirection = Tester.getMethod(someRobot, "getDirection");
            Method getXLocation = Tester.getMethod(someRobot, "getXLocation");
            Method getYLocation = Tester.getMethod(someRobot, "getYLocation");

            try {
                System.out.println(getName.invoke(someRobot));
                System.out.println(getDirection.invoke(someRobot));
                System.out.println(getXLocation.invoke(someRobot));
                System.out.println(getYLocation.invoke(someRobot));

                if (someRobot instanceof VacuumRobot) {
                    Method getTotalUnitsCleaned = Tester.getMethod(someRobot, "getTotalUnitsCleaned");
                    System.out.println(getTotalUnitsCleaned.invoke(someRobot));
                }

                System.out.println("SUCCESS");
            } catch (Exception e) {
                System.out.println("FAILED");
            }
        }
        else if (code == 3) {
            Method setName = Tester.getMethod(someRobot, "setName");
            Method setDirection = Tester.getMethod(someRobot, "setDirection");
            Method setXLocation = Tester.getMethod(someRobot, "setXLocation");
            Method setYLocation = Tester.getMethod(someRobot, "setYLocation");

            Method getName = Tester.getMethod(someRobot, "getName");
            Method getDirection = Tester.getMethod(someRobot, "getDirection");
            Method getXLocation = Tester.getMethod(someRobot, "getXLocation");
            Method getYLocation = Tester.getMethod(someRobot, "getYLocation");

            try {
                setName.invoke(someRobot, "Test");
                setDirection.invoke(someRobot, 'N');
                setXLocation.invoke(someRobot, 10);
                setYLocation.invoke(someRobot, 10);
                System.out.println(getName.invoke(someRobot));
                System.out.println(getDirection.invoke(someRobot));
                System.out.println(getXLocation.invoke(someRobot));
                System.out.println(getYLocation.invoke(someRobot));
                System.out.println("SUCCESS");
            } catch (Exception e) {
                System.out.println("FAILED");
            }
        }
        else if (code == 4) {
            Method turnClockwise = Tester.getMethod(someRobot, "turnClockwise");
            Method turnCounterclockwise = Tester.getMethod(someRobot, "turnCounterclockwise");
            Method move = Tester.getMethod(someRobot, "move");
            try {
                turnClockwise.invoke(someRobot);
                turnCounterclockwise.invoke(someRobot);
                move.invoke(someRobot, 10);
                System.out.println("SUCCESS");
            } catch (Exception e) {
                System.out.println("FAILED");
            }
        }

        else if (code == 5) {
            CarRobot newCarRobot = new CarRobot('N', 10, 10);
            if (newCarRobot instanceof Robot) {
                System.out.println("SUCCESS");
            } else {
                System.out.println("FAILED");
            }
        }

        else if (code == 6) {
            String testName = "Car";
            char testDirection = 'N';
            int testXLocation = 10;
            int testYLocation = 10;

            CarRobot newCarRobot = new CarRobot(testDirection, testXLocation, testYLocation);

            Field name = Tester.getField(newCarRobot, "name");
            Field direction = Tester.getField(newCarRobot, "direction");
            Field xLocation = Tester.getField(newCarRobot, "xLocation");
            Field yLocation = Tester.getField(newCarRobot, "yLocation");

            try {
                if(name != null) {
                    name.setAccessible(true);
                    Object value = name.get(newCarRobot);

                    if (!value.toString().equals(testName)) {
                        System.out.println("FAILED");
                        return;
                    }
                } else {
                    System.out.println("FAILED");
                    return;
                }

                if(direction != null) {
                    direction.setAccessible(true);
                    Object value = direction.get(newCarRobot);

                    if (!(value.toString().charAt(0) == testDirection)) {
                        System.out.println("FAILED");
                        return;
                    }
                } else {
                    System.out.println("FAILED");
                    return;
                }

                if(xLocation != null) {
                    xLocation.setAccessible(true);
                    Object value = xLocation.get(newCarRobot);

                    if (!(Integer.parseInt(value.toString()) == testXLocation)) {
                        System.out.println("FAILED");
                        return;
                    }
                } else {
                    System.out.println("FAILED");
                    return;
                }

                if(yLocation != null) {
                    yLocation.setAccessible(true);
                    Object value = yLocation.get(newCarRobot);

                    if (!(Integer.parseInt(value.toString()) == testYLocation)) {
                        System.out.println("FAILED");
                        return;
                    }
                } else {
                    System.out.println("FAILED");
                    return;
                }

                System.out.println("SUCCESS");
            }
            catch (Exception e) {
                System.out.println("FAILED");
            }
        }

        else if (code == 7) {
            VacuumRobot newVacuumRobot = new VacuumRobot('N', 10, 10);
            if (newVacuumRobot instanceof Robot) {
                System.out.println("SUCCESS");
            } else {
                System.out.println("FAILED");
            }
        }

        else if (code == 8) {
            String testName = "Vacuum";
            char testDirection = 'N';
            int testXLocation = 10;
            int testYLocation = 10;

            VacuumRobot newVacuumRobot = new VacuumRobot(testDirection, testXLocation, testYLocation);

            Field name = Tester.getField(newVacuumRobot, "name");
            Field direction = Tester.getField(newVacuumRobot, "direction");
            Field xLocation = Tester.getField(newVacuumRobot, "xLocation");
            Field yLocation = Tester.getField(newVacuumRobot, "yLocation");

            try {
                if(name != null) {
                    name.setAccessible(true);
                    Object value = name.get(newVacuumRobot);

                    if (!value.toString().equals(testName)) {
                        System.out.println("FAILED");
                        return;
                    }
                } else {
                    System.out.println("FAILED");
                    return;
                }

                if(direction != null) {
                    direction.setAccessible(true);
                    Object value = direction.get(newVacuumRobot);

                    if (!(value.toString().charAt(0) == testDirection)) {
                        System.out.println("FAILED");
                        return;
                    }
                } else {
                    System.out.println("FAILED");
                    return;
                }

                if(xLocation != null) {
                    xLocation.setAccessible(true);
                    Object value = xLocation.get(newVacuumRobot);

                    if (!(Integer.parseInt(value.toString()) == testXLocation)) {
                        System.out.println("FAILED");
                        return;
                    }
                } else {
                    System.out.println("FAILED");
                    return;
                }

                if(yLocation != null) {
                    yLocation.setAccessible(true);
                    Object value = yLocation.get(newVacuumRobot);

                    if (!(Integer.parseInt(value.toString()) == testYLocation)) {
                        System.out.println("FAILED");
                        return;
                    }
                } else {
                    System.out.println("FAILED");
                    return;
                }

                System.out.println("SUCCESS");
            }
            catch (Exception e) {
                System.out.println("FAILED");
            }
        }

        else if (code == 9 ) {
            Robot newRobot = new Robot("Test", 'N', 10, 10);
            Method turnClockwise = Tester.getMethod(newRobot, "turnClockwise");

            char testDirection;
            try {
                Field direction = Tester.getField(newRobot, "direction");

                if(direction != null) {
                    direction.setAccessible(true);

                    testDirection = 'E';
                    turnClockwise.invoke(newRobot);

                    Object value = direction.get(newRobot);

                    if (!(value.toString().charAt(0) == testDirection)) {
                        System.out.println("FAILED");
                        return;
                    }

                    testDirection = 'S';
                    turnClockwise.invoke(newRobot);

                    value = direction.get(newRobot);

                    if (!(value.toString().charAt(0) == testDirection)) {
                        System.out.println("FAILED");
                        return;
                    }

                    testDirection = 'W';
                    turnClockwise.invoke(newRobot);

                    value = direction.get(newRobot);

                    if (!(value.toString().charAt(0) == testDirection)) {
                        System.out.println("FAILED");
                        return;
                    }

                    testDirection = 'N';
                    turnClockwise.invoke(newRobot);

                    value = direction.get(newRobot);

                    if (!(value.toString().charAt(0) == testDirection)) {
                        System.out.println("FAILED");
                        return;
                    }
                } else {
                    System.out.println("FAILED");
                    return;
                }

                System.out.println("SUCCESS");
            } catch (Exception e) {
                System.out.println("FAILED");
            }
        }

        else if (code == 10 ) {
            Robot newRobot = new Robot("Test", 'N', 10, 10);
            Method turnCounterclockwise = Tester.getMethod(newRobot, "turnCounterclockwise");

            char testDirection;
            try {

                Field direction = Tester.getField(newRobot, "direction");

                if(direction != null) {
                    direction.setAccessible(true);

                    testDirection = 'W';
                    turnCounterclockwise.invoke(newRobot);

                    Object value = direction.get(newRobot);

                    if (!(value.toString().charAt(0) == testDirection)) {
                        System.out.println("FAILED");
                        return;
                    }

                    testDirection = 'S';
                    turnCounterclockwise.invoke(newRobot);

                    value = direction.get(newRobot);

                    if (!(value.toString().charAt(0) == testDirection)) {
                        System.out.println("FAILED");
                        return;
                    }

                    testDirection = 'E';
                    turnCounterclockwise.invoke(newRobot);

                    value = direction.get(newRobot);

                    if (!(value.toString().charAt(0) == testDirection)) {
                        System.out.println("FAILED");
                        return;
                    }

                    testDirection = 'N';
                    turnCounterclockwise.invoke(newRobot);

                    value = direction.get(newRobot);

                    if (!(value.toString().charAt(0) == testDirection)) {
                        System.out.println("FAILED");
                        return;
                    }
                } else {
                    System.out.println("FAILED");
                    return;
                }

                System.out.println("SUCCESS");
            } catch (Exception e) {
                System.out.println("FAILED");
            }
        }

        else if (code == 11) {
            Robot newRobot = new Robot("Test", 'N', 10, 10);

            Method move = Tester.getMethod(newRobot, "move");
            Method setDirection = Tester.getMethod(newRobot, "setDirection");

            Field xLocation = Tester.getField(newRobot, "xLocation");
            Field yLocation = Tester.getField(newRobot, "yLocation");

            int testXLocation = 15;
            int testYLocation = 15;

            try {
                if(yLocation != null && xLocation != null) {
                    yLocation.setAccessible(true);
                    xLocation.setAccessible(true);

                    move.invoke(newRobot, 5);

                    Object valueY = yLocation.get(newRobot);
                    Object valueX = xLocation.get(newRobot);

                    if (!(Integer.parseInt(valueY.toString()) == testYLocation)) {
                        System.out.println("FAILED");
                        return;
                    }

                    setDirection.invoke(newRobot, 'E');
                    move.invoke(newRobot, 5);
                    valueX = xLocation.get(newRobot);

                    if (!(Integer.parseInt(valueX.toString()) == testXLocation)) {
                        System.out.println("FAILED");
                        return;
                    }

                    setDirection.invoke(newRobot, 'S');
                    move.invoke(newRobot, 5);
                    testYLocation = 10;

                    valueY = yLocation.get(newRobot);

                    if (!(Integer.parseInt(valueY.toString()) == testYLocation)) {
                        System.out.println("FAILED");
                        return;
                    }

                    setDirection.invoke(newRobot, 'W');
                    move.invoke(newRobot, 5);
                    testXLocation = 10;

                    valueX = xLocation.get(newRobot);

                    if (!(Integer.parseInt(valueX.toString()) == testXLocation)) {
                        System.out.println("FAILED");
                        return;
                    }

                } else {
                    System.out.println("FAILED");
                    return;
                }

                System.out.println("SUCCESS");
            }
            catch (Exception e) {
                System.out.println("FAILED");
            }

        }

        else if (code == 12) {
            if (someRobot instanceof CarRobot) {
                Method calculateSeconds = Tester.getMethod(someRobot, "calculateSeconds");

                int testX = 5;
                int testY = 5;

                try {
                    System.out.printf("Calculated seconds = %.2f", calculateSeconds.invoke(someRobot, testX, testY));
                }
                catch (Exception e) {
                    System.out.println("FAILED");
                }
            }
        }

        else if (code == 13) {
            VacuumRobot newVacuumRobot = new VacuumRobot('N', 10, 10);

            Method move = Tester.getMethod(newVacuumRobot, "move");
            Method setDirection = Tester.getMethod(newVacuumRobot, "setDirection");
            Method getXLocation = Tester.getMethod(newVacuumRobot, "getXLocation");
            Method getYLocation = Tester.getMethod(newVacuumRobot, "getYLocation");

            Field totalUnitsCleaned = Tester.getField(newVacuumRobot, "totalUnitsCleaned");

            try {
                if (totalUnitsCleaned != null) {
                    totalUnitsCleaned.setAccessible(true);
                    move.invoke(newVacuumRobot, 5);

                    Object value = totalUnitsCleaned.get(newVacuumRobot);
                    System.out.println("Total units cleaned after 5 steps at N = " + value.toString());

                    setDirection.invoke(newVacuumRobot, 'E');
                    move.invoke(newVacuumRobot, 5);

                    value = totalUnitsCleaned.get(newVacuumRobot);
                    System.out.println("Total units cleaned after 5 steps N->E = " + value.toString());

                    setDirection.invoke(newVacuumRobot, 'S');
                    move.invoke(newVacuumRobot, 5);

                    value = totalUnitsCleaned.get(newVacuumRobot);
                    System.out.println("Total units cleaned after 5 steps E->S = " + value.toString());

                    setDirection.invoke(newVacuumRobot, 'W');
                    move.invoke(newVacuumRobot, 5);

                    value = totalUnitsCleaned.get(newVacuumRobot);
                    System.out.println("Total units cleaned after 5 steps S->W = " + value.toString());

                    setDirection.invoke(newVacuumRobot, 'N');
                    move.invoke(newVacuumRobot, 5);

                    value = totalUnitsCleaned.get(newVacuumRobot);
                    System.out.println("Total units cleaned after 5 steps W->N = " + value.toString());

                    setDirection.invoke(newVacuumRobot, 'E');
                    move.invoke(newVacuumRobot, 5);

                    value = totalUnitsCleaned.get(newVacuumRobot);
                    System.out.println("Total units cleaned after 5 steps N->E = " + value.toString());

                    setDirection.invoke(newVacuumRobot, 'S');
                    move.invoke(newVacuumRobot, 5);

                    value = totalUnitsCleaned.get(newVacuumRobot);
                    System.out.println("Total units cleaned after 5 steps E->S = " + value.toString());

                    System.out.println("SUCCESS");
                    return;
                }
            }
            catch (Exception e) {
                System.out.println("FAILED");
            }
        }

        else if (code == 14) {
            System.out.println(someRobot);
        }
    }
}