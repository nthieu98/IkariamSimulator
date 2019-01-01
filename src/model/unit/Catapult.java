package model.unit;

public class Catapult extends Artillery {

    public static final int speed = 40;
    public static final int size = 5;
    public static int nearHit = 4;
    public static final float accuracyNearHit = 0.2f;
    public static final float accuracyLongHit = 0.1f;
    private String imageUrl = "/image/CatapultBB.png";

    public Catapult() {
        munition = 5;
        hitPoint = 54;
        armour = 0;
        damage = 133;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
