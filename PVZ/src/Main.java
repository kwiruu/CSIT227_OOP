import java.util.*;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        List<Plant> plants = new ArrayList<>();
        List<Plant> plants2 = new ArrayList<>(plants);

        int modes = 0;
        boolean isSleeping;
        Scanner sc = new Scanner(System.in);
        System.out.print("Game Mode: ");
        String mode = sc.nextLine();
        switch (mode){
            case "Day":
                modes = 1;
                isSleeping = true;
                break;
            case "Night":
                modes = 2;
                isSleeping = false;
                break;
            case "Fog":
                modes = 3;
                isSleeping = false;
                break;
            case "Roof":
                modes = 4;
                isSleeping = true;
                break;
            case "Pool":
                modes = 5;
                isSleeping = true;
                break;
            default:
                System.out.println("Invalid");
        }

        String input;
        do {
            System.out.print("Add a plant: ");
            input = sc.nextLine();
            switch (input) {
                case "DONE":
                    break;
                case "Wall Nut":
                    plants.add(new Plant.WallNut());
                    break;
                case "Sun-shroom":
                    if(modes == 1 || modes == 4 || modes == 5){
                        plants.add(new Mushroom.SunShroom(false));
                    }
                    else {
                        plants.add(new Mushroom.SunShroom(true));
                    }
                    break;
                case "Puff-shroom":
                    if(modes == 1 || modes == 4 || modes == 5){
                        plants.add(new Mushroom.PuffShroom(false));
                    }
                    else {
                        plants.add(new Mushroom.PuffShroom(true));
                    }
                    break;
                case "Sunflower":
                    plants.add(new Plant.Sunflower());
                    break;
                case "Peashooter":
                    plants.add(new Plant.Peashooter());
                    break;
                case "Squash":
                    plants.add(new Plant.Squash());
                    break;
                case "Jalapeno":
                    plants.add(new Plant.Jalapeno());
                    break;
                case "Doom-shroom":
                    if(modes == 1 || modes == 4 || modes == 5){
                        plants.add(new Mushroom.DoomShroom(false));
                    }
                    else {
                        plants.add(new Mushroom.DoomShroom(true));
                    }
                    break;
                case "Lily Pad":
                    plants.add(new Plant.LilyPad());
                    break;
                case "Twin Sunflower":
                    boolean y = false;
                    for(Plant p: plants) {
                        if (p instanceof Plant.Sunflower) {
                            plants.set(plants.indexOf(p), (Plant) ((Upgradable) p).upgrade());
                            y = true;
                            break;
                        }
                    }
                    if(!y) {
                        plants.add(new Plant.TwinSunflower());
                    }
                    break;

                case "Cattail":
                    boolean x = false;
                    for(Plant p: plants) {
                        if (p instanceof Plant.LilyPad) {
                            plants.set(plants.indexOf(p), (Plant) ((Upgradable) p).upgrade());
                            x = true;
                            break;
                        }
                    }
                    if(!x) {
                        plants.add(new Plant.Cattail());
                    }
                    break;
                case "Coffee Bean":
                    Plant.CoffeeBean cb = new Plant.CoffeeBean();
                    plants.add(cb);
                    for(Plant p : plants){
                        if(p instanceof Mushroom){
                            if(!((Mushroom) p).isAwake()){
                                ((Mushroom) p).awaken(cb);
                                plants2.add(cb);
                                System.out.println(cb.die());
                                break;
                            }
                        }
                    }
                    plants.removeAll(plants2);
                    break;
                default:
                    System.out.println(input + " is not a plant");
            }
        } while (!input.equals("DONE"));

        do {
            System.out.print("Do something: ");
            input = sc.nextLine();
            switch (input) {
                case "DONE":
                    break;
                case "Produce Sun":
                    int ctr=0;
                    int sunsProduced = 0;
                    for(Plant p: plants ) {

                        if (p instanceof SunProducer) {
                            sunsProduced += ((SunProducer) p).produce_sun();
                            ctr++;
                        }
                    }
                    System.out.println(ctr + " sun producers gather " + sunsProduced + " suns");
                    break;

                case "Instant Kill Status":
                    int ix = 0;
                    for (Plant p : plants) {
                        if (p instanceof InstantKiller && p.isAlive()) {
                            ix++;
                            if(p instanceof Mushroom){
                                if(true){
                                    if (((InstantKiller) p).killType() == 10) {
                                        System.out.println(p.name + " can kill instantly");
                                    }
                                }
                            }
                            if(!(p instanceof Mushroom)){
                                if (((InstantKiller) p).killType() == 10) {
                                    System.out.println(p.name + " can kill instantly");
                                }
                                if (((InstantKiller) p).killType() == 3) {
                                    System.out.println(p.name + " can kill on contact");
                                }
                            }

                        }
                    }
                    if (ix == 0) {
                        System.out.println("You have no plants which can kill instantly");
                    }
                    break;

                case "Attacker Status":
                    for(Plant p: plants){
                        if(p instanceof Attacker && p.isAlive()){
                            if(((Attacker) p).rangetype()==1){
                                System.out.println(p.name + " can attack on a single line");
                            }
                            else if(((Attacker) p).rangetype()==2){
                                System.out.println(p.name + " can attack using area-of-effect");
                            }
                            else if(((Attacker) p).rangetype()==3){
                                System.out.println(p.name + " can attack only when enemy is nearby");
                            }
                            else if(((Attacker) p).rangetype()==4){
                                System.out.println(p.name + " can anywhere");
                            }
                        }
                    }
                    break;

                case "Attack":
                    int totalDamage=0;
                    int count=0;
                    for(Plant p: plants){

                        if(p instanceof Attacker && p.isAlive()) {
                            totalDamage +=((Attacker) p).attack();
                            count++;
                                }
                            }
                    System.out.println( count +" attackers dealing " + totalDamage + " damage");
                    break;
                case "ALL":
                    for(Plant p: plants){
                        System.out.println(p.name);
                    }
                    break;
                case "Sort by HP":

                    Comparator<Plant> HPcomparator = new Comparator<Plant>() {
                        @Override
                        public int compare(Plant o1, Plant o2) {
                            return Integer.compare(o2.getHP(), o1.getHP());
                        }
                    };

                    Comparator<Plant> Namecomparator = new Comparator<Plant>() {
                        @Override
                        public int compare(Plant n1, Plant n2) {
                            return CharSequence.compare(n1.getName(), n2.getName());
                        }
                    };

                    Collections.sort(plants, HPcomparator);
                    Collections.sort(plants, Namecomparator);
                    Collections.sort(plants, HPcomparator);

                    for(Plant p: plants) {
                        if (p instanceof Plant) {
                            if (p instanceof InstantKiller && (p instanceof Mushroom)) {
                                if (((Mushroom) p).isAwake()) {
                                    System.out.println(p.name + " (∞)" + " - cost: " + p.sun_cost);
                                } else {
                                    System.out.println(p.name + " (" + p.hp + ")" + " - cost: " + p.sun_cost);
                                }
                            } else if (p instanceof InstantKiller && p.isAlive()) {
                                System.out.println(p.name + " (∞)" + " - cost: " + p.sun_cost);
                            } else {
                                System.out.println(p.name + " (" + p.hp + ")" + " - cost: " + p.sun_cost);
                                }
                            }
                        }

                    break;
                case "Sort by Name":

                    Comparator<Plant> ByNamecomparator = new Comparator<Plant>() {
                        @Override
                        public int compare(Plant n1, Plant n2) {
                            return CharSequence.compare(n1.getName(), n2.getName());
                        }
                    };

                    Collections.sort(plants, ByNamecomparator);

                    for(Plant p: plants){
                        if(p instanceof InstantKiller && p.isAlive()) {
                            System.out.println(p.name + " (∞)" + " - cost: " + p.sun_cost);
                        }
                        else {
                            System.out.println(p.name + " (" + p.hp + ")" + " - cost: " + p.sun_cost);
                        }
                    }
                    break;
                case "Sort by Sun Cost":

                    Comparator<Plant> SCcomparator = new Comparator<Plant>() {
                        @Override
                        public int compare(Plant s1, Plant s2) {
                            return Integer.compare(s2.getSun_cost(), s1.getSun_cost());
                        }
                    };

                    Comparator<Plant> SCByNamecomparator = new Comparator<Plant>() {
                        @Override
                        public int compare(Plant n1, Plant n2) {
                            return CharSequence.compare(n1.getName(), n2.getName());
                        }
                    };
                    Collections.sort(plants, SCByNamecomparator);
                    Collections.sort(plants, SCcomparator);

                    for(Plant p: plants){
                        if(p instanceof InstantKiller) {
                            System.out.println(p.name + " (∞)" + " - cost: " + p.sun_cost);
                        }
                        else {
                            System.out.println(p.name + " (" + p.hp + ")" + " - cost: " + p.sun_cost);
                        }
                    }
                    break;

                default:
                    System.out.println("Unknown action: " + input);
            }
        } while (!input.equals("DONE"));
    }
}