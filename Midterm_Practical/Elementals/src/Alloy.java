public class Alloy {
    String alloy_name;
    Element[] alloy_element;

    @Override
    public String toString() {
        return getAlloy_name();
    }

    public Alloy(String alloy_name, Element[] alloy_element) {
        this.alloy_name = alloy_name;
        this.alloy_element = alloy_element;
    }

    public String getAlloy_name() {
        return alloy_name;
    }

    public Element[] getAlloy_element() {
        return alloy_element;
    }

    public static class Steel extends Alloy implements Magnetic{

        public Steel() {
            super("Steel", new Element[] {new TransitionMetal.Iron(), new TransitionMetal.Copper()});
        }

        @Override
        public int magnetic_strength() {
            return 1950;
        }

        @Override
        public MagneticType magnetic_type() {
            return MagneticType.FERROMAGNETIC;
        }
    }
    public static class Bronze extends Alloy {

        public Bronze() {
            super("Bronze", new Element[] {new PostTransitionMetal.Tin(), new TransitionMetal.Copper()});
        }
    }
    public static class Brass extends Alloy implements Conductive {

        public Brass() {
            super("Brass", new Element[] {new TransitionMetal.Copper(), new TransitionMetal.Zinc()});
        }

        @Override
        public float percent_conductive() {
            return 0.28F;
        }
    }
}