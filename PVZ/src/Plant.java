public abstract class Plant {
    public static final int INFINITE = Integer.MAX_VALUE;

    String name;
    int hp;
    int sun_cost;

    public Plant(String name, int sun_cost) {
        this.name = name;
        this.hp = 6;
        this.sun_cost = sun_cost;
    }

    public Plant(String name, int hp, int sun_cost) {
        this.name = name;
        this.hp = hp;
        this.sun_cost = sun_cost;
    }

    public int getHP(){
        return hp;
    }

    public String getName(){
        return name;
    }

    public int getSun_cost(){
        return sun_cost;
    }

    public boolean isAlive() {
        if(hp>0){
            return true;
        }
        return false;
    }

    public String die() {
        this.hp = 0;
        return (name+" dies");
    }


        @Override
        public String toString() {
            return name;
        }

    // Add Plant subclasses here, and
    // Hint: You can also add Comparator inner classes here
    // WallNut and CoffeeBean given for free
    public static class Sunflower extends Plant implements SunProducer, Upgradable {
        public Sunflower() {
            super("Sunflower", 6, 50);
        }

        @Override
        public int produce_sun() {
            System.out.println(name + " produces 25 suns");
            return 25;
        }

        @Override
        public PlantUpgrade upgrade() {
            return new TwinSunflower();
        }
    }

    public static class TwinSunflower extends Plant implements SunProducer, PlantUpgrade{
        public TwinSunflower() {
            super("Twin Sunflower", 6 ,50);
        }

        @Override
        public int produce_sun() {
            System.out.println(name + " produces 50 suns");
            return 50;
        }

        @Override
        public int concurrentSunCost()  {
            return 50;
        }
    }
    public static class WallNut extends Plant{
        public WallNut() {
            super("Wall Nut", 25, 50);
        }
    }

    public static class CoffeeBean extends Plant{
        public CoffeeBean() {
            super("Coffee Bean", INFINITE, 75);
        }
    }

    public static class Peashooter extends Plant implements Attacker{
        public Peashooter() {
            super("Peashooter", 6, 100);
        }

        @Override
        public int attack() {
            System.out.println(name + " attacks");
            return 1;
        }

        @Override
        public int rangetype() {
            return 1;
        }
    }

    public static class Squash extends Plant implements InstantKiller, Attacker{
        public Squash() {
            super("Squash", INFINITE, 50);
        }

        @Override
        public String die(){
            this.hp = 0;
            return this.name + " dies while squashing zombies ";
        }

        @Override
        public int killType() {
            return 3;
        }

        @Override
        public int attack() {
            System.out.println(name + " attacks");
            System.out.println(die());
            return 3;
        }

        @Override
        public int rangetype() {
            return 3;
        }
    }

    public static class Jalapeno extends Plant implements InstantKiller, Attacker{

        public Jalapeno() {
            super("Jalapeno", INFINITE, 125);
        }

        @Override
        public int killType() {
            return 10 ;
        }

        @Override
        public String die(){
            this.hp = 0;
            return this.name + " dies while exploding";
        }


        @Override
        public int attack() {
            System.out.println(name + " attacks");
            System.out.println(die());
            return 5;
        }

        @Override
        public int rangetype() {
            return 1;
        }
    }

    public static class LilyPad extends Plant implements Upgradable{

        public LilyPad() {
            super("Lily Pad", 6, 25);
        }

        @Override
        public PlantUpgrade upgrade() {
            return new Cattail();
        }
    }

    public static class Cattail extends Plant implements Attacker, PlantUpgrade{
        public Cattail() {
            super("Cattail", 6 ,225);
        }

        @Override
        public int concurrentSunCost()  {
            return 25;
        }

        @Override
        public int attack() {
            System.out.println(name+" attacks");
            return 1;
        }

        @Override
        public int rangetype() {
            return 4;
        }
    }

}