class Human{

    public int satietyLevel;
    public int satietyPoints;

    public Human() {
        this.satietyLevel = 0;
        this.satietyPoints = 0;
    }

    public void getSatiety(){
        if(satietyLevel >= 0 && satietyLevel <= 50){
            System.out.print("Hungry\n");
        }else if(satietyLevel > 50 && satietyLevel <= 90){
            System.out.print("Satiated\n");
        }else{
            System.out.print("Full\n");
        }
    }

    public void feed(FoodInterface food) {
        satietyPoints = food.eat();
        if (satietyLevel + satietyPoints <= 100) {
            satietyLevel += satietyPoints;
        } else {
            satietyLevel = 100;
        }
    }

}