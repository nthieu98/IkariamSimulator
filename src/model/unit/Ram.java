/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.unit;

/**
 *
 * @author maidoanh
 */
public class Ram extends Artillery{

    public static final int speed = 40;
    public static final int size = 5;
    public static int nearHit = 10;
    public static float accuracyNearHit = 0.2f;
    public static float accuracyLongHit = 0.1f;
    private String imageUrl = "/image/RamBB.png";

    public Ram() {
        hitPoint = 88;
        munition = 0;
        armour = 1;
        damage = 270;
    }

    public String getImageUrl() {
        return imageUrl;
    }


}
