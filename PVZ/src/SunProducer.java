interface SunProducer {
    int produce_sun();
}

interface PlantUpgrade {
    int concurrentSunCost();
}

interface Attacker{
    int attack();
    int rangetype();
}
// add more interfaces here
interface InstantKiller{
    int killType();
}
interface Upgradable{
    PlantUpgrade upgrade();
}