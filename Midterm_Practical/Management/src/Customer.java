public class Customer extends Person{

    public Customer(String name, int age) {
        super(name, age);
    }
    @Override
    public void performTask() {
        System.out.println(getName() + " is browsing through");
    }
    public void speak(Employee e){
        if(e instanceof Developer && this.getAge() > e.getAge() && ((Developer) e).projectManager != null){
            System.out.println("Can I see your manager " + ((Developer) e).projectManager.getName()+ "?");
        } else {
            System.out.println("Oh, hello, " + e.getName() + ". Can you assist me?");
        }
    }
}