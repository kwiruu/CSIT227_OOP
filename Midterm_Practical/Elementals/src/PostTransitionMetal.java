public abstract class PostTransitionMetal extends Element {
    public PostTransitionMetal(int atomic_number, String element_symbol, String element_name, double atomic_weight) {
        super(atomic_number, element_symbol, element_name, atomic_weight);
    }
    public static class Tin extends PostTransitionMetal {

        public Tin() {
            super(50, "Sn", "Tin", 118.7);
        }

        @Override
        public ElementState state(float temperature) {
            if(temperature < 231.9) {
                return ElementState.SOLID;
            } else if (temperature > 231.9 && temperature < 2602) {
                return ElementState.LIQUID;
            } else {
                return ElementState.GAS;
            }
        }
    }
    public static class Aluminum extends PostTransitionMetal implements Conductive{

        public Aluminum() {
            super(13, "Al", "Aluminum", 27);
        }

        @Override
        public ElementState state(float temperature) {
            if(temperature < 660.3) {
                return ElementState.SOLID;
            } else if (temperature > 660.3 && temperature < 2470) {
                return ElementState.LIQUID;
            } else {
                return ElementState.GAS;
            }
        }

        @Override
        public float percent_conductive() {
            return 0.61F;
        }
    }
}