public abstract class Actinide extends Element implements Radioactive{

    public Actinide(int atomic_number, String element_symbol, String element_name, double atomic_weight) {
        super(atomic_number, element_symbol, element_name, atomic_weight);
    }
    public static class Uranium extends Actinide {

        public Uranium() {
            super(92, "U", "Uranium", 238);
        }

        @Override
        public ElementState state(float temperature) {
            if(temperature < 1132.2) {
                return ElementState.SOLID;
            } else if (temperature > 1132.2 && temperature < 4131) {
                return ElementState.LIQUID;
            } else {
                return ElementState.GAS;
            }
        }

        @Override
        public int half_life() {
            return 25166;
        }

        @Override
        public void radiate() {
            System.out.println(super.toString() + " emitting radiation");
        }
    }
}