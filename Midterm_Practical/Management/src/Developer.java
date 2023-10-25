public class Developer extends Employee{
    Manager projectManager;
    public Manager getProjectManager() {
        return projectManager;
    }
    protected void setProjectManager(Manager manager) {
        if (projectManager == null){
            this.projectManager = manager;
        } else {
            System.out.println(getName() + " already has a manager");
        }
    }
    public void removePM(){
        projectManager = null;
    }
    public Developer(String name, int age, double salary) {
        super(name, age, salary);
    }
    @Override
    public void birthday() {
        super.birthday();
        if(projectManager != null){
            projectManager.giveRaise(this, (0.05 * salary));
        }
    }
    @Override
    public void performTask() {
        System.out.println(getName() + " is coding");
    }
    @Override
    public String toString() {
        if(projectManager != null){
            return super.toString() + " [" + projectManager.getName() + "]";
        }
        return super.toString();
    }
}