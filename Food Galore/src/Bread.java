public class Bread implements FoodInterface{

    private int satietyPoints = 10;

    public void cook(int n){
        satietyPoints *= n;
    }

    public int eat(){
        return satietyPoints;
    }

}