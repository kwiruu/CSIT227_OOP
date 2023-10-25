public abstract class Person {
    private final String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public void birthday() {
        System.out.println("Happy birthday, " + name + "!");
        age++;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }

    public abstract void performTask();
}