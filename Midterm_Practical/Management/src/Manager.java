public class Manager extends Employee{
    public void giveRaise(Employee e, double increase){
        if(increase < 0){
            System.out.println("Invalid increase");
            return;
        }
        if(e == this){
            e.setSalary(increase + this.salary);
        } else {
            e.setSalary(increase + e.getSalary());
            this.setSalary((increase / 2) + this.salary);
        }
    }
    public Manager(String name, int age, double salary) {
        super(name, age, salary);
    }

    @Override
    public String toString() {
        return "Mgr. " + super.toString();
    }
}