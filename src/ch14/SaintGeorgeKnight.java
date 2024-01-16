package ch14;

/**
 * Showcases a Singleton Design Pattern.
 */
public class SaintGeorgeKnight {
    private static final SaintGeorgeKnight instance = new SaintGeorgeKnight();

    private SaintGeorgeKnight() {
    }

    public static SaintGeorgeKnight getKnight() {
        return instance;
    }

    public void embarkOnMission() {
        System.out.println("Saint George rides to battle");
    }
}
