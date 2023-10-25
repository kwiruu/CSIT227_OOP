public abstract class Element implements Comparable<Element> {
    private final int atomic_number;
    private final String element_symbol, element_name;
    private final double atomic_weight;

    public Element(int atomic_number, String element_symbol, String element_name, double atomic_weight) {
        this.atomic_number = atomic_number;
        this.element_symbol = element_symbol;
        this.element_name = element_name;
        this.atomic_weight = atomic_weight;
    }

    public int getAtomic_number() {
        return atomic_number;
    }

    public String getElement_symbol() {
        return element_symbol;
    }

    public String getElement_name() {
        return element_name;
    }

    public double getAtomic_weight() {
        return atomic_weight;
    }

    @Override
    public int compareTo(Element o) {
        return Double.compare(this.atomic_weight, o.atomic_weight);
    }

    @Override
    public String toString() {
        return getAtomic_number() + " " +
                getElement_name() + " (" +
                getElement_symbol() + ")";
    }

    public abstract ElementState state (float temperature);

    enum ElementState {
        SOLID, LIQUID, GAS
    }
}