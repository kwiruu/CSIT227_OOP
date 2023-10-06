public class Meat implements FoodInterface{

    private int satietyPoints = 40;

    public void cook(int n){
        satietyPoints *= n;
    }

    public int eat(){
        return satietyPoints;
    }

}