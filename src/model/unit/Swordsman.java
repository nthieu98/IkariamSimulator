package model.unit;

public class Swordsman  extends UnitFighter{

	public static final float accuracy = 0.9f;
        public static final int speed = 60;
	public static final int size = 1;
        private String imageUrl = "/image/SwordsmanBB.png";


    public Swordsman() {
        hitPoint = 18;
        damage = 10;
        armour = 0;
    }

    public String getImageUrl() {
        return imageUrl;
    }




}
