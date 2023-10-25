public abstract class TransitionMetal extends Element{

    public TransitionMetal(int atomic_number, String element_symbol, String element_name, double atomic_weight) {
        super(atomic_number, element_symbol, element_name, atomic_weight);
    }
    public static class Titanium extends TransitionMetal {

        public Titanium() {
            super(22, "Ti", "Titanium", 47.9);
        }

        @Override
        public ElementState state(float temperature) {
            if(temperature < 1668) {
                return ElementState.SOLID;
            } else if (temperature > 1668 && temperature < 3287) {
                return ElementState.LIQUID;
            } else {
                return ElementState.GAS;
            }
        }
    }
    public static class Gold extends TransitionMetal implements Conductive{

        public Gold() {
            super(79, "Au", "Gold", 197);
        }

        @Override
        public ElementState state(float temperature) {
            if(temperature < 1064) {
                return ElementState.SOLID;
            } else if (temperature > 1064 && temperature < 2970) {
                return ElementState.LIQUID;
            } else {
                return ElementState.GAS;
            }
        }

        @Override
        public float percent_conductive() {
            return 0.7F;
        }
    }
    public static class Zinc extends TransitionMetal implements Conductive{

        public Zinc() {
            super(30, "Zn", "Zinc", 65.4);
        }

        @Override
        public ElementState state(float temperature) {
            if(temperature < 419.5) {
                return ElementState.SOLID;
            } else if (temperature > 419.5 && temperature < 907) {
                return ElementState.LIQUID;
            } else {
                return ElementState.GAS;
            }
        }

        @Override
        public float percent_conductive() {
            return 0.27F;
        }
    }
    public static class Iron extends TransitionMetal implements Magnetic{

        public Iron() {
            super(26, "Fe", "Iron", 55.8);
        }

        @Override
        public ElementState state(float temperature) {
            if(temperature < 1538) {
                return ElementState.SOLID;
            } else if (temperature > 1538 && temperature < 2862) {
                return ElementState.LIQUID;
            } else {
                return ElementState.GAS;
            }
        }

        @Override
        public int magnetic_strength() {
            return 1710;
        }

        @Override
        public MagneticType magnetic_type() {
            return MagneticType.FERROMAGNETIC;
        }
    }
    public static class Copper extends TransitionMetal implements Conductive{

        public Copper() {
            super(29, "Cu", "Copper", 63.5);
        }

        @Override
        public ElementState state(float temperature) {
            if(temperature < 1064) {
                return ElementState.SOLID;
            } else if (temperature > 1064 && temperature < 2970) {
                return ElementState.LIQUID;
            } else {
                return ElementState.GAS;
            }
        }

        @Override
        public float percent_conductive() {
            return 1.0F;
        }
    }
    public static class Technetium extends TransitionMetal implements Conductive, Magnetic, Radioactive{

        public Technetium() {
            super(43, "Tc", "Technetium", 98);
        }

        @Override
        public ElementState state(float temperature) {
            if(temperature < 1064) {
                return ElementState.SOLID;
            } else if (temperature > 1064 && temperature < 2970) {
                return ElementState.LIQUID;
            } else {
                return ElementState.GAS;
            }
        }

        @Override
        public float percent_conductive() {
            return 0.65F;
        }

        @Override
        public int magnetic_strength() {
            return 270;
        }

        @Override
        public MagneticType magnetic_type() {
            return MagneticType.PARAMAGNETIC;
        }

        @Override
        public int half_life() {
            return 61;
        }

        @Override
        public void radiate() {
            System.out.println(super.toString() + " emitting radiation");
        }
    }
}