package model.unit;

public class Mortar extends Artillery {

    public static final int speed = 40;
    public static final int size = 5;
    public static int nearHit = 10;
    public static final float accuracyNearHit = 0.2f;
    public static final float accuracyLongHit = 0.1f;
    private String imageUrl = "/image/MortarBB.png";

    public Mortar() {
        hitPoint = 32;
        munition = 3;
        armour = 0;
        damage = 270;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
