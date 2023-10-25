public interface Conductive {
    float percent_conductive();
}
interface Magnetic {
    int magnetic_strength();
    MagneticType magnetic_type();
}
interface Radioactive {
    int half_life();
    void radiate();
}
enum MagneticType {
    FERROMAGNETIC, PARAMAGNETIC;
}