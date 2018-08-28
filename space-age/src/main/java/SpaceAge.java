class SpaceAge {

    public static final int EARTH_ORBIT = 31_557_600;
    public static final double MERCURY_ORBIT = 0.2408467;
    public static final double VENUS_ORBIT = 0.61519726;
    public static final double MARS_ORBIT = 1.8808158;
    public static final double JUPITER_ORBIT = 11.862615;
    public static final double SATURN_ORBIT = 29.447498;
    public static final double URANUS_ORBIT = 84.016846;
    public static final double NEPTUNE_ORBIT = 164.79132;

    private double seconds;

    SpaceAge(double seconds) {
        this.seconds = seconds;
    }

    double getSeconds() {
        return seconds;
    }

    double onEarth() {
        return getSeconds() / EARTH_ORBIT;
    }

    double onMercury() {
        return onEarth() / MERCURY_ORBIT;
    }

    double onVenus() {
        return onEarth() / VENUS_ORBIT;
    }

    double onMars() {
        return onEarth() / MARS_ORBIT;
    }

    double onJupiter() {
        return onEarth() / JUPITER_ORBIT;
    }

    double onSaturn() {
        return onEarth() / SATURN_ORBIT;
    }

    double onUranus() {
        return onEarth() / URANUS_ORBIT;
    }

    double onNeptune() {
        return onEarth() / NEPTUNE_ORBIT;
    }

}
