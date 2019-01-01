package model.unit;

public class BatteringRam extends Artillery{

    public static final int armour = 1;
    public static final int speed = 40;
    public static final int size = 5;
    public static int nearHit = 12;
    public static final float accuracyNearHit = 0.7f;
    public static int longHit = 80;
    public static final float accuracyLongHit = 0.1f;
    private String imageUrl = "/image/RamBB.png";

    public BatteringRam() {
        hitPoint = 88;
        munition = 999;
    }

}
