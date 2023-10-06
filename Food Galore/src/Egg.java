public class Egg implements FoodInterface{

    private int satietyPoints = 5;

    public void cook(int n){
        satietyPoints *= n;
    }

    public int eat(){
        return satietyPoints;
    }

}