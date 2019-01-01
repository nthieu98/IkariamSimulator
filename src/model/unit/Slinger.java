package model.unit;

public class Slinger extends LongRangeFighter {

    public static final int size = 1;
    public static int nearHit = 2;
    public static final float accuracyNearHit = 0.6f;
    public static final float accuracyLongHit = 0.2f;
    private String imageUrl = "/image/SlingerBB.png";

    public Slinger() {
        hitPoint = 8;
        munition = 5;
        damage = 3;
        armour = 0;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
