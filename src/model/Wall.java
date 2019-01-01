/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.unit.UnitFighter;

/**
 *
 * @author admin
 */
public class Wall extends UnitFighter{

    private int level;
    private int garisionLimit;
    private float accuracy;
    public static String imageUrl = "/image/wall.png";
    private int size;

    public Wall(int level) {
        this.level = level;
        setAtributeByLevel();
    }

    public void setAtributeByLevel() {
        if (level == 0) {
            garisionLimit = 300;
            hitPoint = 0;
            armour = 0;
            damage = 0;
            accuracy = 0;
        } else {
            garisionLimit = 300 + level * 50;
            hitPoint = 150 + 50 * (level - 1);
            armour = 4 * level;
        }
        if (level > 0 && level < 10) {
            damage = 12 + 2 * (level - 1);
            accuracy = 0.3f;
        } else if (level >= 10 && level < 20) {
            damage = 80 + (level - 10) * 5;
            accuracy = 0.5f;

        } else if (level >= 20) {
            damage = 250 + (level - 20) * 10;
            accuracy = 0.8f;
        }
        if(level<17)
            size = 30;
        else if(size<25)
            size = 40;
        else
            size = 50;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getGarisionLimit() {
        return garisionLimit;
    }

    public float getAccuracy() {
        return accuracy;
    }

    public static String getImageUrl() {
        return imageUrl;
    }

    public static void setImageUrl(String imageUrl) {
        Wall.imageUrl = imageUrl;
    }



}
