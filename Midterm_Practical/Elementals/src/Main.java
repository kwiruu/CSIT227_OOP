import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Element> elements = new ArrayList<>();
        List<Alloy> alloys = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String input;
        do {
            System.out.print("Enter element/alloy: ");
            input = sc.nextLine();
            switch (input) {
                case "Copper":
                    elements.add(new TransitionMetal.Copper());
                    break;
                // TODO add more cases here
                case "Titanium":
                    elements.add(new TransitionMetal.Titanium());
                    break;
                case "Gold":
                    elements.add(new TransitionMetal.Gold());
                    break;
                case "Zinc":
                    elements.add(new TransitionMetal.Zinc());
                    break;
                case "Iron":
                    elements.add(new TransitionMetal.Iron());
                    break;
                case "Technetium":
                    elements.add(new TransitionMetal.Technetium());
                    break;
                case "Tin":
                    elements.add(new PostTransitionMetal.Tin());
                    break;
                case "Aluminum":
                    elements.add(new PostTransitionMetal.Aluminum());
                    break;
                case "Uranium":
                    elements.add(new Actinide.Uranium());
                    break;
                case "Steel":
                    alloys.add(new Alloy.Steel());
                    break;
                case "Brass":
                    alloys.add(new Alloy.Brass());
                    break;
                case "Bronze":
                    alloys.add(new Alloy.Bronze());
                    break;
            }
        } while (!input.equals("DONE"));

        do {
            int count = 0;
            System.out.print("Enter action: ");
            input = sc.nextLine();
            switch (input){
                case "Radiate":
                    // TODO Radiate here
                    for(Element e : elements){
                        if(e instanceof Radioactive){
                            count++;
                            ((Radioactive) e).radiate();
                            System.out.println(e + "'s half-life: " + ((Radioactive) e).half_life());
                        }
                    }
                    if(count == 0){
                        System.out.println("No radioactive materials present");
                    }
                    break;
                case "Magnetize":
                    // TODO Radiate here
                    MagneticType mType;
                    for(Element e : elements){
                        if(e instanceof Magnetic){
                            count++;
                            mType = ((Magnetic) e).magnetic_type();
                            switch (mType){
                                case FERROMAGNETIC:
                                    System.out.println(e + " is ferromagnetic with strength of " + ((Magnetic) e).magnetic_strength());
                                    break;
                                case PARAMAGNETIC:
                                    System.out.println(e + " is paramagnetic with strength of " + ((Magnetic) e).magnetic_strength());
                                    break;
                            }
                        }
                    }
                    for(Alloy a : alloys){
                        if(a instanceof Magnetic){
                            count++;
                            mType = ((Magnetic) a).magnetic_type();
                            switch (mType){
                                case FERROMAGNETIC:
                                    System.out.println(a + " is ferromagnetic with strength of " + ((Magnetic) a).magnetic_strength());
                                    break;
                                case PARAMAGNETIC:
                                    System.out.println(a + " is paramagnetic with strength of " + ((Magnetic) a).magnetic_strength());
                                    break;
                            }
                        }
                    }
                    if(count == 0){
                        System.out.println("No magnetic materials present");
                    }
                    break;
                case "Conduct":
                    // TODO Radiate here
                    for(Element e : elements){
                        if(e instanceof Conductive){
                            count++;
                            System.out.printf("%s conductivity is %.1f%%\n", e, (((Conductive) e).percent_conductive()) * 100);
                        }
                    }
                    for(Alloy a : alloys){
                        if(a instanceof Conductive){
                            count++;
                            System.out.printf("%s conductivity is %.1f%%\n", a, (((Conductive) a).percent_conductive()) * 100);
                        }
                    }
                    if(count == 0){
                        System.out.println("No conductive materials present");
                    }
                    break;
                case "Alloy Components":
                    // TODO Radiate here
                    for(Alloy a : alloys){
                        count++;
                        Element[] alloyElem = a.getAlloy_element();
                        System.out.println(a.getAlloy_name() + " consists of " + alloyElem[0].getElement_name() + ", " + alloyElem[1].getElement_name());
                    }
                    if(count == 0){
                        System.out.println("No alloys present");
                    }
                    break;
                case "Get State":
                    System.out.print("Enter temperature: ");
                    float temp = sc.nextFloat();
                    sc.nextLine(); // This is to clear the newline
                    // TODO print state of elements
                    for(Element e : elements){
                        Element.ElementState state = e.state(temp);
                        switch (state){
                            case SOLID:
                                System.out.println(e + " is solid");
                                break;
                            case LIQUID:
                                System.out.println(e + " is liquid");
                                break;
                            case GAS:
                                System.out.println(e + " is gas");
                                break;
                        }
                    }
                    break;
                case "Sort by Weight":
                    Collections.sort(elements);
                    for (Element e : elements) {
                        System.out.println(e + " = " + e.getAtomic_weight());
                    }
                    if (elements.isEmpty()) {
                        System.out.println("No elements present");
                    }
                    break;
            }
        } while (!input.equals("DONE"));
    }
}