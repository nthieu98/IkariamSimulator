package model.unit;

public class SulphurCarabineer extends LongRangeFighter {

	public static final int size = 4;
	public static final int nearHit = 3;
	public static final float accuracyNearHit = 0.6f;
	public static final float accuracyLongHit = 0.7f;
        private String imageUrl = "/image/SulphurCarabineerBB.png";


    public SulphurCarabineer() {
        hitPoint = 12;
        munition = 3;
        damage = 29;
        armour = 0;
    }
    public String getImageUrl() {
        return imageUrl;
    }



}
