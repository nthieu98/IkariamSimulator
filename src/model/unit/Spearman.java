package model.unit;

public class Spearman extends LightInfantry {

    public static final float accuracy = 0.7f;
    private String imageUrl = "/image/SpearmanBB.png";

    public Spearman() {
        hitPoint = 13;
        damage = 4;
        armour = 0;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
