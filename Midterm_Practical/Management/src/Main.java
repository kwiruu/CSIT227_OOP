import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> persons = new ArrayList<Person>();
        String input, name, name2;
        int age = 0;
        double salary;
        while (true){
            System.out.print("Enter person type: ");
            input = sc.nextLine();
            if (input.equals("DONE")) {
                break;
            }
            switch (input.charAt(0)) {
                case 'c':
                    System.out.print("Enter customer name: ");
                    name = sc.nextLine();
                    System.out.print("Enter customer age: ");
                    age = sc.nextInt();
                    // TODO add new Customer in persons here
                    persons.add(new Customer(name, age));
                    break;
                case 'e':
                    System.out.print("Enter employee name: ");
                    name = sc.nextLine();
                    System.out.print("Enter employee age: ");
                    age = sc.nextInt();
                    System.out.print("Enter employee salary: ");
                    salary = sc.nextDouble();
                    // TODO add new Employee in persons here
                    persons.add(new Employee(name, age, salary));
                    break;
                // TODO add more cases for other Person subclasses here
                case 'm':
                    System.out.print("Enter manager name: ");
                    name = sc.nextLine();
                    System.out.print("Enter manager age: ");
                    age = sc.nextInt();
                    System.out.print("Enter manager salary: ");
                    salary = sc.nextDouble();
                    persons.add(new Manager(name, age, salary));
                    break;
                case 'd':
                    System.out.print("Enter developer name: ");
                    name = sc.nextLine();
                    System.out.print("Enter developer age: ");
                    age = sc.nextInt();
                    System.out.print("Enter developer salary: ");
                    salary = sc.nextDouble();
                    persons.add(new Developer(name, age, salary));
                    break;
            }
            sc.nextLine();
        }
        while (true) {
            int count = 0;
            double increase;
            System.out.print("Enter action: ");
            input = sc.nextLine();
            switch (input) {
                case "DONE":
                    return;
                case "Birthday":
                    System.out.print("Whose birthday? ");
                    name = sc.nextLine();
                    // TODO find name and call birthday
                    boolean exist = false;
                    for (Person p : persons){
                        if(p.getName().equals(name)){
                            exist = true;
                            p.birthday();
                            break;
                        }
                    }
                    if(!exist){
                        System.out.println("Invalid input");
                    }
                    break;
                case "Assign PM":
                    System.out.print("Select developer: ");
                    name = sc.nextLine();
                    System.out.print("Select manager: ");
                    name2 = sc.nextLine();
                    // TODO find developer "name" and manager "name2" and assign PM
                    Developer dev = null;
                    Manager man = null;
                    for(Person p : persons){
                        if(p.getName().equals(name) && p instanceof Developer){
                            dev = (Developer) p;
                        }
                        if(p.getName().equals(name2) && p instanceof Manager){
                            man = (Manager) p;
                        }
                    }
                    if(dev == null || man == null && !name2.equals("NULL")){
                        System.out.println("Invalid input");
                    } else {
                        if(name2.equals("NULL")){
                            dev.removePM();
                        } else {
                            dev.setProjectManager(man);
                        }
                    }
                    break;
                // TODO add more action cases here
                case "Perform Task":
                    for(Person p : persons){
                        count++;
                        p.performTask();
                    }
                    break;
                case "Give Raise":
                    System.out.print("Enter manager: ");
                    name = sc.nextLine();
                    System.out.print("Enter employee: ");
                    name2 = sc.nextLine();
                    System.out.print("Enter increase: ");
                    increase = sc.nextDouble();
                    Manager manR = null;
                    Employee empR = null;
                    for(Person p : persons){
                        if(p.getName().equals(name) && p instanceof Manager){
                            manR = (Manager) p;
                        }
                        if(p.getName().equals(name2) && p instanceof Employee){
                            empR = (Employee) p;
                        }
                    }
                    if(manR == null || empR == null){
                        System.out.println("Invalid input");
                    } else {
                        manR.giveRaise(empR, increase);
                    }
                    sc.nextLine();
                    break;
                case "Customer Speak":
                    System.out.print("Select customer: ");
                    name = sc.nextLine();
                    System.out.print("Select employee: ");
                    name2 = sc.nextLine();
                    Customer cus = null;
                    Employee emp = null;
                    for(Person p : persons){
                        if(p.getName().equals(name) && p instanceof Customer){
                            cus = (Customer) p;
                        }
                        if(p.getName().equals(name2) && p instanceof Employee){
                            emp = (Employee) p;
                        }
                    }
                    if(cus == null || emp == null){
                        System.out.println("Invalid input");
                    } else {
                        cus.speak(emp);
                    }
                    break;
                case "Person List":
                    if(persons.isEmpty()){
                        System.out.println("No persons in list");
                    } else {
                        for(Person p : persons){
                            System.out.println(p);
                            count++;
                        }
                        System.out.println("Total Count: " + count);
                    }
                    break;
                case "Developer List":
                    for(Person p : persons){
                        if(p instanceof Developer){
                            count++;
                            System.out.println(p);
                        }
                    }
                    if(count == 0){
                        System.out.println("No developers in list");
                    } else {
                        System.out.println("Total Count: " + count);
                    }
                    break;
                case "Manager List":
                    for(Person p : persons){
                        if(p instanceof Manager){
                            count++;
                            System.out.println(p);
                        }
                    }
                    if(count == 0){
                        System.out.println("No managers in list");
                    } else {
                        System.out.println("Total Count: " + count);
                    }
                    break;
                case "Employee List":
                    for(Person p : persons){
                        if(p instanceof Employee){
                            count++;
                            System.out.println(p);
                        }
                    }
                    if(count == 0){
                        System.out.println("No employees in list");
                    } else {
                        System.out.println("Total Count: " + count);
                    }
                    break;
                case "Customer List":
                    for(Person p : persons){
                        if(p instanceof Customer){
                            count++;
                            System.out.println(p);
                        }
                    }
                    if(count == 0){
                        System.out.println("No customers in list");
                    } else {
                        System.out.println("Total Count: " + count);
                    }
                    break;
                default:
                    System.out.println("Invalid action");
            }
        }
    }

}