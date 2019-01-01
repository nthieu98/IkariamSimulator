package model.unit;

public class BalloonBombardier extends AirDefence {

    public static final int speed = 20;
    public static final int size = 2;
    public static final float accuracy = 0.2f;
    private String imageUrl = "/image/Balloon-BombardierBB.png";

    public BalloonBombardier() {
        hitPoint = 40;
        munition = 2;
        damage = 48;
        armour = 0;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
