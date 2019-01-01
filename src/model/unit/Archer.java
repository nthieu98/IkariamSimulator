package model.unit;

public class Archer extends UnitMunition {

    public static final int size = 1;
    public static int nearHit = 5;
    public static final float accuracyNearHit = 0.6f;
    public static final float accuracyLongHit = 0.4f;
    public static String imageUrl = "/image/ArcherBB.png";

    public Archer() {
        hitPoint = 16;
        munition = 3;
        damage = 5;
        armour = 0;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
