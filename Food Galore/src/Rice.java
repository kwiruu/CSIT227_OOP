public class Rice implements FoodInterface{

    private int satietyPoints = 20;

    public void cook(int n){
        satietyPoints *= n;
    }

    public int eat(){
        return satietyPoints;
    }

}