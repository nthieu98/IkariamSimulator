package model.unit;

public class Hoplite extends HeavyInfantry {

    public static final int speed = 60;
    public static final int size = 1;
    public static final float accuracy = 0.9f;
    public String imageUrl = "/image/HopliteBB.png";

    public Hoplite() {
        hitPoint = 56;
        armour = 1;
        damage = 18;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
